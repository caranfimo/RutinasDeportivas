/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PARTE_CUERPO")
@NamedQueries({
    @NamedQuery(name = "ParteCuerpo.findAll", query = "SELECT p FROM ParteCuerpo p")})
public class ParteCuerpo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_MUSCULO")
    private Integer idMusculo;
    @Column(name = "DSC_MUSCULO")
    private String dscMusculo;
    @ManyToMany(mappedBy = "parteCuerpoSet", fetch = FetchType.EAGER)
    private Set<Ejercicio> ejercicioSet;
    @OneToMany(mappedBy = "parIdMusculo", fetch = FetchType.EAGER)
    private Set<ParteCuerpo> parteCuerpoSet;
    @JoinColumn(name = "PAR_ID_MUSCULO", referencedColumnName = "ID_MUSCULO")
    @ManyToOne(fetch = FetchType.LAZY)
    private ParteCuerpo parIdMusculo;

    public ParteCuerpo() {
    }

    public ParteCuerpo(Integer idMusculo) {
        this.idMusculo = idMusculo;
    }

    public ParteCuerpo(Integer idMusculo, String dscMusculo) {
        this.idMusculo = idMusculo;
        this.dscMusculo = dscMusculo;
    }

    public Integer getIdMusculo() {
        return idMusculo;
    }

    public void setIdMusculo(Integer idMusculo) {
        this.idMusculo = idMusculo;
    }

    public String getDscMusculo() {
        return dscMusculo;
    }

    public void setDscMusculo(String dscMusculo) {
        this.dscMusculo = dscMusculo;
    }

    public Set<Ejercicio> getEjercicioSet() {
        return ejercicioSet;
    }

    public void setEjercicioSet(Set<Ejercicio> ejercicioSet) {
        this.ejercicioSet = ejercicioSet;
    }

    public Set<ParteCuerpo> getParteCuerpoSet() {
        return parteCuerpoSet;
    }

    public void setParteCuerpoSet(Set<ParteCuerpo> parteCuerpoSet) {
        this.parteCuerpoSet = parteCuerpoSet;
    }

    public ParteCuerpo getParIdMusculo() {
        return parIdMusculo;
    }

    public void setParIdMusculo(ParteCuerpo parIdMusculo) {
        this.parIdMusculo = parIdMusculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMusculo != null ? idMusculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParteCuerpo)) {
            return false;
        }
        ParteCuerpo other = (ParteCuerpo) object;
        if ((this.idMusculo == null && other.idMusculo != null) || (this.idMusculo != null && !this.idMusculo.equals(other.idMusculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uptc.figueredo.rutinasdeportivas.model.ParteCuerpo[ idMusculo=" + idMusculo + " ]";
    }
    
}
