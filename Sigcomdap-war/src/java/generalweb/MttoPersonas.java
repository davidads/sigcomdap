/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalweb;

import entidades.Catalogodeta;
import entidades.Persona;
import entidades.Personadirecc;
import entidades.PersonadireccPK;
import entidades.Personatel;
import entidades.PersonatelPK;
import general.ProcesosGenLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author jos
 */
@Named(value = "mttoPersonas")
@SessionScoped
public class MttoPersonas implements Serializable {

    @EJB
    private ProcesosGenLocal procesosGen;

    /**
     * Creates a new instance of MttoPersonas
     */
    public MttoPersonas() {
    }

    //Campos de búsqueda
    private String duiB;
    private String nombre1B;
    private String nombre2B;
    private String apellido1B;
    private String apellido2B;

    private Persona persona = new Persona();
    boolean nuevaPersona = false;

    private Integer tipoTel;
    private Integer tipoDir;
    private Personatel telefono;
    private Personadirecc nuevaDireccion;

    private Integer codper;
    private String nombre1P;
    private String nombre2P;
    private String apellido1P;
    private String apellido2P;
    private String numeroDoc;
    private String numeroTel;
    private String nuevaDirecc;
    Date fechaNacP;
    Integer codperNew;
    String sexo;
    String tipoPer;

    int tabindex = 0;

    List<SelectItem> tipotelLst = new ArrayList<>();
    List<SelectItem> tipoDireccLst = new ArrayList<>();
    List<Personatel> personaTelList = new ArrayList<>();
    List<Personadirecc> personaDireccList = new ArrayList<>();

    private List<Persona> lstPersonas = new ArrayList<>();

    public String getDuiB() {
        return duiB;
    }

    public void setDuiB(String duiB) {
        this.duiB = duiB;
    }

    public Integer getCodper() {
        return codper;
    }

