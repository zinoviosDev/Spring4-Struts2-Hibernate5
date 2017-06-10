package com.chandana.sample.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

@Action(value = "/login", results = {
        @Result(name = "input", location = "login.jsp"),
        @Result(name = "success", location = "welcome.jsp"),
        @Result(name = "login", location = "login.jsp")
})
@ResultPath(value = "/")
public class LoginAction extends ActionSupport implements SessionAware {

    private String username;
    private String password;

    private Map<String, Object> sessionMap;

    public String execute() {
        sessionMap.put("username", username);
        return SUCCESS;
    }

    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public String getUsername() {
        return username;
    }

    @RequiredStringValidator(message = "Please enter user name.")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @RequiredStringValidator(message = "Please enter password.")
    public void setPassword(String password) {
        this.password = password;
    }
}