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
public class PersonatelPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codper")
    private int codper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cattipo")
    private int cattipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cortipo")
    private int cortipo;

    public PersonatelPK() {
    }

    public PersonatelPK(int codper, int cattipo, int cortipo) {
        this.codper = codper;
        this.cattipo = cattipo;
        this.cortipo = cortipo;
    }

    public int getCodper() {
        return codper;
    }

    public void setCodper(int codper) {
        this.codper = codper;
    }

    public int getCattipo() {
        return cattipo;
    }

    public void setCattipo(int cattipo) {
        this.cattipo = cattipo;
    }

    public int getCortipo() {
        return cortipo;
    }

    public void setCortipo(int cortipo) {
        this.cortipo = cortipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codper;
        hash += (int) cattipo;
        hash += (int) cortipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonatelPK)) {
            return false;
        }
        PersonatelPK other = (PersonatelPK) object;
        if (this.codper != other.codper) {
            return false;
        }
        if (this.cattipo != other.cattipo) {
            return false;
        }
        if (this.cortipo != other.cortipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PersonatelPK[ codper=" + codper + ", cattipo=" + cattipo + ", cortipo=" + cortipo + " ]";
    }
    
}
