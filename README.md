About the RestHotel Project
---------------------------
This is a simle demo of RESTful Web Services in the HATEOAS style using Sring Boot, Spring Data-JPA and Spring Data-REST. It includes a simple Cross Origin Request Filter (CORS) so that it may be accessed from anyl domain. It includes a client front-end using HTML5 and JavaScript/JQuery 2.x to demonstrate the REST calls. This can be accessed at http://localhost:8080. When running the web app you can access the REST API documentation by clicking on the link on the home page.

To test the REST calls without running the client-side web app you can use CURL on a *nix-based O/S. Example:

curl http://localhost:8080/hotels

The app provides basic C.R.U.D. functionality and offers one custom search feature that lets you find hotels containing any substring. When running the app make sure you use a modern, HTML5 compliant web browser.

By default this app runs on port 8080 and can be run as a normal java app using Maven, or from the command line using:

java -jar RestHotel-1.0.1-SNAPSHOT.jar

Spring Boot will launch an embedded Tomcat 8 server and an H2 database.

To see the CORS feature in action you need to run a similar client front end on a different port or server. See the RestHoteClient app as an example of this. Note that this is a Netbeans project that runs on port 8383 using the Netbeans embedded server.

Future plans: added Spring Cache and Spring Security (maybe even OAuth2).

