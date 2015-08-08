package br.com.projetoGastos.hibernate;


import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            
            sessionFactory = new AnnotationConfiguration().configure("/br/com/projetoGastos/hibernate/hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
