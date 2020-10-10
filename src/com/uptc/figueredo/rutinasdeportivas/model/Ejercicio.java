/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "EJERCICIO")
@NamedQueries({
    @NamedQuery(name = "Ejercicio.findAll", query = "SELECT e FROM Ejercicio e")})
public class Ejercicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_EJERCICIO")
    private Integer idEjercicio;
    @Column(name = "NOMBRE_EJERCICIO")
    private String nombreEjercicio;
    @Column(name = "DSC_EJERCICIO")
    private String dscEjercicio;
    @JoinTable(name = "MUSCULO_EJERCICIO", joinColumns = {
        @JoinColumn(name = "ID_EJERCICIO", referencedColumnName = "ID_EJERCICIO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_MUSCULO", referencedColumnName = "ID_MUSCULO")})
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ParteCuerpo> parteCuerpoSet = new HashSet(0);
    @JoinColumn(name = "ID_TIPO_EJERCICIO", referencedColumnName = "ID_TIPO_EJERCICIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoEjercicio idTipoEjercicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ejercicio", fetch = FetchType.LAZY)
    private Set<Rutina> rutinaSet = new HashSet(0);

    public Ejercicio() {
    }

    public Ejercicio(Integer idEjercicio, String nombreEjercicio, String dscEjercicio) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.dscEjercicio = dscEjercicio;
    }
    
    public Ejercicio(Integer idEjercicio, String nombreEjercicio, String dscEjercicio, Set<ParteCuerpo> parteCuerpoSet) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.dscEjercicio = dscEjercicio;
        this.parteCuerpoSet = parteCuerpoSet;
    }

    public Integer getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getDscEjercicio() {
        return dscEjercicio;
    }

    public void setDscEjercicio(String dscEjercicio) {
        this.dscEjercicio = dscEjercicio;
    }

    public Set<ParteCuerpo> getParteCuerpoSet() {
        return parteCuerpoSet;
    }

    public void setParteCuerpoSet(Set<ParteCuerpo> parteCuerpoSet) {
        this.parteCuerpoSet = parteCuerpoSet;
    }

    public TipoEjercicio getIdTipoEjercicio() {
        return idTipoEjercicio;
    }

    public void setIdTipoEjercicio(TipoEjercicio idTipoEjercicio) {
        this.idTipoEjercicio = idTipoEjercicio;
    }

    public Set<Rutina> getRutinaSet() {
        return rutinaSet;
    }

    public void setRutinaSet(Set<Rutina> rutinaSet) {
        this.rutinaSet = rutinaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEjercicio != null ? idEjercicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ejercicio)) {
            return false;
        }
        Ejercicio other = (Ejercicio) object;
        if ((this.idEjercicio == null && other.idEjercicio != null) || (this.idEjercicio != null && !this.idEjercicio.equals(other.idEjercicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uptc.figueredo.rutinasdeportivas.model.Ejercicio[ idEjercicio=" + idEjercicio + " ]";
    }
    
}
