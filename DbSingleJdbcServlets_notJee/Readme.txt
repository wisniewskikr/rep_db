DATA BASE


1. Create data bases

Create main db:
trans_local_jdbc_servlets

and test db:
trans_local_jdbc_servlets_test


2. Create tables in data bases
In both data bases create empty tables using file:
create.sql


3. Improve properties in pom.xml (optional)
If you need you can improve properties in file pom.xml.


-----


LOCAL DATASOURCE ON JBOSS 7


If you want to add local datasource to JBoss 7 AS you have to perform following steps:

1. Create mysql module folder
In location <jboss_home>/modules create folder 'com/mysql/jdbc/main'


2. Add driver to module folder
Copy mysql driver to mysql module folder. For instance: mysql-connector-java-5.1.10.jar


3. Add module.xml to module folder
Create module.xml file and add to mysql module folder. Example content:

<?xml version="1.0" encoding="UTF-8"?>

<!--
  ~ JBoss, Home of Professional Open Source.
  ~ Copyright 2010, Red Hat, Inc., and individual contributors
  ~ as indicated by the @author tags. See the copyright.txt file in the
  ~ distribution for a full listing of individual contributors.
  ~
  ~ This is free software; you can redistribute it and/or modify it
  ~ under the terms of the GNU Lesser General Public License as
  ~ published by the Free Software Foundation; either version 2.1 of
  ~ the License, or (at your option) any later version.
  ~
  ~ This software is distributed in the hope that it will be useful,
  ~ but WITHOUT ANY WARRANTY; without even the implied warranty of
  ~ MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
  ~ Lesser General Public License for more details.
  ~
  ~ You should have received a copy of the GNU Lesser General Public
  ~ License along with this software; if not, write to the Free
  ~ Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
  ~ 02110-1301 USA, or see the FSF site: http://www.fsf.org.
  -->

<module xmlns="urn:jboss:module:1.1" name="com.mysql.jdbc">

    <resources>
        <resource-root path="mysql-connector-java-5.1.18.jar"/>
        <!-- Insert resources here -->
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
        <module name="javax.servlet.api" optional="true"/>
    </dependencies>
</module>


4. Improve file standalone.xml
In location <jboss_home>/standalone/configuration update file standalone.xml. For instance:
<datasources>
    <datasource jndi-name="java:jboss/datasources/MySqlDS" pool-name="MySqlDS" enabled="true" use-java-context="true">
        <connection-url>jdbc:mysql://localhost:3306/trans_local_jdbc_servlets</connection-url>
        <driver>mysql</driver>
        <security>
            <user-name>root</user-name>
            <password>password</password>
        </security>
    </datasource>
    <drivers>
        <driver name="mysql" module="com.mysql.jdbc">
            <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
        </driver>
    </drivers>
</datasources>