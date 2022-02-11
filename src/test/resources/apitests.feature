Feature: New Jobs

Scenario Outline: run a test to validate jobs
Given job is running and available for <METHOD>
When when we send a request for <API> and <STATUS> and requested operation is <METHOD> and action is <ACTION>
Then response code is <ACTION> is <STATUS>

Examples: jobs
|API     |STATUS     |RESPONSE       |METHOD       |ACTION     |
#|JOBS    |200        |OK             |GET          | GET_USER|
|JOBS    |200        |OK             |POST         | ADD_USER|
#|JOBS    |200        |OK             |PUT          | UPDATE_USER|
#|JOBS    |200        |OK             |PUT          | UPDATE_USER_Negative|
#|JOBS    |200        |OK             |DELETE       | DELETE_USER|