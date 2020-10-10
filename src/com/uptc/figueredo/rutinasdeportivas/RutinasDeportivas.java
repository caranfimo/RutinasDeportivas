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
import com.uptc.figueredo.rutinasdeportivas.model.Ejercicio;
import com.uptc.figueredo.rutinasdeportivas.model.Especialista;
import com.uptc.figueredo.rutinasdeportivas.model.GrupoDeportivo;
import com.uptc.figueredo.rutinasdeportivas.model.ParteCuerpo;
import com.uptc.figueredo.rutinasdeportivas.model.Registro;
import com.uptc.figueredo.rutinasdeportivas.model.Rutina;
import com.uptc.figueredo.rutinasdeportivas.model.RutinaPK;
import com.uptc.figueredo.rutinasdeportivas.model.TipoEjercicio;
import java.util.Calendar;
import java.util.Random;

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
        
        try {
            // Registrar tipo ejercicio
            TipoEjercicio tipoEjercicio = new TipoEjercicio(tipoEjercicioDao.nextId(), "Rutina Diaria");
            tipoEjercicioDao.save(tipoEjercicio);
            System.out.println("Tipo ejercicio "+ tipoEjercicio.getIdTipoEjercicio() + " registrado correctamente");
            
            // Registrar Ejercicio
            Ejercicio ejercicio = new Ejercicio(tipoEjercicioDao.nextId(), "abdominales", "acostarse y levantar el tronco superior");
            ejercicio.setIdTipoEjercicio(tipoEjercicio);
            ejercicioDao.save(ejercicio);
            System.out.println("ejercicio "+ ejercicio.getIdEjercicio() + " registrado correctamente");
            
            // Registrar Parte Cuerpo biceps
            ParteCuerpo parteCuerpoBiceps = new ParteCuerpo(parteCuerpoDao.nextId(), "Biceps");
            ejercicio.getParteCuerpoSet().add(parteCuerpoBiceps);
            parteCuerpoBiceps.getEjercicioSet().add(ejercicio);
            parteCuerpoDao.save(parteCuerpoBiceps);
            System.out.println("parte cuerpo biceps "+ parteCuerpoBiceps.getIdMusculo() + " registrado correctamente");
            
             // Registrar Parte Cuerpo triceps
            ParteCuerpo parteCuerpoTriceps = new ParteCuerpo(parteCuerpoDao.nextId(), "Triceps");
            parteCuerpoTriceps.setParIdMusculo(parteCuerpoBiceps);
            ejercicio.getParteCuerpoSet().add(parteCuerpoTriceps);
            parteCuerpoTriceps.getEjercicioSet().add(ejercicio);
            parteCuerpoDao.save(parteCuerpoTriceps);
            System.out.println("parte triceps biceps "+ parteCuerpoBiceps.getIdMusculo() + " registrado correctamente");
            
            // Registro de especialista
            
            Especialista especialista = new Especialista(especialistaDao.nextId(), "Carlos", Calendar.getInstance().getTime(), "" + new Random().nextInt(10)+100);
            especialistaDao.save(especialista);
            System.out.println("Especialista "+ especialista.getIdEspecialista() + " registrado correctamente");
                       
           // Registro de Rutina
            RutinaPK rutinaPK = new RutinaPK(especialista.getIdEspecialista(), "Lun", ejercicio.getIdEjercicio());
            Rutina rutina = new Rutina(rutinaPK, new Random().nextInt(10), Calendar.getInstance().getTime());
            especialista.getRutinaSet().add(rutina);
            rutina.setEspecialista(especialista);
            ejercicio.getRutinaSet().add(rutina);
            rutina.setEjercicio(ejercicio);
            rutinaDao.save(rutina);
            System.out.println("Rutina "+ rutina.getRutinaPK().toString() + " registrado correctamente");
            
            // Insertar Registro
            
            Registro registro = new Registro(Calendar.getInstance().getTime(), especialista);
            especialista.setRegistro(registro);
            registroDao.save(registro);
            
            // Registrar Grupo deportivo
            
            GrupoDeportivo grupoDeportivo = new GrupoDeportivo(grupoDeportivoDao.nextId(), new Random().nextInt(10));
            Especialista especialistaAmigo = especialistaDao
                    .entiyList(Especialista.class)
                    .stream()
                    .findFirst()
                    .orElse(especialista);
            especialistaAmigo
                    .getGrupoDeportivoAmigos().add(grupoDeportivo);
            grupoDeportivo.setRelacionAmigo(especialistaAmigo);
            especialista
                    .getGrupoDeportivoEspecialistas().add(grupoDeportivo);
            grupoDeportivo.setRelacionEspecialista(especialista);
            grupoDeportivoDao.save(grupoDeportivo);
            
            // Informacion detallada de las rutinas
//            System.out.println("Informacion detallada de las rutinas");
//            ejercicioDao.getDetallesRutina()
//                    .stream()
//                    .map(DetalleRutinaDto::toString)
//                    .forEach(System.out::println);
        
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        
        try {
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        System.exit(0);        
        
    }
    
}
