package com.mz.partners.api;

import com.mz.partners.models.PartnerPreferences;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * MZ Service Definitions for Partner Config & preferences
 */
@Path("/preferences")
@Api(value="preferences")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PreferencesApi {

    @GET
    @Path("/{orgId}}/{partnerId}")
    @ApiOperation(value = "Partner preferences")
    PartnerPreferences getPreferences(
            @ApiParam(value = "orgId", required = true) @PathParam("orgId") String orgId,
            @ApiParam(value = "partnerId", required = true) @PathParam("partnerId") String partnerId);

}
