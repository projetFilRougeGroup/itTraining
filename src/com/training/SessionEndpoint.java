/**
 * 
 */
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
import javax.ws.rs.core.UriBuilder;

import com.training.entites.Session;

/**
 * @author charu
 *
 */
@RequestScoped
@Path("/sessions")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class SessionEndpoint {

	/**
	* @param session
	* @return
	*/
	@POST
	public Response create(final Session session) {
		//TODO: process the given session 
		//here we use Session#getId(), assuming that it provides the identifier to retrieve the created Session resource. 
		return Response
				.created(UriBuilder.fromResource(SessionEndpoint.class).path(String.valueOf(session.getId())).build())
				.build();
	}

	/**
	* @param id
	* @return
	*/
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id") final Long id) {
		//TODO: retrieve the session 
		Session session = null;
		if (session == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(session).build();
	}

	/**
	* @param startPosition
	* @param maxResult
	* @return
	*/
	@GET
	public List<Session> listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		//TODO: retrieve the sessions 
		final List<Session> sessions = null;
		return sessions;
	}

	/**
	* @param id
	* @param session
	* @return
	*/
	@PUT
	@Path("/{id:[0-9][0-9]*}")
	public Response update(@PathParam("id") Long id, final Session session) {
		//TODO: process the given session 
		return Response.noContent().build();
	}

	/**
	* @param id
	* @return
	*/
	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final Long id) {
		//TODO: process the session matching by the given id 
		return Response.noContent().build();
	}

}
