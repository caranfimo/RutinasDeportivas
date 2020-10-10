/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author carlo
 */
@Embeddable
public class RutinaPK implements Serializable {

    @Column(name = "ID_ESPECIALISTA")
    private Integer idEspecialista;
    @Column(name = "DIA")
    private String dia;
    @Column(name = "ID_EJERCICIO")
    private Integer idEjercicio;

    public RutinaPK() {
    }

    public RutinaPK(Integer idEspecialista, String dia, Integer idEjercicio) {
        this.idEspecialista = idEspecialista;
        this.dia = dia;
        this.idEjercicio = idEjercicio;
    }

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(Integer idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(Integer idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEspecialista;
        hash += (dia != null ? dia.hashCode() : 0);
        hash += (int) idEjercicio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutinaPK)) {
            return false;
        }
        RutinaPK other = (RutinaPK) object;
        if (this.idEspecialista != other.idEspecialista) {
            return false;
        }
        if ((this.dia == null && other.dia != null) || (this.dia != null && !this.dia.equals(other.dia))) {
            return false;
        }
        if (this.idEjercicio != other.idEjercicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uptc.figueredo.rutinasdeportivas.model.RutinaPK[ idEspecialista=" + idEspecialista + ", dia=" + dia + ", idEjercicio=" + idEjercicio + " ]";
    }
    
}
