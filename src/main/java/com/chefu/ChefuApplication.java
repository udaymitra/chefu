package com.chefu;

import com.chefu.configuration.ChefuConfiguration;
import com.chefu.resource.ChefuResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ChefuApplication extends Application<ChefuConfiguration> {
  public static void main(String[] args) throws Exception {
    new ChefuApplication().run(args);
  }

  @Override
  public String getName() {
    return "hello-world";
  }

  @Override
  public void initialize(Bootstrap<ChefuConfiguration> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(ChefuConfiguration configuration,
                  Environment environment) {
    final ChefuResource chefuResource =
            new ChefuResource(configuration.getTemplate(), configuration.getDefaultName());
    final TemplateHealthCheck healthCheck =
            new TemplateHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(chefuResource);
  }

}