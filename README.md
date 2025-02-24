# spring_boot_microservices_55

#Store Procedure without In paramater
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


# Spring Security need Roles, Insert below roles Before creating Users

- insert into roles values(1,'ROLE_USER');
- insert into roles values(2,'ROLE_ADMIN');

# Create user
![token generate/ user login ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/usercreate.png)


# token generate/ user login
![Create user ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/tokengenerate.png)

# access users
![access users ](https://github.com/HarshaPrimeTrainings/spring_boot_microservices_55/blob/main/accesusers.png)