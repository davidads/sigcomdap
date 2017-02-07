/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jos
 */
@Embeddable
public class CatalogodetaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codcat")
    private short codcat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "corcat")
    private short corcat;

    public CatalogodetaPK() {
    }

    public CatalogodetaPK(short codcat, short corcat) {
        this.codcat = codcat;
        this.corcat = corcat;
    }

    public short getCodcat() {
        return codcat;
    }

    public void setCodcat(short codcat) {
        this.codcat = codcat;
    }

    public short getCorcat() {
        return corcat;
    }

    public void setCorcat(short corcat) {
        this.corcat = corcat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codcat;
        hash += (int) corcat;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogodetaPK)) {
            return false;
        }
        CatalogodetaPK other = (CatalogodetaPK) object;
        if (this.codcat != other.codcat) {
            return false;
        }
        if (this.corcat != other.corcat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CatalogodetaPK[ codcat=" + codcat + ", corcat=" + corcat + " ]";
    }
    
}
