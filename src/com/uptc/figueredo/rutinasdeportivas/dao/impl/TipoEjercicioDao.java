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
    
    public Integer maxId() throws Exception{
        try {
            initTransaction();
        Integer maxValue = (Integer) session
                .createQuery("SELECT MAX(idTipoEjercicio) FROM TipoEjercicio").uniqueResult();
        return Optional.of(maxValue).orElse(0);
        }
        catch(Exception ex) {
            throw ex;
        }
        finally {
            session.close();
        }
        
    }
    
    public Integer nextId() throws Exception{
        return maxId() +1;
    }
    
}
