<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title> Spring 4 + Struts 2 + Hibernate 4 Sample </title>
    </head>
    <body>
        <h1>User List</h1>


        <s:if test="hasActionErrors()">
            <div class="errors">
                <s:actionerror/>
            </div>
        </s:if>


        <s:if test="hasActionMessages()">
            <div class="welcome">
                <s:actionmessage/>
            </div>
        </s:if>

        <fieldset>
            <s:label value="Name" />
            <s:label value="Salary" />
            <s:label value="SSN" />
        </fieldset>
        <s:iterator status="stat" value="employeeList">
            <fieldset>
                <s:property value="name" />
                <s:property value="salary" />
                <s:property value="ssn" />
                <a href="view?ssn=<s:property value='ssn' />">View</a>
                <a href="delete?ssn=<s:property value='ssn' /> ">Delete</a>
            </fieldset>
        </s:iterator>
    </body>
</html>