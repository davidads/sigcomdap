/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author jos
 */
@Entity
@Table(name = "personadirecc")
@NamedQueries({
    @NamedQuery(name = "Personadirecc.findAll", query = "SELECT p FROM Personadirecc p")
    , @NamedQuery(name = "Personadirecc.findByCodper", query = "SELECT p FROM Personadirecc p WHERE p.personadireccPK.codper = :codper")
    , @NamedQuery(name = "Personadirecc.findByCattipodir", query = "SELECT p FROM Personadirecc p WHERE p.personadireccPK.cattipodir = :cattipodir")
    , @NamedQuery(name = "Personadirecc.findByCortipodir", query = "SELECT p FROM Personadirecc p WHERE p.personadireccPK.cortipodir = :cortipodir")
    , @NamedQuery(name = "Personadirecc.findByDireccion", query = "SELECT p FROM Personadirecc p WHERE p.direccion = :direccion")})
public class Personadirecc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonadireccPK personadireccPK;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumns({
        @JoinColumn(name = "cattipodir", referencedColumnName = "codcat", insertable = false, updatable = false)
        , @JoinColumn(name = "cortipodir", referencedColumnName = "corcat", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogodeta tipoDirecc;
    @JoinColumn(name = "codper", referencedColumnName = "codper", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Personadirecc() {
    }

    public Personadirecc(PersonadireccPK personadireccPK) {
        this.personadireccPK = personadireccPK;
    }

    public Personadirecc(int codper, short cattipodir, short cortipodir) {
        this.personadireccPK = new PersonadireccPK(codper, cattipodir, cortipodir);
    }

    public PersonadireccPK getPersonadireccPK() {
        return personadireccPK;
    }

    public void setPersonadireccPK(PersonadireccPK personadireccPK) {
        this.personadireccPK = personadireccPK;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Catalogodeta getTipoDirecc() {
        return tipoDirecc;
    }

    public void setTipoDirecc(Catalogodeta tipoDirecc) {
        this.tipoDirecc = tipoDirecc;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personadireccPK != null ? personadireccPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personadirecc)) {
            return false;
        }
        Personadirecc other = (Personadirecc) object;
        if ((this.personadireccPK == null && other.personadireccPK != null) || (this.personadireccPK != null && !this.personadireccPK.equals(other.personadireccPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Personadirecc[ personadireccPK=" + personadireccPK + " ]";
    }
    
}
