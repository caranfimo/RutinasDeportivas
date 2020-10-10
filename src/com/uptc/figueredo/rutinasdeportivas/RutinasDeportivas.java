/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uptc.figueredo.rutinasdeportivas;

import com.uptc.figueredo.rutinasdeportivas.dao.impl.EjercicioDao;
import com.uptc.figueredo.rutinasdeportivas.dao.impl.EspecialistaDao;
import com.uptc.figueredo.rutinasdeportivas.dao.impl.GrupoDeportivoDao;
import com.uptc.figueredo.rutinasdeportivas.dao.impl.ParteCuerpoDao;
import com.uptc.figueredo.rutinasdeportivas.dao.impl.RegistroDao;
import com.uptc.figueredo.rutinasdeportivas.dao.impl.RutinaDao;
import com.uptc.figueredo.rutinasdeportivas.dao.impl.TipoEjercicioDao;
import com.uptc.figueredo.rutinasdeportivas.model.TipoEjercicio;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlo
 */
public class RutinasDeportivas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // inicializacion de daos
        TipoEjercicioDao tipoEjercicioDao = new TipoEjercicioDao();
        EjercicioDao ejercicioDao = new EjercicioDao();
        ParteCuerpoDao parteCuerpoDao = new ParteCuerpoDao();
        EspecialistaDao especialistaDao = new EspecialistaDao();
        RutinaDao rutinaDao = new RutinaDao();
        RegistroDao registroDao = new RegistroDao();
        GrupoDeportivoDao grupoDeportivoDao = new GrupoDeportivoDao();
        
        // Registrar tipo ejercicio
        try {
            TipoEjercicio tipoEjercicio = new TipoEjercicio(tipoEjercicioDao.nextId(), "Rutina Diaria");
            tipoEjercicioDao.save(tipoEjercicio);
            System.out.println("Tipo ejercicio "+ tipoEjercicio.getIdTipoEjercicio() + "registrado correctamente");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        
        
    }
    
}
