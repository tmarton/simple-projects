package net.marton.trainingjournal.security.service;

import net.marton.trainingjournal.security.authentication.JWSToken;
import org.picketlink.Identity;
import org.picketlink.authorization.annotations.LoggedIn;
import org.picketlink.idm.credential.Token;
import org.picketlink.idm.model.Account;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by tmarton on 9/13/15.
 */
@Path("/logout")
public class LogoutService {

//    @Inject
//    private Token.Provider<JWSToken> tokenProvider;
//
//    @Inject
//    private Identity identity;
//
//    @POST
//    @LoggedIn
//    public void logout() {
//        Account account = this.identity.getAccount();
//
//        this.tokenProvider.invalidate(account);
//        this.identity.logout();
//    }
}
