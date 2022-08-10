package com.roma.bfg.repository.impl;

import com.roma.bfg.model.Student;
import com.roma.bfg.repository.StudentRepository;
import com.roma.bfg.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public Student createStudent(Student student) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.persist(student);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }

        return student;

    }

    @Override
    public Student deleteStudent(UUID id) {

        Student student = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            student = session.get(Student.class, id);

            session.remove(student);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }

        return student;

    }

    @Override
    public List<Student> getAllStudents() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM Student", Student.class).list();

        }

    }

    @Override
    public Student getStudentById(UUID id) {

        Student student = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            student = session.get(Student.class, id);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }

        return student;

    }


}
