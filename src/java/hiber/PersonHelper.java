/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiber;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author noorr
 */
public class PersonHelper {
    Session session = null;

    public PersonHelper() {
        this.session = ClassHibernateUtil.getSessionFactory().getCurrentSession();
    }

public List getPersonNames() {
    List<Person> custList = null;
    try {
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery ("from Person as cs ");
        custList = (List<Person>) q.list();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return custList;
    }
}
