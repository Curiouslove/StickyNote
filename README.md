# StickyNote


This is just a small project built with the following:
spring framework,
java,
mySQL,
and maven as a built tool

#Features
RestAPI that includes the following:
* Add products to database,
* Find note by id,
* Find all notes,
* Delete products

Spring MVC witrh thymleaf template engine for viewing the sticky note

#Installation
Step 1: Clone repository
Step 2: Install dependecies: cd into the root folder and run the following command :

`mvn install`

Step 3: Setup database: run sql script in the db folder

`src/main/resource/db/setup-db.sql`

Step 4: Run the project

`mvn spring-boot-run`
