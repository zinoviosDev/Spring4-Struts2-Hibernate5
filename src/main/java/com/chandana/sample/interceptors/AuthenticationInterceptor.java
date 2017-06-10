package com.chandana.sample.interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import java.util.Map;
import java.util.logging.Logger;

public class AuthenticationInterceptor implements Interceptor {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationInterceptor.class.getName());

    public void destroy() {
        LOGGER.info("AuthenticationInterceptor destroy() is called...");
    }

    public void init() {
        LOGGER.info("AuthenticationInterceptor init() is called...");
    }

    public String intercept(ActionInvocation actionInvocation) throws Exception {
        LOGGER.info("inside auth interceptor");
        Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();

        String user = (String) sessionAttributes.get("username");
        System.out.println(user);

        if (user == null) {
            LOGGER.info("User is not available");
            return Action.LOGIN;
        } else {
            LOGGER.info("Logged in user " + user);
            Action action = (Action) actionInvocation.getAction();
            return actionInvocation.invoke();
        }
    }
}
