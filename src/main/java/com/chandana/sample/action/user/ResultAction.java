package com.chandana.sample.action.user;

import com.chandana.sample.persistence.Employee;
import com.chandana.sample.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@InterceptorRef(value="customStack")
@ParentPackage(value="login")
@Namespace("/user")
@ResultPath(value = "/")
@Action(value = "result", results = {@Result(name = "success", location = "result.jsp")})
public class ResultAction extends ActionSupport {

    @Autowired
    private EmployeeService employeeService;

    private List<Employee> employeeList;


    private static final long serialVersionUID = 1L;
    private String name;
    private String salary;
    private String ssn;

    public String execute() {
        if (name != null && salary != null && ssn != null) {
            Employee employee1 = new Employee();
            employee1.setName(name);
            //employee1.setJoiningDate(new LocalDate(2010, 10, 10));
            employee1.setSalary(new BigDecimal(salary));
            employee1.setSsn(ssn);
            employeeService.saveEmployee(employee1);
        }

        employeeList = employeeService.findAllEmployees();
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    @RequiredStringValidator(message = "Please enter your name.")
    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    @RequiredStringValidator(message = "Please enter your salary.")
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSsn() {
        return ssn;
    }

    @RequiredStringValidator(message = "Please enter your SSN.")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}