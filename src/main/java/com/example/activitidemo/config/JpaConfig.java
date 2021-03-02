//package com.example.activitidemo.config;
//
//import org.hibernate.Session;
//import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
//import org.hibernate.engine.spi.SessionImplementor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.sql.Connection;
//
//@Configuration
//public class JpaConfig {
//
//    @Autowired
//    private SessionImplementor delegate;
//
////    @Bean
////    public SessionImplementor getSession(){
////        SessionImplementor sessionImplementor1 = new SessionImplementor();
////        SessionImplementor sessionImplementor = new EntityManager().unwrap(SessionImplementor.class);
////        SessionImplementor session = sessionImplementor.getSession();
////        return session;
////    }
//
//    @Bean
//    public Connection getConnection(){
//        SessionImplementor sessionImplementor = new SessionDelegatorBaseImpl(delegate).unwrap(SessionImplementor.class);
//        SessionImplementor session = sessionImplementor.getSession();
//        Connection connection = session.connection();
//        return connection;
//    }
//
//}
