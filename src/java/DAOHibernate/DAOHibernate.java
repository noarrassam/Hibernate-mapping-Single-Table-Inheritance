/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOHibernate;

import hiber.Person;
import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author noorr
 */
public class DAOHibernate {

    static Session sessionObj;
    static SessionFactory factory;

    public DAOHibernate() {

        try {
            factory = new AnnotationConfiguration().
                    configure().
                    addPackage("hiber").
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public List<Person> selectUser() {
        List<Person> user = null;
        try {

            // Getting Session Object From SessionFactory
            sessionObj = factory.openSession();

            // Getting Transaction Object From Session Object
            Transaction t = sessionObj.beginTransaction();

            user = (List<Person>) sessionObj.createQuery("from Person").list();

            // Committing The Transactions To The Database
            t.commit();
            System.out.println("\nSuccessfully Selected 1 Record By ID In The Database!\n");
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return user;
    }

    public Person selectUser(int id) {
        Person user = null;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = factory.openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            user = (Person) sessionObj.get(Person.class, id);

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            System.out.println("\nSuccessfully Selected 1 Record By ID In The Database!\n");
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return user;
    }

    public List<Person> searchUser(String name) {
        Person user = null;
        try {
            // Getting Session Object From SessionFactory
            sessionObj = factory.openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            Criteria criteria = sessionObj.createCriteria(Person.class);
            List<Person> obj = criteria.add(Restrictions.eq("name", name)).list();

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            System.out.println("\nSuccessfully Selected 1 Record By ID In The Database!\n" + obj.get(0));
            return obj;
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return Collections.emptyList();
    }

    public void insertPerson(Person person) {
        try {
            // Getting Session Object From SessionFactory
            sessionObj = factory.openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();
            // save 'user' object to session as a transaction
            sessionObj.save(person);
            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            System.out.println("\nSuccessfully Created Record(s) In The Database!\n");

        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public boolean updateUser(Person person) {
        boolean rowUpdated = true;
        List<Person> user = null;
        try {
            sessionObj = factory.openSession();
            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            // Creating Transaction Entity
            sessionObj.saveOrUpdate(person);

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();

            System.out.println("\nSuccessfully Updated Record In The Database!\n");

        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            rowUpdated = false;
            e.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return rowUpdated;
    }

    public boolean deletePerson(int id) {
        boolean rowDeleted;
        try {

            // Getting Session Object From SessionFactory
            sessionObj = factory.openSession();

            // Getting Transaction Object From Session Object
            sessionObj.beginTransaction();

            Person findUser = (Person) sessionObj.load(Person.class, id);
            sessionObj.delete(findUser);

            // Committing The Transactions To The Database
            sessionObj.getTransaction().commit();
            rowDeleted = true;
            System.out.println("\nSuccessfully Deleted Record In The Database!\n");
        } catch (Exception e) {
            if (null != sessionObj.getTransaction()) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            rowDeleted = false;
            e.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
        return rowDeleted;
    }
}
