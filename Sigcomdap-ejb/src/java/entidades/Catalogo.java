/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jos
 */
@Entity
@Table(name = "catalogo")
@NamedQueries({
    @NamedQuery(name = "Catalogo.findAll", query = "SELECT c FROM Catalogo c")
    , @NamedQuery(name = "Catalogo.findByCodcat", query = "SELECT c FROM Catalogo c WHERE c.codcat = :codcat")
    , @NamedQuery(name = "Catalogo.findByNomcat", query = "SELECT c FROM Catalogo c WHERE c.nomcat = :nomcat")})
public class Catalogo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codcat")
    private Short codcat;
    @Size(max = 50)
    @Column(name = "nomcat")
    private String nomcat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogo")
    private List<Catalogodeta> catalogodetaList;

    public Catalogo() {
    }

    public Catalogo(Short codcat) {
        this.codcat = codcat;
    }

    public Short getCodcat() {
        return codcat;
    }

    public void setCodcat(Short codcat) {
        this.codcat = codcat;
    }

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }

    public List<Catalogodeta> getCatalogodetaList() {
        return catalogodetaList;
    }

    public void setCatalogodetaList(List<Catalogodeta> catalogodetaList) {
        this.catalogodetaList = catalogodetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcat != null ? codcat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogo)) {
            return false;
        }
        Catalogo other = (Catalogo) object;
        if ((this.codcat == null && other.codcat != null) || (this.codcat != null && !this.codcat.equals(other.codcat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Catalogo[ codcat=" + codcat + " ]";
    }
    
}
