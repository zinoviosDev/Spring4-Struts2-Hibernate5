# Spring4-Struts2-Hibernate5
Spring4, Struts2 and Hibernate5 based sample web project

In this sample project , I have integrated Structs2 and Spring 4 with Hibernate 5 using annotation based configuration. This project includes a simple CRUD java application, creating hibernate entities, saving data in MySQL database , performing database CRUD operations within transaction using annotation based configuration. 

How to Run this project

- Create a database called `chandana`
- Compile the project using maven:
    ```sh
    $ mvn clean install
    ```
- Run using jetty plugin
    ```sh
    $ mvn jetty:run
    ```
- Access the `http://localhost:8080/Spring4/`
