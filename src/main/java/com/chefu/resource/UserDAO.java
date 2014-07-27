package com.chefu.resource;

import com.chefu.model.UserAccount;
import com.chefu.utils.ResourceHelper;
import net.vz.mongodb.jackson.DBCursor;
import net.vz.mongodb.jackson.JacksonDBCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by tanvirushabh on 7/26/14.
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserDAO {

    Logger log = Log.getLogger(UserDAO.class);
    private JacksonDBCollection<UserAccount,String> users;

    public UserDAO(JacksonDBCollection<UserAccount, String> users) {
        this.users = users;
    }

    @POST
    public Response createUser(@Valid UserAccount userAccount){

        DBCursor<UserAccount> cursor = users.find().is("emailAddress", userAccount.getEmailAddress());
        if (cursor.hasNext()) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        users.save(userAccount);
        return Response.ok().build();
    }

    @GET
    public UserAccount getUserAccount(@QueryParam("emailAddress") String email){
        DBCursor<UserAccount> cursor = users.find().is("_id", email);
        ResourceHelper.notFoundIfNull(cursor);


        return cursor.next();
    }




}
