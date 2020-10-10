/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "TIPO_EJERCICIO")
@NamedQueries({
    @NamedQuery(name = "TipoEjercicio.findAll", query = "SELECT t FROM TipoEjercicio t")})
public class TipoEjercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_TIPO_EJERCICIO")
    private Integer idTipoEjercicio;
    @Column(name = "DSC_TIPO_EJERCICIO")
    private String dscTipoEjercicio;
    @OneToMany(mappedBy = "idTipoEjercicio", fetch = FetchType.EAGER)
    private Set<Ejercicio> ejercicioSet;

    public TipoEjercicio() {
    }

    public TipoEjercicio(Integer idTipoEjercicio) {
        this.idTipoEjercicio = idTipoEjercicio;
    }

    public Integer getIdTipoEjercicio() {
        return idTipoEjercicio;
    }

    public void setIdTipoEjercicio(Integer idTipoEjercicio) {
        this.idTipoEjercicio = idTipoEjercicio;
    }

    public String getDscTipoEjercicio() {
        return dscTipoEjercicio;
    }

    public void setDscTipoEjercicio(String dscTipoEjercicio) {
        this.dscTipoEjercicio = dscTipoEjercicio;
    }

    public Set<Ejercicio> getEjercicioSet() {
        return ejercicioSet;
    }

    public void setEjercicioSet(Set<Ejercicio> ejercicioSet) {
        this.ejercicioSet = ejercicioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEjercicio != null ? idTipoEjercicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEjercicio)) {
            return false;
        }
        TipoEjercicio other = (TipoEjercicio) object;
        if ((this.idTipoEjercicio == null && other.idTipoEjercicio != null) || (this.idTipoEjercicio != null && !this.idTipoEjercicio.equals(other.idTipoEjercicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uptc.figueredo.rutinasdeportivas.model.TipoEjercicio[ idTipoEjercicio=" + idTipoEjercicio + " ]";
    }
    
}
