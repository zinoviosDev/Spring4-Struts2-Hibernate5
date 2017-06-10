package com.chandana.sample.dao.impl;

import com.chandana.sample.dao.AbstractDao;
import com.chandana.sample.dao.EmployeeDao;
import com.chandana.sample.persistence.Employee;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    public void deleteEmployeeBySsn(String ssn) {
        Employee employee = findBySsn(ssn);
        getSession().delete(employee);

        //HSQL Delete
        //Query query = getSession().createSQLQuery("delete from EMPLOYEE where ssn = :ssn");
        //query.setString("ssn", ssn);
        //query.executeUpdate();
    }


    public Employee findBySsn(String ssn) {
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }

    public void updateEmployee(Employee employee) {
        getSession().update(employee);
    }

}
