package io.swagger.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.jaxrs.PATCH;
import io.swagger.model.Body;
import io.swagger.model.DeviceswifiResponsePATCH;

@Path("/")
@Api(value = "/", description = "")
public interface DeviceswifiPatchApi {

	@PATCH
	@Path("/deviceswifi")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@ApiOperation(value = "Alterar a senha wifi do cliente NET.", tags = {})
	public DeviceswifiResponsePATCH deviceswifiPatch(@HeaderParam("X-Api-Version") String xApiVersion,
			@HeaderParam("X-Metadata") String xMetadata, Body body);
}
