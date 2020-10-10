/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author carlo
 */
public class DetalleRutinaDto {
    
    private String nombreEspecialista;
    private Integer amigoGrupoDeportivo;
    private Integer especialistaGrupoDeportivo;
    private Date fechaRegistro;
    private String diaRutina;
    private Short cantidadRepeticiones;
    private Date duracion;
    private String nombreEjercicio;
    private String tipoEjercicio;
    private String musculoEjercitado;
    
    private List<String> partesCuerpo;

    public DetalleRutinaDto() {
    }

    public DetalleRutinaDto(String nombreEspecialista, Integer amigoGrupoDeportivo, Integer especialistaGrupoDeportivo, Date fechaRegistro, String diaRutina, Short cantidadRepeticiones, Date duracion, String nombreEjercicio, String tipoEjercicio, String musculoEjercitado, List<String> partesCuerpo) {
        this.nombreEspecialista = nombreEspecialista;
        this.amigoGrupoDeportivo = amigoGrupoDeportivo;
        this.especialistaGrupoDeportivo = especialistaGrupoDeportivo;
        this.fechaRegistro = fechaRegistro;
        this.diaRutina = diaRutina;
        this.cantidadRepeticiones = cantidadRepeticiones;
        this.duracion = duracion;
        this.nombreEjercicio = nombreEjercicio;
        this.tipoEjercicio = tipoEjercicio;
        this.musculoEjercitado = musculoEjercitado;
        this.partesCuerpo = partesCuerpo;
    }
    
    

    public String getNombreEspecialista() {
        return nombreEspecialista;
    }

    public void setNombreEspecialista(String nombreEspecialista) {
        this.nombreEspecialista = nombreEspecialista;
    }

    public Integer getAmigoGrupoDeportivo() {
        return amigoGrupoDeportivo;
    }

    public void setAmigoGrupoDeportivo(Integer amigoGrupoDeportivo) {
        this.amigoGrupoDeportivo = amigoGrupoDeportivo;
    }

    public Integer getEspecialistaGrupoDeportivo() {
        return especialistaGrupoDeportivo;
    }

    public void setEspecialistaGrupoDeportivo(Integer especialistaGrupoDeportivo) {
        this.especialistaGrupoDeportivo = especialistaGrupoDeportivo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDiaRutina() {
        return diaRutina;
    }

    public void setDiaRutina(String diaRutina) {
        this.diaRutina = diaRutina;
    }

    public Short getCantidadRepeticiones() {
        return cantidadRepeticiones;
    }

    public void setCantidadRepeticiones(Short cantidadRepeticiones) {
        this.cantidadRepeticiones = cantidadRepeticiones;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public void setTipoEjercicio(String tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }

    public String getMusculoEjercitado() {
        return musculoEjercitado;
    }

    public void setMusculoEjercitado(String musculoEjercitado) {
        this.musculoEjercitado = musculoEjercitado;
    }

    public List<String> getPartesCuerpo() {
        return partesCuerpo;
    }

    public void setPartesCuerpo(List<String> partesCuerpo) {
        this.partesCuerpo = partesCuerpo;
    }

    @Override
    public String toString() {
        return "DetalleRutinaDto{" + "nombreEspecialista=" + nombreEspecialista + ", amigoGrupoDeportivo=" + amigoGrupoDeportivo + ", especialistaGrupoDeportivo=" + especialistaGrupoDeportivo + ", fechaRegistro=" + fechaRegistro + ", diaRutina=" + diaRutina + ", cantidadRepeticiones=" + cantidadRepeticiones + ", duracion=" + duracion + ", nombreEjercicio=" + nombreEjercicio + ", tipoEjercicio=" + tipoEjercicio + ", musculoEjercitado=" + musculoEjercitado + ", partesCuerpo=" + partesCuerpo + '}';
    }
}
