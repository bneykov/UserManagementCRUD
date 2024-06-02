# User Management API

## Perequisites

* Java IDE /IntelliJ IDEA, Eclipse/

* Java 17 JDK

* Apache Maven

* MySql

## Installation
1. Clone the project to a desired directory

2. Open the project with the Java IDE 

3. Specify Java 17 as project version.

4. Install dependencies


Run the following command to install the dependencies, defined in the pom.xml file
```bash
mvn clean install
```
5. Set your database username and password in  _src/main/resources/application.yml_  under spring:datasource. 

6. Run the application

Click the run button or navigate to the root folder of the project and execute this command
```bash
mvn spring-boot:run
```

## Usage
 The application runs on port 8000 by default (http://localhost:8000/). This can be changed in the application.yml file under server:port.

 The application will create a database on startup with the name liqubase_db and will execute the SQL scripts located in _src/main/resources/db/changelog/scripts_.

### The API consists of the following endpoints

#### GET /api/users/get/{id}
##### Parameters
 * id (required path parameter) - The ID of the user to retrieve.

##### Response

 * 200 OK - The response body contains the user corresponding to the provided ID in JSON format.


 * 404 Not Found - A user with the provided ID could not be found. The response body contains the user ID, which could not be found.

###### Example response on successful GET request
```bash
{
    "id": "1",
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "phoneNumber": "0883321112",
    "dateOfBirth": "1999-01-01"
}
```

###### Example response on unsuccessful GET request
```bash
{
    "id": 5555,
    "message": "User not found"
}
```

#### GET /api/users/all?keyword={keyword}
##### Parameters
 * keyword (not required request parameter) - a query string which returns users, where the keyword is found .

##### Response

 * 200 OK - The response body contains a list of users whose data matches the provided keyword in any of their fields. If there is no keyword provided, the response body returns a list with all users. 

#### DELETE /api/users/delete/{id}
##### Parameters
* id (required path parameter) - The ID of the user to delete.

##### Response

 * 200 OK - The response body is empty. 

* 404 Not Found - A user with the provided ID could not be found. The response body contains the user ID, which could not be found. /Same as unsuccessful GET request/

#### POST /api/users/add
##### Parameters
* none

##### Request Body
* User object (required) -  Contains the data for the user to add.
###### Fields

* firstName - A string between 2 and 20 characters long
* lastName- A string between 2 and 20 characters long
* email - A valid email address /person@example.com/
* phoneNumber - A non-empty String
* dateOfBirth - A string in the format yyyy-MM-dd (2022-12-31)

###### Example POST request body

```bash
{
   
    "firstName": "Maria",
    "lastName": "Sparks",
    "email": "maria.sparks@example.com",
    "phoneNumber": "0883321112",
    "dateOfBirth": "1999-01-01"
}
```
* 400 BAD REQUEST- The response body contains the fields, in which there was a wrong input and an error message.  

###### Example response on unsuccessful POST request with wrong input on all fields

```bash

{
    "firstName": "First name length must be between 2 and 20 characters long",
    "lastName": "Last name length must be between 2 and 20 characters long",
    "phoneNumber": "Phone number can not be empty",
    "dateOfBirth": "Date must be in the format yyyy-MM-dd",
    "email": "Enter a valid email address"
}
```

* 404 Not Found - A user with the provided ID could not be found. The response body contains the user ID, which could not be found. /Same as unsuccessful GET request/
#### PUT /api/users/edit/{id} 
##### Parameters
* id (required path parameter) - The ID of the user to edit.


##### Request Body
Same as the request for adding users.

###### Example PUT request body

```bash
{
   
    "firstName": "MariaEdited",
    "lastName": "SparksEdited",
    "email": "maria.sparks@new.com",
    "phoneNumber": "0883321112",
    "dateOfBirth": "1999-01-01"
}
```

##### Response

 * 200 OK - The response body contains the same object, sent in the PUT request. 

 * 400 BAD REQUEST- The response body contains the fields, in which there was a wrong input and an error message.  

###### Example response on unsuccessful PUT request with wrong input on all fields

```bash

{
    "firstName": "First name length must be between 2 and 20 characters long",
    "lastName": "Last name length must be between 2 and 20 characters long",
    "phoneNumber": "Phone number can not be empty",
    "dateOfBirth": "Date must be in the format yyyy-MM-dd",
    "email": "Enter a valid email address"
}
```

* 404 Not Found - A user with the provided ID could not be found. The response body contains the user ID, which could not be found. /Same as unsuccessful GET request/