    public void setCodper(Integer codper) {
        this.codper = codper;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getNombre1B() {
        return nombre1B;
    }

    public void setNombre1B(String nombre1B) {
        this.nombre1B = nombre1B;
    }

    public String getApellido1B() {
        return apellido1B;
    }

    public void setApellido1B(String apellido1B) {
        this.apellido1B = apellido1B;
    }

    public String getNombre2B() {
        return nombre2B;
    }

    public void setNombre2B(String nombre2B) {
        this.nombre2B = nombre2B;
    }

    public String getApellido2B() {
        return apellido2B;
    }

    public void setApellido2B(String apellido2B) {
        this.apellido2B = apellido2B;
    }

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public int getTabindex() {
        return tabindex;
    }

    public void setTabindex(int tabindex) {
        this.tabindex = tabindex;
    }

    public Personatel getTelefono() {
        return telefono;
    }

    public void setTelefono(Personatel telefono) {
        this.telefono = telefono;
    }

    public Personadirecc getNuevaDireccion() {
        return nuevaDireccion;
    }

    public void setNuevaDireccion(Personadirecc nuevaDireccion) {
        this.nuevaDireccion = nuevaDireccion;
    }

    public Integer getTipoTel() {
        return tipoTel;
    }

    public void setTipoTel(Integer tipoTel) {
        this.tipoTel = tipoTel;
    }

    public Integer getTipoDir() {
        return tipoDir;
    }

    public void setTipoDir(Integer tipoDir) {
        this.tipoDir = tipoDir;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getNuevaDirecc() {
        return nuevaDirecc;
    }

    public void setNuevaDirecc(String nuevaDirecc) {
        this.nuevaDirecc = nuevaDirecc;
    }

    public List<SelectItem> getTipotelLst() {
        try {
            tipotelLst.clear();
            for (Catalogodeta catalogo : this.procesosGen.buscarCatalogo(1)) {
                tipotelLst.add(new SelectItem(
                        catalogo.getCatalogodetaPK().getCorcat(), catalogo.getDescripcion()));
            }
        } catch (Exception ex) {
            Logger.getLogger(MttoPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipotelLst;
    }

    public List<SelectItem> getTipoDireccLst() {

        try {
            tipoDireccLst.clear();
            for (Catalogodeta catalogo : this.procesosGen.buscarCatalogo(2)) {
                tipoDireccLst.add(new SelectItem(
                        catalogo.getCatalogodetaPK().getCorcat(), catalogo.getDescripcion()));
            }
        } catch (Exception ex) {
            Logger.getLogger(MttoPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tipoDireccLst;
    }

    public String getNombre1P() {
        return nombre1P;
    }

    public void setNombre1P(String nombre1P) {
        this.nombre1P = nombre1P;
    }

    public String getNombre2P() {
        return nombre2P;
    }

    public void setNombre2P(String nombre2P) {
        this.nombre2P = nombre2P;
    }

    public String getApellido1P() {
        return apellido1P;
    }

    public void setApellido1P(String apellido1P) {
        this.apellido1P = apellido1P;
    }

    public String getApellido2P() {
        return apellido2P;
    }

    public void setApellido2P(String apellido2P) {
        this.apellido2P = apellido2P;
    }

    public Date getFechaNacP() {
        return fechaNacP;
    }

    public void setFechaNacP(Date fechaNacP) {
        this.fechaNacP = fechaNacP;
    }

    public Integer getCodperNew() {
        return codperNew;
    }

    public void setCodperNew(Integer codperNew) {
        this.codperNew = codperNew;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipoPer() {
        return tipoPer;
    }

    public void setTipoPer(String tipoPer) {
        this.tipoPer = tipoPer;
    }

    public void setTipotelLst(List<SelectItem> tipotelLst) {
        this.tipotelLst = tipotelLst;
    }

    public List<Personatel> getPersonaTelList() {
        return personaTelList;
    }

    public void setPersonaTelList(List<Personatel> personaTelList) {
        this.personaTelList = personaTelList;
    }

    public List<Personadirecc> getPersonaDireccList() {
        return personaDireccList;
    }

    public void setPersonaDireccList(List<Personadirecc> personaDireccList) {
        this.personaDireccList = personaDireccList;
    }

    public void buscar() {

        try {
            Map filtro = new HashMap();

            if (duiB != null && !duiB.isEmpty()) {
                filtro.put("dui", duiB);
            }
            if (nombre1B != null && !nombre1B.isEmpty()) {
                filtro.put("nombre1", nombre1B);
            }
            if (apellido1B != null && !apellido1B.isEmpty()) {
                filtro.put("apellido1", apellido1B);
            }

            lstPersonas = procesosGen.buscarPersonas(filtro);

        } catch (Exception ex) {
            Logger.getLogger(MttoPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void nuevaPersona() {

        try {
            nuevaPersona = true;
            this.persona = new Persona();

            limpiarPersona();

        } catch (Exception ex) {
            Logger.getLogger(MttoPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void agregarTelefono() {

        try {
            telefono = new Personatel();
            PersonatelPK pktel = new PersonatelPK();
            pktel.setCodper(persona.getCodper());
            pktel.setCattipo(Integer.parseInt("1"));
            pktel.setCortipo(this.tipoTel);
            telefono.setPersonatelPK(pktel);
            telefono.setTipoTel(this.procesosGen.buscarCatalogodeta(1, tipoTel));
            telefono.setNumero(numeroTel);
            if (!personaTelList.contains(telefono)) {
                personaTelList.add(telefono);
            }
        } catch (Exception ex) {
            Logger.getLogger(MttoPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void agregarDireccion() {

        try {
            Personadirecc dir = new Personadirecc();
            PersonadireccPK pkdir = new PersonadireccPK();
            pkdir.setCodper(persona.getCodper());
            pkdir.setCattipodir(Integer.parseInt("2"));
            pkdir.setCortipodir(this.tipoDir);
            dir.setPersonadireccPK(pkdir);
            dir.setTipoDirecc(this.procesosGen.buscarCatalogodeta(2, tipoDir));
            dir.setDireccion(nuevaDirecc);
            if (!personaDireccList.contains(dir)) {
                personaDireccList.add(dir);
            }
        } catch (Exception ex) {
            Logger.getLogger(MttoPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void guardarPersona() {
        try {

            if (nuevaPersona) {
                this.persona = new Persona();
            }
            this.persona.setCodper(codper);
            this.persona.setNombre1(nombre1P);
            this.persona.setNombre2(nombre2P);
            this.persona.setApellido1(apellido1P);
            this.persona.setApellido2(apellido2P);
            this.persona.setFechanac(fechaNacP);
            this.persona.setTipo(tipoPer);
            this.persona.setSexo(sexo);
            this.persona.setNomcom(persona.getNombre1() + " "
                    + persona.getNombre2() + " " + persona.getApellido1()
                    + " " + persona.getApellido2());

            this.persona.setPersonadireccList(personaDireccList);
            this.persona.setPersonatelList(personaTelList);

            this.procesosGen.guardarEntidad(persona, false);

        } catch (Exception ex) {
            Logger.getLogger(MttoPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void limpiarBusqueda() {
        lstPersonas = new ArrayList<>();
        duiB = "";
        codper = null;
        nombre1B = "";
        apellido1B = "";
        nombre2B = "";
        apellido2B = "";
    }

    public void limpiarPersona() {
        this.personaTelList = new ArrayList<>();
        this.personaDireccList = new ArrayList<>();
        codper = null;
        nombre1P = "";
        nombre2P = "";
        apellido1P = "";
        apellido2P = "";
        fechaNacP = null;

        tipoDir = 0;
        tipoTel = 0;
        tipoPer = "";
        sexo = "";
        nuevaDirecc = "";
        numeroTel = "";

    }

    public void onRowSelect(SelectEvent event) throws IOException {
        try {
            limpiarPersona();
            codper = persona.getCodper();
            nombre1P = persona.getNombre1();
            nombre2P = persona.getNombre2();
            apellido1P = persona.getApellido1();
            apellido2P = persona.getApellido2();
            fechaNacP = persona.getFechanac();
            personaTelList = persona.getPersonatelList();
            personaDireccList = persona.getPersonadireccList();
            sexo = persona.getSexo();
            tipoPer = persona.getTipo();
            tabindex = 1;
        } catch (Exception ex) {
            Logger.getLogger(MttoPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowUnselect(UnselectEvent event) {
        persona = new Persona();
    }

    public void onTabChange(TabChangeEvent event) {
        this.tabindex = ((TabView) event.getSource()).getIndex();
    }
}
