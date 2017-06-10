package com.chandana.sample.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

@Action(value = "/logout", results = {
        @Result(name = "success", location = "login.jsp")
})
@ResultPath(value = "/")
public class LogoutAction extends ActionSupport implements SessionAware {

    private Map<String, Object> sessionMap;

    public String execute() {
        sessionMap.remove("username");
        return SUCCESS;
    }
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }
}
