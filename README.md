## Market Place Application

 This project is an implementation of Market Place Application:

- Java backend (Spring Boot v2.7.1)
    - H2 Database ( In Memory )

The entry point for a user is a website which is available under the
address: **http://127.0.0.1:4200/**


---

### Prerequisites

In order to run this application you need to install two tools: **Docker** & **Docker Compose**.

Instructions how to install **Docker** on [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/), [Windows](https://docs.docker.com/docker-for-windows/install/) , [Mac](https://docs.docker.com/docker-for-mac/install/) .

**Dosker Compose** is already included in installation packs for *Windows* and *Mac*, so only Ubuntu users needs to follow [this instructions](https://docs.docker.com/compose/install/) .


### How to run it?

An entire application can be ran with a single command in a terminal:

```
$ docker-compose up -d
```

If you want to stop it use following command:

```
$ docker-compose down
```


---

#### Market Place Application  App (REST API)

This is a Spring Boot (Java) based application that connects with a
database that and expose the REST endpoints that can be consumed by
frontend. It supports multiple HTTP REST methods like GET, POST, PUT and
DELETE.

Full list of available REST endpoints could be found in Swagger UI,
which could be called using link: **http://127.0.0.1:8080/api/swagger-ui.html**


#### Market Place Application In Memory Database (H2 DataBase)

http://127.0.0.1:8080/h2-console/login.jsp




