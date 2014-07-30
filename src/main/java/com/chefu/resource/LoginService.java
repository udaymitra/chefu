package com.chefu.resource;

import com.chefu.model.UserAccount;
import com.chefu.view.LoginView;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/login")
@Produces(MediaType.TEXT_HTML)

public class LoginService {
  public String templateName;

  public LoginService(String templateName) {
    this.templateName = templateName;
  }

  @GET
  @Timed
  public LoginView sayHello(@QueryParam("userid") Optional<String> userid) {
    return new LoginView(templateName, new UserAccount(userid.get(), "password"));
  }
}
