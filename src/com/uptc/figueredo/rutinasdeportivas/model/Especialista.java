/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "ESPECIALISTA")
@NamedQueries({
    @NamedQuery(name = "Especialista.findAll", query = "SELECT e FROM Especialista e")})
public class Especialista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_ESPECIALISTA")
    private Integer idEspecialista;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    @Basic(optional = false)
    private String tarjetaProfesional;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "especialista", fetch = FetchType.EAGER)
    private Registro registro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "espIdEspecialista", fetch = FetchType.EAGER)
    private Set<GrupoDeportivo> grupoDeportivoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEspecialista", fetch = FetchType.EAGER)
    private Set<GrupoDeportivo> grupoDeportivoSet1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "especialista", fetch = FetchType.EAGER)
    private Set<Rutina> rutinaSet;

    public Especialista() {
    }

    public Especialista(Integer idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public Especialista(Integer idEspecialista, String nombre, Date fechaNacimiento, String tarjetaProfesional) {
        this.idEspecialista = idEspecialista;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public Integer getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(Integer idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Set<GrupoDeportivo> getGrupoDeportivoSet() {
        return grupoDeportivoSet;
    }

    public void setGrupoDeportivoSet(Set<GrupoDeportivo> grupoDeportivoSet) {
        this.grupoDeportivoSet = grupoDeportivoSet;
    }

    public Set<GrupoDeportivo> getGrupoDeportivoSet1() {
        return grupoDeportivoSet1;
    }

    public void setGrupoDeportivoSet1(Set<GrupoDeportivo> grupoDeportivoSet1) {
        this.grupoDeportivoSet1 = grupoDeportivoSet1;
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
        hash += (idEspecialista != null ? idEspecialista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialista)) {
            return false;
        }
        Especialista other = (Especialista) object;
        if ((this.idEspecialista == null && other.idEspecialista != null) || (this.idEspecialista != null && !this.idEspecialista.equals(other.idEspecialista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uptc.figueredo.rutinasdeportivas.model.Especialista[ idEspecialista=" + idEspecialista + " ]";
    }
    
}
