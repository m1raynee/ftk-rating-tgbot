package com.m1raynee.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.m1raynee.db.entity.*;

public class HibernateConfiguration {
    private static final SessionFactory sessionFactory = new MetadataSources(
            new StandardServiceRegistryBuilder().build())
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Event.class)
            .addAnnotatedClass(Group.class)
            .addAnnotatedClass(RatingEntry.class)
            .addAnnotatedClass(User.class)
            .buildMetadata()
            .buildSessionFactory();

    private HibernateConfiguration() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
