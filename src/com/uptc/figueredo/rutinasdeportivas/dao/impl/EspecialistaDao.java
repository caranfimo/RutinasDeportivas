/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.dao.impl;

import com.uptc.figueredo.rutinasdeportivas.dao.GenericDao;
import com.uptc.figueredo.rutinasdeportivas.model.Ejercicio;
import com.uptc.figueredo.rutinasdeportivas.model.Especialista;

/**
 *
 * @author carlo
 */
public class EspecialistaDao extends GenericDao<Especialista, Integer>{
    
    public Integer nextId() throws Exception {
        return maxValueInteger(Especialista.class, "idEspecialista") + 1;
    }
    
}
