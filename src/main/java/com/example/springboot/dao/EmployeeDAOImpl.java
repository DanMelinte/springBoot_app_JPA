package com.example.springboot.dao;

import com.example.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
//        Session session = sessionFactory.getCurrentSession();
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

        /*Hibernate*/
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> allEmployees = query.getResultList();

        /*JPA*/
        Query query = entityManager.createQuery("from Employee ", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        /*Hibernate*/
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);

        /*JPA*/
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployeeById(int id) {
        /*Hibernate*/
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, id);

        /*JPA*/
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        /*Hibernate*/
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("delete from Employee where id = :employeeId");

        /*JPA*/
        Query query = entityManager.createQuery("delete from Employee where id = :employeeId");
        query.setParameter("employeeId", id);

        query.executeUpdate();
    }
}
