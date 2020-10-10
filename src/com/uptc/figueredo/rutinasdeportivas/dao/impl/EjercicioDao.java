/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.dao.impl;

import com.uptc.figueredo.rutinasdeportivas.dao.GenericDao;
import com.uptc.figueredo.rutinasdeportivas.dto.DetalleRutinaDto;
import com.uptc.figueredo.rutinasdeportivas.model.Ejercicio;
import com.uptc.figueredo.rutinasdeportivas.model.ParteCuerpo;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author carlo
 */
public class EjercicioDao extends GenericDao<Ejercicio, Integer> {

    public Integer nextId() throws Exception {
        return maxValueInteger(Ejercicio.class, "idEjercicio") + 1;
    }

    /**
     * Busca las partes del cuerpo relacionadas a un ejercicio y retorna la
     * lista de las mismas
     */
    public Set<ParteCuerpo> getPartesCuerpoEjercicio(Integer ejercicioId) {
        initTransaction();
        Set<ParteCuerpo> partesCuerpo;
        try {
            partesCuerpo = ((Ejercicio) session.get(Ejercicio.class, ejercicioId)).getParteCuerpoSet();
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
        return partesCuerpo;

    }
    
    public List<DetalleRutinaDto> getDetallesRutina() throws Exception{
        initTransaction();
        List<DetalleRutinaDto> detallesRutina ;
        try {
            detallesRutina = ((List<Ejercicio>) session.createQuery("from Ejercicio").list())
                    .parallelStream()
                    .map(query ->{
                        List<String> descPartesCuerpo = query.getParteCuerpoSet()
                                .stream()
                                .map(ParteCuerpo::getDscMusculo)
                                .collect(Collectors.toList());
                        
                       return new DetalleRutinaDto(query.getNombreEjercicio(), descPartesCuerpo);
                    })
                    .collect(Collectors.toList());
            return detallesRutina;
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
    }
}
