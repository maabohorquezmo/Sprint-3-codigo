package DAO;

import Entidad.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClienteDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SIG-TerpelPU");

    public void crear(Cliente object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public boolean eliminar(Cliente p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        Cliente object = new Cliente();
        object = leerCED(p);
        try {
            if (!em.contains(object)) {
                object = em.merge(object);
            }
            em.remove(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }

    public Cliente leerCED(Cliente par) {
        EntityManager em = emf.createEntityManager();
        Cliente emp = null;
        Query q = em.createQuery("SELECT clientes FROM Cliente clientes "
                + "WHERE clientes.cedula = :cedula")
                .setParameter("cedula", par.getCedula());
        try {
            emp = (Cliente) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            emp = (Cliente) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return emp;
        }
    }

    public List<Cliente> leerCLIENT() {
        EntityManager em = emf.createEntityManager();
        List<Cliente> listado = null;
        Query q = em.createQuery("SELECT clientes FROM Cliente clientes ");
        try {
            listado = (List) q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            em.close();
            return listado;
        }
    }

    public boolean actualizarEDIT(Cliente object, String nombrenuevo, String apellidonuevo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leerCED(object);
            if (!(nombrenuevo.length()==0)) {
                object.setNombre(nombrenuevo);
            }
            if (!(apellidonuevo.length()==0)) {
                object.setApellido(apellidonuevo);
            }
            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }

    public boolean sumarPuntos(Cliente object, int puntos) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leerCED(object);

            object.setPuntos(object.getPuntos() + puntos);

            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
    
    public boolean restarPuntos(Cliente object, int puntos) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            object = leerCED(object);

            object.setPuntos(object.getPuntos() - puntos);

            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
}
