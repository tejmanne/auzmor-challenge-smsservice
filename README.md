SMS service application

Application is developed in Java using Springboot with Maven.

Set up the Postgresql db and use the dump from https://gist.github.com/paragradke/a629bb4e332125b1388390fcc156cfcd
Set up the Redis db for caching 

Set the properties of above Databases in src/main/application.properties

Steps to run the appication.
1.) Maven update project. (If using any IDE)
2.) Set up the build path with JDK by including all the project folders. (src/main/java, src/main/resources, src/main/test)
3.) Maven clean
4.) Maven install
5.) Run the application either by running the main class (SmsserviceApplication.java) or run as on server using external application server.

Now we can access the application through REST calls and below some the test urls

All are POST requests

Inbound test URL: 
http://localhost:8080/smsservice/io/inbound/sms?from=441224980094&to=4924195509198&text=hh
Request Header:
Authorization : Basic cGxpdm8xOjIwUzBLUE5PSU0=

Outbound test URL:
http://localhost:8080/smsservice/io/outbound/sms?from=4924195509198&to=441224980094&text=hh
Request Header:
Authorization : Basic cGxpdm8xOjIwUzBLUE5PSU0=


############################
App running in AWS server
############################

App AWS URL: http://18.188.176.183:8080/smsservice

All are post requests.

Inbound test URL: 
http://18.188.176.183:8080/smsservice/io/inbound/sms?from=441224980094&to=4924195509198&text=hh
Request Header:
Authorization : Basic cGxpdm8xOjIwUzBLUE5PSU0=

Outbound test URL:
http://18.188.176.183:8080/smsservice/io/outbound/sms?from=4924195509198&to=441224980094&text=hh
Request Header:
Authorization : Basic cGxpdm8xOjIwUzBLUE5PSU0=


