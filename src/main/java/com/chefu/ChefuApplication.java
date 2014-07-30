package com.chefu;

import com.chefu.configuration.ChefuConfiguration;
import com.chefu.model.UserAccount;
import com.chefu.mongo.MongoManaged;
import com.chefu.resource.ChefuResource;
import com.chefu.resource.LandingPageResource;
import com.chefu.resource.UserDAO;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.chefu.resource.LoginService;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import net.vz.mongodb.jackson.JacksonDBCollection;

public class ChefuApplication extends Application<ChefuConfiguration> {
  public static void main(String[] args) throws Exception {
    new ChefuApplication().run(args);
  }

  /** need to check
  public static void main(String[] args) throws Exception {
      new ChefuApplication().run(new String[]{"server", "src/main/resources/chefu.yml"});
  }
  **/

  @Override
  public String getName() {
      return "Chefu";
  }

  @Override
  public void initialize(Bootstrap<ChefuConfiguration> bootstrap) {
    bootstrap.addBundle(new ViewBundle());
    bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
  }

  @Override
  public void run(ChefuConfiguration configuration,
                  Environment environment) {
    Mongo mongo = new Mongo(configuration.mongohost, configuration.mongoport);
    DB db = mongo.getDB(configuration.mongodb);
    JacksonDBCollection<UserAccount, String> userDBCollection =
            JacksonDBCollection.wrap(db.getCollection("users"), UserAccount.class, String.class);

    MongoManaged mongoManaged = new MongoManaged(mongo);
    environment.lifecycle().manage(mongoManaged);

    environment.healthChecks().register("Mongo", new MongoHealthCheck(mongo));

    environment.jersey().register(new UserDAO(userDBCollection));

    final ChefuResource chefuResource =
            new ChefuResource(configuration.getTemplate(), configuration.getDefaultName());
    final TemplateHealthCheck healthCheck =
            new TemplateHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(chefuResource);

    final LandingPageResource landingPageResource = new LandingPageResource();
    environment.jersey().register(landingPageResource);

    final LoginService loginService = new LoginService("user.ftl");
    environment.jersey().register(loginService);
  }

}
