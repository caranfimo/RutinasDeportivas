/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas.dao.impl;

import com.uptc.figueredo.rutinasdeportivas.dao.GenericDao;
import com.uptc.figueredo.rutinasdeportivas.model.Ejercicio;
import com.uptc.figueredo.rutinasdeportivas.model.ParteCuerpo;

/**
 *
 * @author carlo
 */
public class ParteCuerpoDao extends GenericDao<ParteCuerpo, Integer>{
    
     public Integer nextId() throws Exception{
        return maxValueInteger(ParteCuerpo.class, "idMusculo") +1;
    }
}
