/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jos
 */
@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByCodper", query = "SELECT p FROM Persona p WHERE p.codper = :codper")
    , @NamedQuery(name = "Persona.findByNomcom", query = "SELECT p FROM Persona p WHERE p.nomcom = :nomcom")
    , @NamedQuery(name = "Persona.findByNombre1", query = "SELECT p FROM Persona p WHERE p.nombre1 = :nombre1")
    , @NamedQuery(name = "Persona.findByNombre2", query = "SELECT p FROM Persona p WHERE p.nombre2 = :nombre2")
    , @NamedQuery(name = "Persona.findByApellido1", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1")
    , @NamedQuery(name = "Persona.findByApellido2", query = "SELECT p FROM Persona p WHERE p.apellido2 = :apellido2")
    , @NamedQuery(name = "Persona.findByApellidocasada", query = "SELECT p FROM Persona p WHERE p.apellidocasada = :apellidocasada")
    , @NamedQuery(name = "Persona.findByTipo", query = "SELECT p FROM Persona p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Persona.findByRazsocial", query = "SELECT p FROM Persona p WHERE p.razsocial = :razsocial")
    , @NamedQuery(name = "Persona.findByFechanac", query = "SELECT p FROM Persona p WHERE p.fechanac = :fechanac")
    , @NamedQuery(name = "Persona.findByActivo", query = "SELECT p FROM Persona p WHERE p.activo = :activo")
    , @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codper")
    private Integer codper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomcom")
    private String nomcom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre1")
    private String nombre1;
    @Size(max = 25)
    @Column(name = "nombre2")
    private String nombre2;
    @Size(max = 25)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 25)
    @Column(name = "apellido2")
    private String apellido2;
    @Size(max = 25)
    @Column(name = "apellidocasada")
    private String apellidocasada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 255)
    @Column(name = "razsocial")
    private String razsocial;
    @Column(name = "fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Column(name = "activo")
    private Boolean activo;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Personatel> personatelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Personadirecc> personadireccList;

    public Persona() {
    }

    public Persona(Integer codper) {
        this.codper = codper;
    }

    public Persona(Integer codper, String nomcom, String nombre1, String tipo) {
        this.codper = codper;
        this.nomcom = nomcom;
        this.nombre1 = nombre1;
        this.tipo = tipo;
    }

    public Integer getCodper() {
        return codper;
    }

    public void setCodper(Integer codper) {
        this.codper = codper;
    }

    public String getNomcom() {
        return nomcom;
    }

    public void setNomcom(String nomcom) {
        this.nomcom = nomcom;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellidocasada() {
        return apellidocasada;
    }

    public void setApellidocasada(String apellidocasada) {
        this.apellidocasada = apellidocasada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRazsocial() {
        return razsocial;
    }

    public void setRazsocial(String razsocial) {
        this.razsocial = razsocial;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<Personatel> getPersonatelList() {
        return personatelList;
    }

    public void setPersonatelList(List<Personatel> personatelList) {
        this.personatelList = personatelList;
    }

    public List<Personadirecc> getPersonadireccList() {
        return personadireccList;
    }

    public void setPersonadireccList(List<Personadirecc> personadireccList) {
        this.personadireccList = personadireccList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codper != null ? codper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codper == null && other.codper != null) || (this.codper != null && !this.codper.equals(other.codper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Persona[ codper=" + codper + " ]";
    }
    
}
