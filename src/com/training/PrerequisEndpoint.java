/**
 * 
 */
package com.training.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.training.entites.Prerequis;

/**
 * @author charu
 *
 */
@RequestScoped
@Path("/prerequises")

@Consumes({ "application/xml", "application/json" })

public class PrerequisEndpoint {

	/**
	* @param prerequis
	* @return
	*/
	@POST
	public Response create(final Prerequis prerequis) {
		//TODO: process the given prerequis 
		//you may want to use the following return statement, assuming that Prerequis#getId() or a similar method 
		//would provide the identifier to retrieve the created Prerequis resource:
		//return Response.created(UriBuilder.fromResource(PrerequisEndpoint.class).path(String.valueOf(prerequis.getId())).build()).build();
		return Response.created(null).build();
	}

	/**
	* @param id
	* @return
	*/
	@Produces()
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the prerequis 
		Prerequis prerequis = null;
		if (prerequis == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(prerequis).build();
	}

	/**
	* @param startPosition
	* @param maxResult
	* @return
	*/
	@GET
	public List<Prerequis> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the prerequises 
		final List<Prerequis> prerequises = null;
		return prerequises;
	}

	/**
	* @param id
	* @param prerequis
	* @return
	*/
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final Prerequis prerequis) {
		//TODO: process the given prerequis 
		return Response.noContent().build();
	}

	/**
	* @param id
	* @return
	*/
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the prerequis matching by the given id 
		return Response.noContent().build();
	}

}
