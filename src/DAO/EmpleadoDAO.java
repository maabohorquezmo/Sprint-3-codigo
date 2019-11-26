/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidad.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author User
 */
public class EmpleadoDAO {
    private static EntityManagerFactory
            emf= Persistence.createEntityManagerFactory("SIG-TerpelPU");
    
    public void crear(Empleado object){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(object);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    public boolean eliminar(Empleado p){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret=false;
        Empleado object= new Empleado();
        object= leerID(p);
        try{
            if(!em.contains(object)){
                object = em.merge(object);
            }
            em.remove(object);
            em.getTransaction().commit();
            ret=true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }
    
    public Empleado leerCED(Empleado par){
        EntityManager em=emf.createEntityManager();
        Empleado emp= null;
        Query q= em.createQuery("SELECT empleados FROM Empleado empleados "+
                "WHERE empleados.cedula = :cedula")
                .setParameter("cedula", par.getCedula());
        try{
            emp=(Empleado)q.getSingleResult();
        }catch(NonUniqueResultException e){
            emp=(Empleado)q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return emp;
        }
    }
    
    public Empleado leerID(Empleado par){
        EntityManager em=emf.createEntityManager();
        Empleado emp= null;
        Query q= em.createQuery("SELECT u FROM Empleado u "+
                "WHERE u.id = :id")
                .setParameter("id", par.getId());
        try{
            emp=(Empleado)q.getSingleResult();
        }catch(NonUniqueResultException e){
            emp=(Empleado)q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return emp;
        }
    }
    public Empleado verificarUsuario(Empleado par){
        EntityManager em=emf.createEntityManager();
        Empleado emp= null;
        Query q;
        q = em.createQuery("SELECT u FROM Empleado u "+
                "WHERE u.nombre = :nombre " +
                "AND u.contraseña = :contraseña")
                .setParameter("nombre", par.getNombre())
                .setParameter("contraseña", par.getContraseña());
        try{
            emp=(Empleado)q.getSingleResult();
        }catch(NonUniqueResultException e){
            emp=(Empleado)q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return emp;
        }
    }
    
    public List <Empleado> leerEMP(){
        EntityManager em=emf.createEntityManager();
        List <Empleado> listado= null;
        Query q= em.createQuery("SELECT empleados FROM Empleado empleados ");
        try{
            listado=(List)q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return listado;
        }
    }
    
    public boolean actualizarEDIT(Empleado object, String nombrenuevo,String apellidonuevo, int cedula){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret=false;
        try{
            object= leerID(object);
            if(nombrenuevo!=null){
                object.setNombre(nombrenuevo);
            }
            if(apellidonuevo!=null){
                object.setApellido(apellidonuevo);
            }
            if(cedula!=0){
                object.setCedula(cedula);
            }
            
            em.merge(object);
            em.getTransaction().commit();
            ret=true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }
}
