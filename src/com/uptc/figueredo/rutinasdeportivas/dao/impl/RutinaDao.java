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
import com.uptc.figueredo.rutinasdeportivas.model.Rutina;
import com.uptc.figueredo.rutinasdeportivas.model.RutinaPK;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.transform.Transformers;

/**
 *
 * @author carlo
 */
public class RutinaDao extends GenericDao<Rutina, RutinaPK>{
    
    public List<DetalleRutinaDto> getDetallesRutina() throws Exception{
        initTransaction();
        List<DetalleRutinaDto> detallesRutina = new ArrayList<>();
        try {
            detallesRutina = session.createSQLQuery("select esp.NOMBRE as nombreEspecialista, gp.CSC_INTENTOS as amigoGrupoDeportivo, "
                    + "     gp2.CSC_INTENTOS as especialistaGrupoDeportivo, reg.FECHA_REGISTRO as fechaRegistro, r.DIA as diaRutina, r.REPETICIONES as "
                    + "     cantidadRepeticiones, r.DURACION as duracion, e.NOMBRE_EJERCICIO as nombreEjercicio, te.DSC_TIPO_EJERCICIO as tipoEjercicio, "
                    + "     pc.DSC_MUSCULO as musculoEjercitado from RUTINA r " +
                            "inner join EJERCICIO e on r.ID_EJERCICIO = e.ID_EJERCICIO " +
                            "inner join TIPO_EJERCICIO te on e.ID_TIPO_EJERCICIO = te.ID_TIPO_EJERCICIO " +
                            "inner join MUSCULO_EJERCICIO me on e.ID_EJERCICIO = me.ID_EJERCICIO " +
                            "inner join PARTE_CUERPO pc on me.ID_MUSCULO = pc.ID_MUSCULO " +
                            "inner join ESPECIALISTA esp on esp.ID_ESPECIALISTA = r.ID_ESPECIALISTA " +
                            "inner join REGISTRO reg on reg.ID_REGISTRO = esp.ID_ESPECIALISTA " +
                            "inner join GRUPO_DEPORTIVO gp on gp.ID_ESPECIALISTA = esp.ID_ESPECIALISTA " +
                            "inner join GRUPO_DEPORTIVO gp2 on gp2.ESP_ID_ESPECIALISTA = esp.ID_ESPECIALISTA")
                    .setResultTransformer(Transformers.aliasToBean(DetalleRutinaDto.class)).list();
            
            return detallesRutina;
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
    }
    
}
