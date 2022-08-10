package com.roma.bfg.repository.impl;

import com.roma.bfg.form.LogForm;
import com.roma.bfg.model.Log;
import com.roma.bfg.repository.LogRepository;
import com.roma.bfg.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.UUID;

@Repository
public class LogRepositoryImpl implements LogRepository {

    @Override
    public Log createLog(Log log) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.persist(log);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }

        return log;

    }

    @Override
    public Log selectLogByStudentId(UUID id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createNativeQuery("SELECT * FROM Log WHERE student_id = '" + id + "'", Log.class).getSingleResult();

        }

    }

    @Override
    public Log updateLog(UUID id, LogForm form) {

        Log log = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            log = session.get(Log.class, id);

            log.setStudentId(form.getStudentId());
            log.setDate(form.getDate());
            log.setMessage(form.getMessage());

            session.merge(log);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }

        return log;

    }

}
