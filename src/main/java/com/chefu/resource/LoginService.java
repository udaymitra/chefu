package com.chefu.resource;

import com.chefu.model.UserAccount;
import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class LoginService {
  public String templateName;

  public LoginService(String templateName) {
    this.templateName = templateName;
  }

  @POST
  @Timed
  public Response sayHello(@Valid UserAccount userAccount) {
    Map<String, String> out = new HashMap<String, String>();
    if (userAccount.getEmailAddress().equals("uday")) {
      out.put("response", "success");
    } else {
      out.put("response", "failure");
    }
    return Response.ok(out).build();
  }
}
