# agilisiumrepo

1.clone this code repository 
2.make sure JAVA8  and maven ,POSTMAN installed
3.go to project directory
4,build & run this app using follwing maven command 
 # mvn cleam compile
 # mvn spring-boot:run
 
5.check SWAGGER UI once  http://localhost:8080/swagger-ui.html

6.call this authenticate api to get the access token
     method: POST
     API : http://localhost:8080/agilisium/api/authenticate
     REQUEST:
        {
	            "username":"user",
            	"password":"user"
        }
7.following users already exist in h2-db  to get the access token  
 USERNAME PASSWORD  
 user       user
 agilisium  agilisium    
 admin       admin
 
8.once  got access token you can call following rest api's which i exposed in this app
          
          METHOD : GET
          API    :http://localhost:8080/agilisium/api/getProductDetails
          SET HEADER : Authorization
          PASS ACCESS TOKEN AS Authorization PARAM VALUE   WHICH YOU GOT 
          
          
          METHOD : GET
          API    :http://localhost:8080/agilisium/api/getConfigDetails
          SET HEADER : Authorization
          PASS ACCESS TOKEN AS Authorization PARAM VALUE   WHICH YOU GOT 
          
          
  
          
