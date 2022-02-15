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

 

Running code
------------
You can run this code in followung ways.

1. gradle clean build  
2. ./gradlew cucumberCli or gradle clean test
3. these tests can be triggered from jenkins as well.




Approach
------------
This automation is written as a data driven approach to API test automation
This is how the tests work.
1. feature file:- add the test case to feature file with the action being the test identifier
2. fixtures.json :- this is the driver file once you have added the test to feature file add a new tag to fixtiures file
    a. the action should match the key in fixtures example
    
    - feature :-
   - |users    |200        |OK             |GET          | GET_USER|
   -  Fixture:
   -    "GET_USER": {
          "payload": {},
          "url": "https://jsonplaceholder.typicode.com/todos/1",
          "expectedresult": {
            "userId": 1,
            "id": 1,
            "title": "delectus aut autem",
            "completed": false
          },
          "method": "getRequest"
    
    
        }
        
3. the method call will identify the API call type it needs to make.
4. Any time you need to add new tests just add a new line to feature and new JSONobject tio fixture with key and action matching.


Todo
-----------
1. This automation design is working for get requests.
2. I could not find a good POST end point to show in example one added is not working but can be fixed with a bit more of troubleshooting
3. We can add PUT DELETE a=or any other API calls without changing the code
4. Even for REST calls with URI you can add a new method to Helper class
5. Any type of API call can be added to heklpers.
6. Reporting is not yet added


Pros
-----------
1. data driven approach very easy to scale 
2. once coded we can keep on adding tests without touching the code
3. Easy to debug
4. Easily be coded in any language(in python you can do it with requests module)
5. Easy to jenkanize.
6. Cucumber reports can be used for test reporting

Cons
-----------
1. Need knowledge of java to troubleshoot
2. Need to handle the test design carefully or the json can become very complex
3. Validating expeted results can sometimes need code updates.
