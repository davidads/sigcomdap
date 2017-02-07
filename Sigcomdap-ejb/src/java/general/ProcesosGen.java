/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import entidades.Catalogodeta;
import entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jos
 */
@Stateless
public class ProcesosGen implements ProcesosGenLocal {

    @PersistenceContext(unitName = "Sigcomdap-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public List<Persona> llenarLista() {
        List<Persona> personas = new ArrayList<>();
        try {

            String sql = "SELECT a FROM Persona a"
                    + " WHERE 1=1";
            Query q = em.createQuery(sql);
            personas = (List<Persona>) q.getResultList();

        } catch (NoResultException nr) {
            Logger.getLogger(ProcesosGen.class.getName()).log(Level.SEVERE,
                    "Error en llenarLista()", nr);
        } catch (Exception e) {
            Logger.getLogger(ProcesosGen.class.getName()).log(Level.SEVERE,
                    "Error en llenarLista()", e);
        }
        return personas;
    }

    @Override
    public List<Persona> buscarPersonas(Map filtro) throws Exception {
        List<Persona> lista = new ArrayList();
        try {
            Integer codper = null;
            String dui = null;
            StringBuilder sql = new StringBuilder("SELECT object(a) FROM  Persona a ");
            sql.append("WHERE 1=1 ");
            if (filtro.containsKey("codper")) {
                codper = (Integer) filtro.get("codper");
                sql.append("AND a.codper = :codper ");
            }
            if (filtro.containsKey("dui")) {
                dui = filtro.get("dui").toString();
                sql.append("AND a.dui = :dui ");
            }
            if (filtro.containsKey("nombre1")) {
                sql.append("AND UPPER(a.nombre1) like :nombre1 ");
            }
            if (filtro.containsKey("apellido1")) {
                sql.append("AND UPPER(a.apellido1) like :apellido1 ");
            }

            sql.append(" ORDER BY a.codper");

            Query q = em.createQuery(sql.toString());
            if (filtro.containsKey("codper")) {
                q.setParameter("codper", codper);
            }
            if (filtro.containsKey("dui")) {
                q.setParameter("dui", dui);
            }
            if (filtro.containsKey("nombre1")) {
                q.setParameter("nombre1",
                        "%" + filtro.get("nombre1").toString().toUpperCase() + "%");
            }
            if (filtro.containsKey("apellido1")) {
                q.setParameter("apellido1",
                        "%" + filtro.get("apellido1").toString().toUpperCase() + "%");
            }

            lista = (List<Persona>) q.getResultList();
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(ProcesosGen.class.getName()).log(Level.SEVERE, "Error en buscarPersonas(): {0}", ex);
            throw new Exception(ex);
        }

    }

    @Override
    public List<Catalogodeta> buscarCatalogo(Integer codigo) throws Exception {
        List<Catalogodeta> lista = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder("SELECT object(a) FROM  Catalogodeta a ");
            sql.append("WHERE 1=1 ");
            sql.append("AND a.catalogodetaPK.codcat = :codigo ");
            sql.append(" ORDER BY a.catalogodetaPK.codcat");
            Query q = em.createQuery(sql.toString());

            q.setParameter("codigo", codigo);

            lista = (List<Catalogodeta>) q.getResultList();
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(ProcesosGen.class.getName()).log(Level.SEVERE, "Error en buscarCatalogo(): {0}", ex);
            throw new Exception(ex);
        }

    }

    /**
     * Método que permite guardar una entidad.
     *
     * @param entidad Tipo Object.
     * @param isflush True si se habilita el flush Caso Contrario False
     * @return
     * @throws java.lang.Exception Excepción genérica.
     */
    @Override
    public final Object guardarEntidad(Object entidad,
            final boolean isflush)
            throws Exception {
        try {

           
            //em.persist(entidad);
            em.merge(entidad);
            if (isflush) {
                em.flush();
            }

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error en metodo guardarEntidad. Detalle [{0}]", e);
            throw e;
        }
        return entidad;
    }

    @Override
    public Catalogodeta buscarCatalogodeta(Integer codcat, Integer codcor) throws Exception {
        try {
            StringBuilder sql = new StringBuilder("SELECT object(a) FROM  Catalogodeta a ");
            sql.append("WHERE 1=1 ");
            sql.append("AND a.catalogodetaPK.codcat = :codcat ");
            sql.append("AND a.catalogodetaPK.corcat = :codcor ");
            Query q = em.createQuery(sql.toString());

            q.setParameter("codcat", codcat);
            q.setParameter("codcor", codcor);          
            return  (Catalogodeta) q.getSingleResult();
            
        } catch (Exception ex) {
            Logger.getLogger(ProcesosGen.class.getName()).log(Level.SEVERE, "Error en buscarCatalogodeta(): {0}", ex);
            throw new Exception(ex);
        }
    }

}
