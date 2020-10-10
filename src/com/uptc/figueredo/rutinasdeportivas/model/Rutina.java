/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "RUTINA")
@NamedQueries({
    @NamedQuery(name = "Rutina.findAll", query = "SELECT r FROM Rutina r")})
public class Rutina implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RutinaPK rutinaPK;
    @Column(name = "REPETICIONES")
    private Integer repeticiones;
    @Column(name = "DURACION")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @JoinColumn(name = "ID_EJERCICIO", referencedColumnName = "ID_EJERCICIO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ejercicio ejercicio;
    @JoinColumn(name = "ID_ESPECIALISTA", referencedColumnName = "ID_ESPECIALISTA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Especialista especialista;

    public Rutina() {
    }

    public Rutina(RutinaPK rutinaPK) {
        this.rutinaPK = rutinaPK;
    }

    public Rutina(RutinaPK rutinaPK, Integer repeticiones, Date duracion) {
        this.rutinaPK = rutinaPK;
        this.repeticiones = repeticiones;
        this.duracion = duracion;
    }

    public Rutina(int idEspecialista, String dia, int idEjercicio) {
        this.rutinaPK = new RutinaPK(idEspecialista, dia, idEjercicio);
    }

    public RutinaPK getRutinaPK() {
        return rutinaPK;
    }

    public void setRutinaPK(RutinaPK rutinaPK) {
        this.rutinaPK = rutinaPK;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutinaPK != null ? rutinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutina)) {
            return false;
        }
        Rutina other = (Rutina) object;
        if ((this.rutinaPK == null && other.rutinaPK != null) || (this.rutinaPK != null && !this.rutinaPK.equals(other.rutinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uptc.figueredo.rutinasdeportivas.model.Rutina[ rutinaPK=" + rutinaPK + " ]";
    }
    
}
