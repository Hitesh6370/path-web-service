# path-web-service   

#### Description - This project is a part of Transport System (Assignment). Path-web-service is spring-boot based soap/rest service to calculate shortest path between 2 planets along with distance and traffic delay. This path web service internally calls DerbyDB service to get result from in memory database.

#### Steps to run at Local
1.	run 'git clone https://github.com/Hitesh6370/path-web-service.git ' or Download the project as zip and extract
2.	open project using any IDE (Intellij or Eclipse).
3.	clean build and run project.
4.	Service will run @8085 port (Dearbedb-service should be up and running on port 8086 in order to get result).
5.	this path web service is exposed as soap and rest both.  
6.  use wisld file from resource folder or use 'http://localhost:8085/ws/soap.wsdl' to load on soap ui in order to test web service
7. same functionality can be test using postman in the form of rest api. 




 
