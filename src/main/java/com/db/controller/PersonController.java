package com.db.controller;

import com.db.model.Person;
import com.db.service.PersonService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/person")
public class PersonController {
    PersonService personService = new PersonService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons(){
        List<Person> persons = personService.getAllPersons();
        if ((persons).isEmpty()) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(persons).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") int id) {
        Person person = personService.getPerson(id);
        if (person == null) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(person).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPerson(Person person) {
        boolean insertPerson = personService.insertPerson(person);
        if (insertPerson) {
            return Response.status(201).entity("Person inserted").build();
        } else {
            return Response.status(404).build();
        }
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editPerson(Person person, int id) {
        boolean editPerson = personService.editPerson(person, id);
        if (editPerson) {
            return Response.status(204).entity("Person edited").build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) throws SQLException {
        boolean deletePerson = personService.deletePerson(id);
        if (deletePerson) {
            return Response.status(200).entity("Person deleted").build();
        } else {
            return Response.status(404).build();
        }
    }

}