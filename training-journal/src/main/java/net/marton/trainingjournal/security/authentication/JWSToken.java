package net.marton.trainingjournal.security.authentication;

import org.picketlink.idm.credential.AbstractToken;
import org.picketlink.json.jose.JWS;
import org.picketlink.json.jose.JWSBuilder;

/**
 * Created by tmarton on 9/13/15.
 */
public class JWSToken  extends AbstractToken {

    private final JWS jws;

    public JWSToken(String encodedToken) {
        super(encodedToken);
        this.jws = new JWSBuilder().build(encodedToken);
    }

    @Override
    public String getSubject() {
        return this.jws.getSubject();
    }
}
