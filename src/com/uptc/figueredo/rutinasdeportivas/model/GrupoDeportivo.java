/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "GRUPO_DEPORTIVO")
@NamedQueries({
    @NamedQuery(name = "GrupoDeportivo.findAll", query = "SELECT g FROM GrupoDeportivo g")})
public class GrupoDeportivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CSC_INTENTOS")
    private Integer cscIntentos;
    @Column(name = "INTENTO")
    private int intento;
    @JoinColumn(name = "ESP_ID_ESPECIALISTA", referencedColumnName = "ID_ESPECIALISTA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Especialista espIdEspecialista;
    @JoinColumn(name = "ID_ESPECIALISTA", referencedColumnName = "ID_ESPECIALISTA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Especialista idEspecialista;

    public GrupoDeportivo() {
    }

    public GrupoDeportivo(Integer cscIntentos) {
        this.cscIntentos = cscIntentos;
    }

    public GrupoDeportivo(Integer cscIntentos, int intento) {
        this.cscIntentos = cscIntentos;
        this.intento = intento;
    }

    public Integer getCscIntentos() {
        return cscIntentos;
    }

    public void setCscIntentos(Integer cscIntentos) {
        this.cscIntentos = cscIntentos;
    }

    public int getIntento() {
        return intento;
    }

    public void setIntento(int intento) {
        this.intento = intento;
    }

    public Especialista getEspIdEspecialista() {
        return espIdEspecialista;
    }

    public void setEspIdEspecialista(Especialista espIdEspecialista) {
        this.espIdEspecialista = espIdEspecialista;
    }

    public Especialista getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(Especialista idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cscIntentos != null ? cscIntentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoDeportivo)) {
            return false;
        }
        GrupoDeportivo other = (GrupoDeportivo) object;
        if ((this.cscIntentos == null && other.cscIntentos != null) || (this.cscIntentos != null && !this.cscIntentos.equals(other.cscIntentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uptc.figueredo.rutinasdeportivas.model.GrupoDeportivo[ cscIntentos=" + cscIntentos + " ]";
    }
    
}
