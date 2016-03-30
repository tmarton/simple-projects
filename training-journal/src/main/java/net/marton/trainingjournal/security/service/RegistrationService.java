package net.marton.trainingjournal.security.service;

import net.marton.trainingjournal.security.IdentityModelManager;
import net.marton.trainingjournal.security.JsRegistrationObject;
import net.marton.trainingjournal.security.User;
import org.picketlink.idm.credential.Token;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tmarton on 9/13/15.
 */
@Stateless
@Path("/register")
@Produces("application/json")
@Consumes("application/json")
public class RegistrationService {

//    @Inject
//    private IdentityModelManager identityModelManager;
//
//    @POST
//    public Response register(JsRegistrationObject jsRegistrationObject) {
//        if (! jsRegistrationObject.getPassword().equals(jsRegistrationObject.getPasswordConfirmation())) {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//
//        Map<String, Object> messageData = new HashMap<>();
//
//        try {
//            if (this.identityModelManager.findByLoginName(jsRegistrationObject.getLoginName()) == null) {
//                User account = this.identityModelManager.createAccount(jsRegistrationObject);
//                Token token = this.identityModelManager.issueToken(account);
//
//                return Response.status(Response.Status.OK).entity(token).build();
//            } else {
//                messageData.put("message","This username is already in use. Try another one.");
//                return Response.status(Response.Status.BAD_REQUEST).build();
//            }
//        } catch (Exception ex) {
//            messageData.put("message", ex.getMessage());
//            return  Response.status(Response.Status.BAD_REQUEST).entity(messageData).build();
//        }
//    }

}
