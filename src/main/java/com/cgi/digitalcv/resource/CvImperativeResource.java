package com.cgi.digitalcv.resource;


import com.cgi.digitalcv.dto.CvDto;
import com.cgi.digitalcv.service.CvImperativeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/imperative/cv")
public class CvImperativeResource {

    @Inject
    private CvImperativeService cvImperativeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CvDto> getAll(){
        return this.cvImperativeService.getAll();
    }

}
