package com.chefu.resource;

/**
 * Created by tanvirushabh on 7/29/14.
 */

import com.chefu.views.LandingPageView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class LandingPageResource {

    @GET
    public LandingPageView getLandingPageView(){
        return new LandingPageView();
    }
}
