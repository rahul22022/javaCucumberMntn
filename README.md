# javaCucumberMntn
INTRODUCTION
------------

This is a data driven test automtion approach for the API testing. Following tech stack was used for this automation
* Java 
* Cucumber :- As BDD Framework
* Rest Assured :- For Making API calls
* Simple JSON :- To read and write JSON data
* Reflection :- This module allows you to make a method call from while converting a string to a method name(This helps make automation data driven)


MODULES
------------
Here are important modules for the code
Main :- Helper Class
  * Helper Class has following methods 
  *    *  getRequest(String url) returns the resposne of get request
  *    *  putRequest(String url) returns the resposne of put request
  *    *  postRequest(String url) returns the resposne of POST request
  *    *  deleteRequest(String url) returns the resposne of delete request

 
