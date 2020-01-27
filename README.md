# Web service API Documentation
### Third home task for EPAM Test Automation courses
## Users and Adverts API web service
#### List of technologies used for creating:
+ postgresql  
+ maven  
+ postman  
+ REST  
+ jax rs, jersey  
+ JSON  
+ tomcat 7   


**Path for starting API: http://localhost:8080/web_service/api/

## Schemas
**Advert**{  
>id	integer($int32)  
>person_id	integer($int32)  
>head	string  
>body	string  
>category	string  
>phone_number	string  
>date_of_creation	string($date-time)  
>}  


**Person**{
>id	integer($int32)
>email	string
>category	string
>last_Name	string
>first_Name	string
>}


### Advert schema requests:

**Path:("/advert")**
####  *GET requests:*

**Path: ("/")**
getAllAdverts()
*Get all adverts*
200 - return all adverts
404 - bad request/list of adverts is empty

**Path: ("/{id}")**
getAdvert(int id)
*Get advert by it's id*
200 - return advert with this id
404 - bad request

**Path: ("/person_id/{person_id}")**
getAdvertsByPersonID(int person_id)
*Get all adverts of this person*
200 - return adverts of this person
404 - bad request

#### *POST requests*

**Path: ("/")**
insertAdvert(Advert advert)
**body:**
>{
>"person_id": "person_id",
>"head":	"some string",
>"body":	"some string",
>"category":	"category",
>"phone_number":	"phone_number"
>}

advert_id and date_of_creation generate automaticly
*Insert advert with those fields*
201 - message: "Advert inserted"/ sucsessful request
404 - bad request

#### *PUT requests*

**Path: ("/{id}")**
editAdvert(Advert advert, int id)
**body:**
>{
>"person_id": "person_id",
>"head":	"some string",
>"body":	"some string",
>"category":	"category",
>"phone_number":	"phone_number"
>}
date_of_creation generates automaticly
*Edit advert with those fields and this id. Fields can be changed or to be the same*
201 - message: "Advert edited"/ sucsessful request
404 - bad request

#### *DELETE requests*
**Path: ("/{id}")**
deleteAdvert(int id)
*Edit advert by it's id*
200 - message: "Advert deleted"/ sucsessful request
404 - bad request

### Person schema requests
####  *GET requests:*

**Path: ("/")**
getAllPersons()
*Get full person list*
200 - return all persons
404 - bad request/list of persons is empty

**Path: ("/{id}")**
getPerson(int id)
*Get person by it's id*
200 - return person with this id
404 - bad request

#### *POST requests*

**Path: ("/")**
insertPerson(Person person)
**body:**
>{
> "first_Name":	"first_name",
> "last_Name": "last_name",
> "email":	"email",
> "category":	"category"
>}
id generates automaticly
*Insert person with those fields*
201 - message: "Person inserted"/ sucsessful request
404 - bad request

#### *PUT requests*

**Path: ("/{id}")**
editPerson(Person person, int id)
**body:**
>{
> "first_Name":	"first_name",
> "last_Name": "last_name",
> "email":	"email",
> "category":	"category"
>}
*Edit person with those fields and this id. Fields can be changed or to be the same*
201 - message: "Person edited"/ sucsessful request
404 - bad request

#### *DELETE requests*
**Path: ("/{id}")**
deletePerson(int id)
*Delete person by it's id*
200 - message: "Person deleted"/ sucsessful request
404 - bad request
