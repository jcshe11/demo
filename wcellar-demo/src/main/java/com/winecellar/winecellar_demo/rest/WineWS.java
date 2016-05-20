package com.winecellar.winecellar_demo.rest;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.winecellar.winecellar_demo.data.WineDAO;
import com.winecellar.winecellar_demo.model.Wine;


@Path("/wines")
@Stateless
@LocalBean
public class WineWS {

	@EJB
	private WineDAO wineDao;
	
	public int getValue(){
		return 2;
	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAllWines() {
		System.out.println("Get all wines++test");
		final List<Wine> wines=wineDao.getAllWines();
		System.out.println("got wines");
		System.out.println(wines.size());
		return Response.status(200).entity(wines).build();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{id}")
	public Response findWineById(@PathParam("id") final int identity) {
		final Wine wine = wineDao.getWine(identity);
		return Response.status(200).entity(wine).build();

	}
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveWine(final Wine wine) {
		wineDao.save(wine);
		return Response.status(201).entity(wine).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateWine(final Wine wine) {
		wineDao.update(wine);
		return Response.status(200).entity(wine).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCar(@PathParam("id") final int identity) {
		wineDao.delete(identity);
		return Response.status(204).build();
	}
	
	@GET
	@Path("/search/{query}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findByName(@PathParam("query") final String query) {
		System.out.println("findByName: " + query);
		final List<Wine> wines=wineDao.getWinesByName(query);
		return Response.status(200).entity(wines).build();
	}

}
