# Sakila API Project

:construction: This project is under continues developments and improvements :construction:

This Java project builds SOAP and REST APIs for the MySQL's Sakila database using Java 17, Maven, and JPA with Hibernate.

## Prerequisites

Before running the project, make sure you have the following software installed:

- JDK 8+
- Maven
- MySQL

## Setup


1. Clone the repository
``` git clone https://github.com/Mahmoud-Elsaqqa/Sakila-SOAP-REST-APIs ```


2. Check for sakila database dump in your MySQL installation.


3. Update the `persistence.xml` file found in the `src/main/resources/META-INF` folder with your MySQL database credentials.

## Running the Project
---

Deploy on Tomcat Web Server +v8.0
`mvn clean tomcat7:deploy`

navigate to:
For REST: `https://localhost:9090/sakila/webapi/`

For SOAP: `https://localhost:9090/sakila/ws/`


## Endpoints

:construction: To be further extended :construction:

The project provides CRUD operations to the following endpoints:

### REST API

CRUD Operations include:
- `GET - /webapi/resource/`- find all resources.
- `GET - /webapi/resource/{id}`- find resource by id.
- `GET /webapi/resource/count`- find resource count.
- `HEAD /webapi/resource/`- Check if resource exists or not.
- `POST /webapi/resource/`- save resource.
- `DELETE /webapi/resource/{id}`- deletes resource.
- `PUT /webapi/resource/{id}`- updates resource.
---
- `/webapi/films` - CRUD for films
- `/webapi/actors` - CRUD for actors.
- `/webapi/customers` - CRUD for customers.
- `/webapi/stores` - CRUD for stores.
- `/webapi/payments` - CRUD for payments.
- `/webapi/staff` - CRUD for staff.

### SOAP API

CRUD Operations include:
- `findAll() - /ws/resource/`- find all resources.
- `findById(id) - /resource/{id}`- find resource by id.
- `count() /resource/count`- find resource count.
- `existsById(id) /resource/`- Check if resource exists or not.
- `save(id, requestDto) /resource/`- save resource.
- `delete(id) /resource/{id}`- deletes resource.
- `update(id, requestDto) /resource/{id}`- updates resource.
---
- `/ws/films` - CRUD for films
- `/ws/actors` - CRUD for actors.
- `/ws/customers` - CRUD for customers.
- `/ws/stores` - CRUD for stores.
- `/ws/payments` - CRUD for payments.
- `/ws/staff` - CRUD for staff.


## Technologies Used

- Java 17
- Maven
- Hibernate
- JPA
- MySQL
- SOAP
- REST


