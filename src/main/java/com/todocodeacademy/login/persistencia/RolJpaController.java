/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todocodeacademy.login.persistencia;

import com.todocodeacademy.login.logica.Rol;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.todocodeacademy.login.logica.Usuario;
import com.todocodeacademy.login.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class RolJpaController implements Serializable {

    public RolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
      public RolJpaController() {
        emf = Persistence.createEntityManagerFactory("loginPU");
    }

    public void create(Rol rol) {
        if (rol.getListaUsuarios() == null) {
            rol.setListaUsuarios(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Usuario> attachedListaUsuarios = new ArrayList<Usuario>();
            for (Usuario listaUsuariosUsuarioToAttach : rol.getListaUsuarios()) {
                listaUsuariosUsuarioToAttach = em.getReference(listaUsuariosUsuarioToAttach.getClass(), listaUsuariosUsuarioToAttach.getId());
                attachedListaUsuarios.add(listaUsuariosUsuarioToAttach);
            }
            rol.setListaUsuarios(attachedListaUsuarios);
            em.persist(rol);
            for (Usuario listaUsuariosUsuario : rol.getListaUsuarios()) {
                Rol oldUnRolOfListaUsuariosUsuario = listaUsuariosUsuario.getUnRol();
                listaUsuariosUsuario.setUnRol(rol);
                listaUsuariosUsuario = em.merge(listaUsuariosUsuario);
                if (oldUnRolOfListaUsuariosUsuario != null) {
                    oldUnRolOfListaUsuariosUsuario.getListaUsuarios().remove(listaUsuariosUsuario);
                    oldUnRolOfListaUsuariosUsuario = em.merge(oldUnRolOfListaUsuariosUsuario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rol rol) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol persistentRol = em.find(Rol.class, rol.getId());
            List<Usuario> listaUsuariosOld = persistentRol.getListaUsuarios();
            List<Usuario> listaUsuariosNew = rol.getListaUsuarios();
            List<Usuario> attachedListaUsuariosNew = new ArrayList<Usuario>();
            for (Usuario listaUsuariosNewUsuarioToAttach : listaUsuariosNew) {
                listaUsuariosNewUsuarioToAttach = em.getReference(listaUsuariosNewUsuarioToAttach.getClass(), listaUsuariosNewUsuarioToAttach.getId());
                attachedListaUsuariosNew.add(listaUsuariosNewUsuarioToAttach);
            }
            listaUsuariosNew = attachedListaUsuariosNew;
            rol.setListaUsuarios(listaUsuariosNew);
            rol = em.merge(rol);
            for (Usuario listaUsuariosOldUsuario : listaUsuariosOld) {
                if (!listaUsuariosNew.contains(listaUsuariosOldUsuario)) {
                    listaUsuariosOldUsuario.setUnRol(null);
                    listaUsuariosOldUsuario = em.merge(listaUsuariosOldUsuario);
                }
            }
            for (Usuario listaUsuariosNewUsuario : listaUsuariosNew) {
                if (!listaUsuariosOld.contains(listaUsuariosNewUsuario)) {
                    Rol oldUnRolOfListaUsuariosNewUsuario = listaUsuariosNewUsuario.getUnRol();
                    listaUsuariosNewUsuario.setUnRol(rol);
                    listaUsuariosNewUsuario = em.merge(listaUsuariosNewUsuario);
                    if (oldUnRolOfListaUsuariosNewUsuario != null && !oldUnRolOfListaUsuariosNewUsuario.equals(rol)) {
                        oldUnRolOfListaUsuariosNewUsuario.getListaUsuarios().remove(listaUsuariosNewUsuario);
                        oldUnRolOfListaUsuariosNewUsuario = em.merge(oldUnRolOfListaUsuariosNewUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = rol.getId();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("The rol with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rol with id " + id + " no longer exists.", enfe);
            }
            List<Usuario> listaUsuarios = rol.getListaUsuarios();
            for (Usuario listaUsuariosUsuario : listaUsuarios) {
                listaUsuariosUsuario.setUnRol(null);
                listaUsuariosUsuario = em.merge(listaUsuariosUsuario);
            }
            em.remove(rol);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Rol findRol(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
