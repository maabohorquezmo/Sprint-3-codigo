/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entidad.Recibo;
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
public class ReciboDAO {
    private static EntityManagerFactory
            emf= Persistence.createEntityManagerFactory("SIG-TerpelPU");
    
    public void crear(Recibo object){
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
    public boolean eliminar(Recibo p){
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret=false;
        Recibo object= new Recibo();
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

    public Recibo leerID(Recibo par){
        EntityManager em=emf.createEntityManager();
        Recibo emp= null;
        Query q= em.createQuery("SELECT u FROM Recibo u "+
                "WHERE u.id = :id")
                .setParameter("id", par.getId());
        try{
            emp=(Recibo)q.getSingleResult();
        }catch(NonUniqueResultException e){
            emp=(Recibo)q.getResultList().get(0);
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return emp;
        }
    }
    
    public List <Recibo> ventasEmpleado(String cedula){
        EntityManager em=emf.createEntityManager();
        List <Recibo> recibo= null;
        Query q= em.createQuery("SELECT r FROM Recibo r "+
                "WHERE r.empleado = :cedula")
                .setParameter("cedula", cedula);
        try{
            recibo=(List)q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return recibo;
        }
    }
    
    public List <Recibo> comprasCliente(String cedula){
        EntityManager em=emf.createEntityManager();
        List <Recibo> recibo= null;
        Query q= em.createQuery("SELECT r FROM Recibo r "+
                "WHERE r.cedula = :cedula")
                .setParameter("cedula", cedula);
        try{
            recibo=(List)q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
            
        }finally{
            em.close();
            return recibo;
        }
    }
    
    
}
