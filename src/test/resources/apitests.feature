Feature: New Jobs

Scenario Outline: run a test to validate jobs
Given job is running and available for <METHOD>
When when we send a request for <API> and <STATUS> and requested operation is <METHOD> and action is <ACTION>
Then response code is <ACTION> is <STATUS>

Examples: jobs
|API     |STATUS     |RESPONSE       |METHOD       |ACTION     |
|users    |200        |OK             |GET          | GET_USER|
|users    |200        |OK             |GET          | GET_BARCODE|
|users    |200        |OK             |GET          | GET_BIKE|
|users    |200        |OK             |POST         | ALL_CAPS|
#|JOBS    |200        |OK             |PUT          | UPDATE_USER_Negative|
#|JOBS    |200        |OK             |DELETE       | DELETE_USER|