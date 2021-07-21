# Tutorial for SpringBoot Security

# Start the application

# 01_bootstrapping

##   

# 02_Getting_Started

## Form based authentication

- just add the spring boot security library to `pom.xml`
- you get a form with username and password to enter
- this is good for internet authentication
- when calling an url endpoint you will be redirected to `http://localhost:8080/login`
- to logout just click `http://localhost:8080/logout`

## Basic Auth

- client sends a request -> server sends a 401 to client (unauthorized)
- client sends a request with base64 username and password in the request header -> server validates username and
  password and sends a 200 to client
- there is no way to logout because username and password is sent with every single request
- add the class `WebSecurityConfig.java`

# 03_Users_and_Roles

##
