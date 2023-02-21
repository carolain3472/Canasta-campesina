package com.canastacampesina.services;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.canastacampesina.model.Sesion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SesionService {
    private SessionFactory factory;

    public SesionService(){
        factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Sesion.class).buildSessionFactory();
    }


    public String crearUsuario(Sesion sesionObj){
        String message = "";
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.persist(sesionObj);
            session.getTransaction().commit();
            message = "Usuario creado con exito";
        } catch (Exception e) {
            e.printStackTrace();
            message=e.getMessage();
        }  
        session.close();
        return message;
    }


    public List<Sesion> obtenerUsuarios(){
        List<Sesion> sesionFun = new ArrayList<Sesion>();
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            sesionFun=session.createQuery("from Sesion", Sesion.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return sesionFun;
    }

    public Map<String, Boolean> login(String usuario, String contrasena){
        boolean login = false;
        List<Sesion> sesionFun = new ArrayList<Sesion>();
        Session session = factory.openSession();
        session.beginTransaction();
        String loginText = "";
        try {
            sesionFun=session.createQuery("from Sesion", Sesion.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i=0; i<sesionFun.size(); i++){      
            if (sesionFun.get(i).getUsuario().equals(usuario) && sesionFun.get(i).getContrasena().equals(contrasena)){
                login = true;
                loginText = "Autentificado con exito";
                break;
            }else{
                loginText = "Error de autentificación";
            }
        }
        return Collections.singletonMap(loginText, login);
    }    
}