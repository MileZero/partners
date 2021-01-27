/*
 * Copyright (c) MileZero. All Rights Reserved
 */

package com.mz.partners.api;

import com.mz.partners.models.model.CandyPojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/candy")
@Api(value="candy", description="access to candy resource.")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CandyApi {

    @PUT
    @Path("/{candyid}")
    @ApiOperation(value = "Submitting Candy.")
    @ApiResponses(
        value = {@ApiResponse(code = 200, message = "Candy successful."),
            @ApiResponse(code = 202, message = "Candy Accepted."),
            @ApiResponse(code = 400, message = "Invalid Candy Contents."),
            @ApiResponse(code = 403, message = "Wrong Candy Resource."),
            @ApiResponse(code = 415, message = "Unsupported Candy representation(media type)."),
            @ApiResponse(code = 429, message = "Throttled, too much candy ... feeling sick.")
        })
    Response put(
        @ApiParam(value = "Candy ID", required = true) @PathParam("candyid") String candyId,
        @ApiParam(value = "Candy Contents", required = true) CandyPojo candy);

    @GET
    @Path("/{candyid}")
    @ApiOperation(value = "Retrieving Candy.")
    @ApiResponses(
        value = {@ApiResponse(code = 200, message = "Candy successful."),
            @ApiResponse(code = 400, message = "Invalid Candy Request Contents."),
            @ApiResponse(code = 403, message = "Wrong Candy Resource."),
            @ApiResponse(code = 415, message = "Unsupported Candy representation(media type)."),
            @ApiResponse(code = 429, message = "Throttled, too much candy ... feeling sick.")
        })
    Response get(@ApiParam(value = "Candy ID", required = true) @PathParam("candyid") String candyId);
}
