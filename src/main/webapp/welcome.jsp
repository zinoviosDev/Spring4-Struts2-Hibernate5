<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title> Spring 4 + Struts 2 + Hibernate 4 Sample </title>
    </head>
    <body>
        <h3>Welcome <s:property value="username"></s:property></h3>

        <a href="logout">logout</a>


        <b>
            <a href="user/userform">Add Users</a>
        </b>
        <b>
            <a href="user/list">List Users</a>
        </b>
    </body>
</html>