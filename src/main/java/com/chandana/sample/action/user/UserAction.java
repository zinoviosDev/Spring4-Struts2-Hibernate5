package com.chandana.sample.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

@InterceptorRef(value="customStack")
@ParentPackage(value="login")
@Namespace("/user")
@Action("/userform")
@ResultPath(value = "/")
@Result(name = "success", location = "userform.jsp")
public class UserAction extends ActionSupport implements SessionAware {

    private Map<String, Object> sessionMap;

    public String execute() {
        return SUCCESS;
    }

    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
}