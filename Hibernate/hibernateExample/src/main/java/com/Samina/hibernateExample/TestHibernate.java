package com.Samina.hibernateExample;

import org.hibernate.Session;
 
public class TestHibernate {
 
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        // Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");
 
        session.save(emp);
        //store the employee id generated for future use
        Integer empId = emp.getEmployeeId();
        session.getTransaction().commit();
        
        Session sessionFour = HibernateUtil.getSessionFactory().openSession();
        sessionFour.beginTransaction();
         
        //third load() method example
        EmployeeEntity emp3 = new EmployeeEntity();
        sessionFour.load(emp3 , empId);
        System.out.println(emp3.getFirstName() + " - check" +emp3.getLastName());
         
        sessionFour.getTransaction().commit();
        
        
        HibernateUtil.shutdown();
    }
}
