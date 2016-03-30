package net.marton.trainingjournal.security.authentication;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.credential.Token;
import org.picketlink.idm.credential.storage.TokenCredentialStorage;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.basic.Realm;
import org.picketlink.json.jose.JWSBuilder;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.UUID;

/**
 * Created by tmarton on 9/13/15.
 */
@Stateless
//public class JWSTokenProvider implements Token.Provider<JWSToken> {
public class JWSTokenProvider {

//    private static final Integer EXPIRATION = 5*60;
//
//    @Inject
//    private PartitionManager partitionManager;
//
//    @Override
//    public JWSToken issue(Account account) {
//
//        TokenCredentialStorage tokenCredentialStorage = getIdentityManager().retrieveCurrentCredential(account, TokenCredentialStorage.class);
//        JWSToken token = null;
//
//        if (tokenCredentialStorage == null) {
//            JWSBuilder builder = new JWSBuilder();
//
//            byte[] privateKey = getPrivateKey();
//
//            builder
//                    .id(UUID.randomUUID().toString())
////                    .rsa256(privateKey)
//                    .issuer(account.getPartition().getName())
//                    .subject(account.getId())
//                    .expiration(getCurrentTime() + EXPIRATION)
//                    .notBefore(getCurrentTime());
//
//            token = new JWSToken(builder.build().encode());
//        } else {
//            token = new JWSToken(tokenCredentialStorage.getToken());
//        }
//
//        return token;
//    }
//
//    @Override
//    public JWSToken renew(Account account, JWSToken jwsToken) {
//        return issue(account);
//    }
//
//    @Override
//    public void invalidate(Account account) {
//        getIdentityManager().removeCredential(account, TokenCredentialStorage.class);
//    }
//
//    @Override
//    public Class<JWSToken> getTokenType() {
//        return JWSToken.class;
//    }
//
//    private IdentityManager getIdentityManager() {
//        return this.partitionManager.createIdentityManager(getPartition());
//    }
//
//    private Realm getPartition() {
//        return partitionManager.getPartition(Realm.class, Realm.DEFAULT_REALM);
//    }
//
//    private byte[] getPrivateKey() {
//        return getPartition().<byte[]>getAttribute("PrivateKey").getValue();
//    }
//
//    private int getCurrentTime() {
//        return (int) (System.currentTimeMillis() / 1000);
//    }
}
