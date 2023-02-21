package com.canastacampesina.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.canastacampesina.model.Canasta;

public class CanastaService {

    private SessionFactory factory;
    
    public CanastaService(){
        factory = new Configuration().configure("cfg.xml").addAnnotatedClass(Canasta.class).buildSessionFactory();
    }

    public boolean crearProducto(Canasta canastaObj){
        boolean create=false;
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            session.persist(canastaObj);
            session.getTransaction().commit();
            create=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return create;
    }

    public List<Canasta> consultarProductos(){
        List<Canasta> canastaFun = new ArrayList<Canasta>();
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            canastaFun=session.createQuery("from Canasta", Canasta.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return canastaFun;    
    }

    public boolean comprarProducto(int id, int cantidadCompra){
        List<Canasta> canastaFun = new ArrayList<Canasta>();
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            canastaFun=session.createQuery("from Canasta", Canasta.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean compra=false;
        for (int i=0; i<canastaFun.size(); i++){
            if (canastaFun.get(i).getIdProducto()==id)if (canastaFun.get(i).getIdProducto()==id){
                Canasta canasta = new Canasta();
                try {
                    canasta = session.find(Canasta.class, id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                canasta.setCantidadProducto(canastaFun.get(i).getCantidadProducto()-cantidadCompra);
                try {
                    session.merge(canasta);
                    session.getTransaction().commit();
                    compra = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                session.close();
                break;
            }
        }
        session.close();
        return compra;
    } 

    public boolean venderProducto(int id, int cantidadVenta){
        List<Canasta> canastaFun = new ArrayList<Canasta>();
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            canastaFun=session.createQuery("from Canasta", Canasta.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean venta=false;
        for (int i=0; i<canastaFun.size(); i++){
            if (canastaFun.get(i).getIdProducto()==id){
                Canasta canasta = new Canasta();
                try {
                    canasta = session.find(Canasta.class, id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                canasta.setCantidadProducto(canastaFun.get(i).getCantidadProducto()+cantidadVenta);
                try {
                    session.merge(canasta);
                    session.getTransaction().commit();
                    venta = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                session.close();
                break;
            }
        }
        return venta;
    }
}


