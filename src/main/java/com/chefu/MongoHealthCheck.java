package com.chefu;

import com.codahale.metrics.health.HealthCheck;
import com.mongodb.Mongo;

/**
 * Created by tanvirushabh on 7/26/14.
 */
public class MongoHealthCheck extends HealthCheck{

    private Mongo mongo;

    public MongoHealthCheck(Mongo mongo) {
        this.mongo = mongo;
    }

    @Override
    protected Result check() throws Exception {
        mongo.getDatabaseNames();
        return Result.healthy();
    }
}
