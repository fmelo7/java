package io.swagger.api;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.model.DeviceswifiResponseGET;

@Path("/")
@Api(value = "/", description = "")
public interface DeviceswifiGetApi {

	@GET
	@Path("/deviceswifi")
	@Produces({ "application/json" })
	@ApiOperation(value = "Recuperar a senha wifi do cliente NET.", tags = {})
	public DeviceswifiResponseGET deviceswifiGet(@QueryParam("filter") String filter,
			@HeaderParam("X-Api-Version") String xApiVersion, @HeaderParam("X-Metadata") String xMetadata);
}
