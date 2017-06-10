package com.chandana.sample.action.user;

import com.chandana.sample.persistence.Employee;
import com.chandana.sample.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

@InterceptorRef(value="customStack")
@ParentPackage(value="login")
@Namespace("/user")
@ResultPath(value = "/")
@Action(value = "view", results = {@Result(name = "success", location = "view.jsp"),@Result(name = "error", location = "result.jsp") })
public class SearchAction extends ActionSupport {

    @Autowired
    private EmployeeService employeeService;

    private Employee employee;
    private String ssn;


    public String execute() {
        try {
            employee = employeeService.findBySsn(ssn);
            if (employee != null){
                return SUCCESS;
            } else {
                addActionError("Please enter valid user id");
                return ERROR;
            }
            //System.out.println(employee.toString());
        } catch (Exception e) {
            addActionError("Please enter valid user id");
            return ERROR;
        }

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}