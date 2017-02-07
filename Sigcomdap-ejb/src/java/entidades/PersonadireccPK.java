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
public class PersonadireccPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codper")
    private int codper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cattipodir")
    private int cattipodir;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cortipodir")
    private int cortipodir;

    public PersonadireccPK() {
    }

    public PersonadireccPK(int codper, short cattipodir, short cortipodir) {
        this.codper = codper;
        this.cattipodir = cattipodir;
        this.cortipodir = cortipodir;
    }

    public int getCodper() {
        return codper;
    }

    public void setCodper(int codper) {
        this.codper = codper;
    }

    public int getCattipodir() {
        return cattipodir;
    }

    public void setCattipodir(int cattipodir) {
        this.cattipodir = cattipodir;
    }

    public int getCortipodir() {
        return cortipodir;
    }

    public void setCortipodir(int cortipodir) {
        this.cortipodir = cortipodir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codper;
        hash += (int) cattipodir;
        hash += (int) cortipodir;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonadireccPK)) {
            return false;
        }
        PersonadireccPK other = (PersonadireccPK) object;
        if (this.codper != other.codper) {
            return false;
        }
        if (this.cattipodir != other.cattipodir) {
            return false;
        }
        if (this.cortipodir != other.cortipodir) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.PersonadireccPK[ codper=" + codper + ", cattipodir=" + cattipodir + ", cortipodir=" + cortipodir + " ]";
    }
    
}
