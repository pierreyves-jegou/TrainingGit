package com.cgi.digitalcv.resource;

import com.cgi.digitalcv.dto.CvDto;
import com.cgi.digitalcv.service.CvReactiveService;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/reactive/cv/")
public class CvReactiveResource {

    @Inject
    CvReactiveService cvReactiveService;


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> create(@Valid CvDto cvDto) {
        Uni<CvDto> cvDtoUni = cvReactiveService.create(cvDto);
        return cvDtoUni
                .map(cvDto1 -> Response.status(Response.Status.OK).entity(cvDto1).build())
                .onFailure()
                .recoverWithItem(x -> Response.status(Response.Status.BAD_REQUEST).build());
    }
}
