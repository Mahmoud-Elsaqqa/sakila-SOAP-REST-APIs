# Sakila API Project

:construction: This project is under development :construction:

This Java project builds SOAP and REST APIs for the Sakila database using Java 17, Maven, and JPA with Hibernate.

## Prerequisites

Before running the project, make sure you have the following software installed:

- Java 17
- Maven
- MySQL

## Setup

1. Clone the repository
``` git clone https://github.com/Mahmoud-Elsaqqa/Sakila-REST-SOAP-APIs ```


2. Create the Sakila database in MySQL by running the `sakila-db.sql` script found in the project root folder.


3. Update the `application.properties` file found in the `src/main/resources` folder with your MySQL database details.

## Running the Project

To run the project, use the following Maven command:
``` mvn exec:java ```


## Endpoints

The project provides the following endpoints:

### REST API
:construction: To be further updated :construction:

- `/api/films` - Returns a list of films.
- `/api/films/{id}` - Returns a single film by ID.
- `/api/customers` - Returns a list of customers.
- `/api/customers/{id}` - Returns a single customer by ID.

### SOAP API
:construction: To be further updated :construction:

- `/ws` - Web service endpoint URL.
- `/ws/films/{id}` - Returns a single film by ID.
- `/ws/customers/{id}` - Returns a single customer by ID.

## Technologies Used

- Java 17
- Maven
- Hibernate
- JPA
- MySQL
- SOAP
- REST


