# spring_boot_microservices_55

# Store Procedure without In paramater
```
CREATE PROCEDURE `user_demo`()
BEGIN 
select * from user; 
END
```

# Stored Procedure with IN parameter
```
CREATE PROCEDURE `user_email_in`(IN namein varchar(20), IN adressin varchar(10))
BEGIN
select * from user where name = namein OR  address = adressin;
END
```

# to execute 
``` call user_demo()```

# to execute inparmater procedure

``` call user_email_in('vivek','hyd')```

# Swagger URL Adress
http://localhost:8080/swagger-ui.html

# Microservice flow
![microservice flow ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/micoservice%20flow.png)

# SPRING SECURITY REQUIRES ROLES. INSERT THE ROLES BELOW BEFORE CREATING USERS.
- insert into roles values(1,'ROLE_USER');
- insert into roles values(2,'ROLE_ADMIN');

# CREATE USER (SignIn)
![token generate/ user login ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/usercreate.png)


# TOKEN GENERATION/ USER LOGIN
![Create user ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/tokengenerate.png)

# ACCESS USERS
![access users ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/accesusers.png)

# KEYCLOAK CONFIGURATION
- Download KEYCLOAK and extract from https://www.keycloak.org/downloads .
- Go to bin folder and run `kc.bat start-dev`
- By default KEYCLOAK run on 8080 if you want to change port `kc.bat start-dev --http-port=<portnumber>`
- Access KEYCLOAK from your browser http://localhost:8080 fot the first time it will ask to set admin user and password.
- Then login to admin console
![KEYCLOAK ADMIN ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/keycloakadmin.PNG)
1. Create a New Realm
![Realm ADMIN ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/realm.PNG)
2. Create a New Client
	- Enter the Client ID, then click Next.
	- In the Third/Last Tab:
	- Set the Root URL to your Spring Boot application's URL (e.g., http://localhost:7070).
	- Set the Valid Redirect URIs to your application's URL with a wildcard (e.g., http://localhost:7070/*).
	- Click Save.
	- Now, select the Client ID you just created.
	- Go to the Roles tab, create roles, and save them.
3. Create a User
	- Go to the Users tab.
	- Click Create User.
	- Username and Email are mandatory fields.
	- After creating the user, select it and go to the Credentials tab.
	- Set a password and uncheck the Temporary checkbox.
4. Map User to Roles
	- Go to the Role Mapping tab.
	- Click Assign Role.
	- In Filter by Client, search for the roles you created for the client and assign them.
5. Retrieve Keycloak Endpoints
	- To find issue-related details or endpoints:

	- Go to Realm Settings (bottom-right corner).
	- Click OpenID Endpoint Configuration to view all available endpoints, such as:

 ``
 {
  "issuer": "http://localhost:8080/realms/master",
  "authorization_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/auth",
  "token_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/token",
  "introspection_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/token/introspect",
  "userinfo_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/userinfo",
  "end_session_endpoint": "http://localhost:8080/realms/master/protocol/openid-connect/logout"
} 
``
# Trouble Shooting
If you get some error like

`` 
{
    "error": "invalid_grant",
    "error_description": "Account is not fully set up"
}
``

Check the credentials. If still the error persists then follow below steps:
- From the left sidebar, select the Users menu. In the Details tab, fill in the following fields:
	- Email
	- Switch Email verified control to On
- From left sidebar select Authentication menu and in Required actions tab Disable these actions:
	- Verify Profile
	- Update Profile
	- Verify Email
![KEYCLOAK troublShoot ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/keycloaktroubleshoot.jpg)

# Token Generation With KEYCLOAK
![KEYCLOAK Token Generation ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/keycloaktoken.PNG)
# Testing API with KEYCLOAK Token
![KEYCLOAK Token Testing ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/endpointacces.PNG)

# DOCKER
- Example Dockerfile
```
FROM openjdk:17-jdk-alpine
ADD target/app1.jar app1.jar
ENTRYPOINT [ "java","-jar","app1.jar" ]
EXPOSE 8080
```
- Image Build
`docker build -f Dockerfile -t mydemoimage .` ("." is current location)
- Running Image
`docker run -p 7070:7070 mydemoimage`

# Running Docker application by using docker-compose
- Example docker-compose.yml
```
version: "3"
services:
  springapp1:
    image: app1image
    build:
      context: ./
      dockerfile: Dockerfile
    ports:
      - 8080:8080
  springapp2:
    image: app2image
    build:
      context: ./../springdockerdemoapp/
      dockerfile: Dockerfile
    ports:
      - 7070:7070
```
- Running Docker applications by using docker-compose
	- Simply run `docker-compose up` (By default docker-compose look docker-compose.yml in current directory).
	- shutting down `docker-compose down`
- docker-compose.yml in other location use below command.
	- `docker-compose.yml -f <location of docker-compose.yml> up`
	- shutting down `docker-compose -f <location of docker-compose.yml> down`