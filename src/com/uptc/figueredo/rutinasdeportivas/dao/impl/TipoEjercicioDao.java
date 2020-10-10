/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.dao.impl;

import com.uptc.figueredo.rutinasdeportivas.dao.GenericDao;
import com.uptc.figueredo.rutinasdeportivas.model.TipoEjercicio;
import java.util.Optional;

/**
 *
 * @author carlo
 */
public class TipoEjercicioDao extends GenericDao<TipoEjercicio, Integer>{
    
    public Integer nextId() throws Exception{
        return maxValueInteger(TipoEjercicio.class, "idTipoEjercicio") +1;
    }
}
