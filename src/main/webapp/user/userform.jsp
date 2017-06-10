<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title> Spring 4 + Struts 2 + Hibernate 4 Sample </title>
    </head>
    <body>
        <h1>Add new User into System</h1>

        <s:form action="result" validate="true">
            <s:textfield name="name" label="Name" />
            <s:textfield name="salary" label="Salary" />
            <s:textfield name="ssn" label="SSN" />
            <s:submit method="execute" />
        </s:form>

    </body>
</html>