/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jos
 */
@Entity
@Table(name = "personatels")

public class Personatel implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PersonatelPK personatelPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "codper", referencedColumnName = "codper", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    @JoinColumns({
        @JoinColumn(name = "CATTIPO", referencedColumnName = "CODCAT", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "CORTIPO", referencedColumnName = "CORCAT", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogodeta tipoTel;

    public Personatel() {
    }

    public Personatel(PersonatelPK personatelPK) {
        this.personatelPK = personatelPK;
    }

    public Personatel(PersonatelPK personatelPK, String numero) {
        this.personatelPK = personatelPK;
        this.numero = numero;
    }

    public Personatel(int codper, int cattipo, int cortipo) {
        this.personatelPK = new PersonatelPK(codper, cattipo, cortipo);
    }

    public PersonatelPK getPersonatelPK() {
        return personatelPK;
    }

    public void setPersonatelPK(PersonatelPK personatelPK) {
        this.personatelPK = personatelPK;
    }

    public Catalogodeta getTipoTel() {
        return tipoTel;
    }

    public void setTipoTel(Catalogodeta tipoTel) {
        this.tipoTel = tipoTel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
        hash += (personatelPK != null ? personatelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personatel)) {
            return false;
        }
        Personatel other = (Personatel) object;
        if ((this.personatelPK == null && other.personatelPK != null) || (this.personatelPK != null && !this.personatelPK.equals(other.personatelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Personatel[ personatelPK=" + personatelPK + " ]";
    }

}
