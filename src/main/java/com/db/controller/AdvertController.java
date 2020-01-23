package com.db.controller;
import com.db.model.Advert;
import com.db.service.AdvertService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("/advert")
public class AdvertController {
    AdvertService advertService = new AdvertService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAdverts(){
        List<Advert> adverts = advertService.getAllAdverts();
        if ((adverts).isEmpty()) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(adverts).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvert(@PathParam("id") int id) {
        Advert advert = advertService.getAdvert(id);
        if (advert == null) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(advert).build();
    }

    @GET
    @Path("person_id/{person_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvertsByPersonID(@PathParam("person_id") int person_id) {
        List<Advert> advert = advertService.getAdvertsByPersonID(person_id);
        if ((advert).isEmpty()) {
            return Response.status(404).build();
        }
        return Response.status(200).entity(advert).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertAdvert(Advert advert) {
        boolean insertAdvert = advertService.addAdvert(advert);
        if (insertAdvert) {
            return Response.status(201).entity("Advert inserted").build();
        } else {
            return Response.status(404).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertAdvert(Advert advert, @PathParam("id") int id) {
        boolean editAdvert = advertService.editAdvert(advert, id);
        if (editAdvert) {
            return Response.status(204).entity("Advert edited").build();
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAdvert(@PathParam("id") int id) throws SQLException {
        boolean deleteAdvert = advertService.deleteAdvert(id);
        if (deleteAdvert) {
            return Response.status(200).entity("Advert deleted").build();
        } else {
            return Response.status(404).build();
        }
    }
}
