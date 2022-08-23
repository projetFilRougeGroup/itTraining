package com.training.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.training.entites.Formation;

@RequestScoped
@Path("/formations")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class FormationEndpoint {

	@POST
	public Response create(final Formation formation) {
		//TODO: process the given formation 
		//you may want to use the following return statement, assuming that Formation#getId() or a similar method 
		//would provide the identifier to retrieve the created Formation resource:
		//return Response.created(UriBuilder.fromResource(FormationEndpoint.class).path(String.valueOf(formation.getId())).build()).build();
		return Response.created(null).build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the formation 
		Formation formation = null;
		if (formation == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(formation).build();
	}

	@GET
	public List<Formation> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the formations 
		final List<Formation> formations = null;
		return formations;
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final Formation formation) {
		//TODO: process the given formation 
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the formation matching by the given id 
		return Response.noContent().build();
	}

}
