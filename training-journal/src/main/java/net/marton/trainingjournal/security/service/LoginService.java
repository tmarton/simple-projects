package net.marton.trainingjournal.security.service;

import net.marton.trainingjournal.security.IdentityModelManager;
import net.marton.trainingjournal.security.User;
import org.picketlink.Identity;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.credential.Credentials;
import org.picketlink.idm.credential.Token;
import org.picketlink.idm.model.Account;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tmarton on 9/13/15.
 */
@Stateless
@Path("/login")
@Produces("application/json")
@Consumes("application/json")
public class LoginService {

//    @Inject
//    private Identity identity;
//
//    @Inject
//    private DefaultLoginCredentials credentials;
//
//    @Inject
//    private IdentityModelManager identityModelManager;
//
//    @POST
//    public Response authenticate(DefaultLoginCredentials credential) {
//
//        if (credentials == null) {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
//
//        Map<String, Object> messageData = new HashMap<>();
//        try {
//            if (!this.identity.isLoggedIn()) {
//                this.credentials.setUserId(credential.getUserId());
//                this.credentials.setPassword(credential.getPassword());
//                Identity.AuthenticationResult authenticationResult = this.identity.login();
//
//                if (authenticationResult == Identity.AuthenticationResult.FAILED) {
//                    messageData.put("message", "Wrong credentials. Try again.");
//                    return Response.status(Response.Status.BAD_REQUEST).build();
//                }
//            }
//
//            Account account = this.identity.getAccount();
//            Token token = identityModelManager.issueToken(account);
//
//            return Response.status(Response.Status.OK).entity(token).build();
//
//        } catch (Exception ex) {
//            messageData.put("message", ex.getMessage());
//            return Response.status(Response.Status.BAD_REQUEST).entity(messageData).build();
//        }
//
//    }
}
