/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jos
 */
@Entity
@Table(name = "catalogodeta")
@NamedQueries({
    @NamedQuery(name = "Catalogodeta.findAll", query = "SELECT c FROM Catalogodeta c")
    , @NamedQuery(name = "Catalogodeta.findByCodcat", query = "SELECT c FROM Catalogodeta c WHERE c.catalogodetaPK.codcat = :codcat")
    , @NamedQuery(name = "Catalogodeta.findByCorcat", query = "SELECT c FROM Catalogodeta c WHERE c.catalogodetaPK.corcat = :corcat")
    , @NamedQuery(name = "Catalogodeta.findByDescripcion", query = "SELECT c FROM Catalogodeta c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Catalogodeta.findByRef1", query = "SELECT c FROM Catalogodeta c WHERE c.ref1 = :ref1")
    , @NamedQuery(name = "Catalogodeta.findByRef2", query = "SELECT c FROM Catalogodeta c WHERE c.ref2 = :ref2")})
public class Catalogodeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CatalogodetaPK catalogodetaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "ref1")
    private String ref1;
    @Size(max = 50)
    @Column(name = "ref2")
    private String ref2;
    @JoinColumn(name = "codcat", referencedColumnName = "codcat", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Catalogo catalogo;

    public Catalogodeta() {
    }

    public Catalogodeta(CatalogodetaPK catalogodetaPK) {
        this.catalogodetaPK = catalogodetaPK;
    }

    public Catalogodeta(CatalogodetaPK catalogodetaPK, String descripcion) {
        this.catalogodetaPK = catalogodetaPK;
        this.descripcion = descripcion;
    }

    public Catalogodeta(short codcat, short corcat) {
        this.catalogodetaPK = new CatalogodetaPK(codcat, corcat);
    }

    public CatalogodetaPK getCatalogodetaPK() {
        return catalogodetaPK;
    }

    public void setCatalogodetaPK(CatalogodetaPK catalogodetaPK) {
        this.catalogodetaPK = catalogodetaPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getRef2() {
        return ref2;
    }

    public void setRef2(String ref2) {
        this.ref2 = ref2;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogodetaPK != null ? catalogodetaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogodeta)) {
            return false;
        }
        Catalogodeta other = (Catalogodeta) object;
        if ((this.catalogodetaPK == null && other.catalogodetaPK != null) || (this.catalogodetaPK != null && !this.catalogodetaPK.equals(other.catalogodetaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Catalogodeta[ catalogodetaPK=" + catalogodetaPK + " ]";
    }
    
}
