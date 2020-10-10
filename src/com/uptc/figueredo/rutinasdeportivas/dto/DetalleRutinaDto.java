/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.dto;

import java.util.List;

/**
 *
 * @author carlo
 */
public class DetalleRutinaDto {
    
    private String descriptionEjercicio;
    private List<String> partesCuerpo;

    public DetalleRutinaDto() {
    }

    public DetalleRutinaDto(String descriptionEjercicio) {
        this.descriptionEjercicio = descriptionEjercicio;
    }

    public DetalleRutinaDto(String descriptionEjercicio, List<String> partesCuerpo) {
        this.descriptionEjercicio = descriptionEjercicio;
        this.partesCuerpo = partesCuerpo;
    }

    public String getDescriptionEjercicio() {
        return descriptionEjercicio;
    }

    public void setDescriptionEjercicio(String descriptionEjercicio) {
        this.descriptionEjercicio = descriptionEjercicio;
    }

    public List<String> getPartesCuerpo() {
        return partesCuerpo;
    }

    public void setPartesCuerpo(List<String> partesCuerpo) {
        this.partesCuerpo = partesCuerpo;
    }

    @Override
    public String toString() {
        return "DetalleRutinaDto{" + "descriptionEjercicio=" + descriptionEjercicio + ", partesCuerpo=" + partesCuerpo.toString() + '}';
    }
    
    
    
}
