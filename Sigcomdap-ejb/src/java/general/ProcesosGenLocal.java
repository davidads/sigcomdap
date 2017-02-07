/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import entidades.Catalogodeta;
import entidades.Persona;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author jos
 */
@Local
public interface ProcesosGenLocal {

    public List<Persona> llenarLista();

    public List<Persona> buscarPersonas(Map filtro) throws Exception;

    public List<Catalogodeta> buscarCatalogo(Integer codigo) throws Exception;
    
     public Catalogodeta buscarCatalogodeta(Integer codcat, Integer codcor) throws Exception;

    public Object guardarEntidad(Object entidad, final boolean isflush) throws Exception;
    
}
