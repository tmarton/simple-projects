package net.marton.trainingjournal.security.startup.configuration;

import net.marton.trainingjournal.entities.Person;
import net.marton.trainingjournal.security.ApplicationRole;
import net.marton.trainingjournal.security.IdentityModelManager;
import net.marton.trainingjournal.security.User;
import org.picketlink.event.PartitionManagerCreateEvent;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.config.SecurityConfigurationException;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.event.PartitionCreatedEvent;
import org.picketlink.idm.model.Attribute;
import org.picketlink.idm.model.Partition;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.Realm;
import org.picketlink.idm.model.basic.Role;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 * Created by tmarton on 9/13/15.
 */
@Stateless
public class AuthenticationInitializer {

//    public static final String KEYSTORE_FILE_PATH = "/server.keystore";
//
//    private KeyStore keyStore;
//
//    public void initialize(@Observes PartitionManagerCreateEvent event) {
//        PartitionManager partitionManager = event.getPartitionManager();
//
//        createDefaultPartition(partitionManager);
//        createDefaultRoles(partitionManager);
//        createAdminAccount(partitionManager);
//    }

//    public void createAdminAccount(PartitionManager partitionManager) {
//        IdentityManager identityManager = partitionManager.createIdentityManager();
//        String login = "superAdmin";
//
//        // if admin exists dont create again
//        if(IdentityModelManager.findByLoginName(login, identityManager) != null) {
//            return;
//        }
//
//        Person person = new Person();
//
//        person.setFirstName("Super");
//        person.setLastName("Admin");
//
//        User admin = new User(login);
//
//        admin.setPerson(person);
//
//        // this user does not have entity Person created
//        identityManager.add(admin);
//
//        identityManager.updateCredential(admin, new Password("admin"));
//
//        Role adminRole = BasicModel.getRole(identityManager, ApplicationRole.ADMINISTRATOR);
//
//        BasicModel.grantRole(partitionManager.createRelationshipManager(), admin, adminRole);
//    }
//
//    private void createDefaultPartition(PartitionManager partitionManager) {
//        Realm realm = partitionManager.getPartition(Realm.class, Realm.DEFAULT_REALM);
//
//        if (realm == null) {
//            try {
//                realm = new Realm(Realm.DEFAULT_REALM);
//
//                realm.setAttribute(new Attribute<byte[]>("PublicKey", getPublicKey()));
//                realm.setAttribute(new Attribute<byte[]>("PrivateKey", getPrivateKey()));
//
//                partitionManager.add(realm);
//            } catch (Exception ex) {
//                throw  new SecurityConfigurationException("Could not create default partition.", ex);
//            }
//        }
//    }
//
//    private void createDefaultRoles(PartitionManager partitionManager) {
//        IdentityManager identityManager = partitionManager.createIdentityManager();
//
//        createRole(ApplicationRole.ADMINISTRATOR, identityManager);
//        createRole(ApplicationRole.USER, identityManager);
//    }
//
//    private void createRole(String roleName, IdentityManager identityManager) {
//        Role role = BasicModel.getRole(identityManager, roleName);
//
//        if (role == null) {
//            role = new Role(roleName);
//            identityManager.add(role);
//        }
//    }
//
//    //TODO handle better passwords
//    private byte[] getPrivateKey() throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
//        return getKeyStore().getKey("server", "test123".toCharArray()).getEncoded();
//    }
//
//    private byte[] getPublicKey() throws KeyStoreException {
//        return getKeyStore().getCertificate("server").getPublicKey().getEncoded();
//    }
//
//    //TODO handle better passwords
//    private KeyStore getKeyStore() {
//        if (this.keyStore == null) {
//            try {
//                this.keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//                getKeyStore().load(getClass().getResourceAsStream(KEYSTORE_FILE_PATH), "test123".toCharArray());
//            } catch (Exception e) {
//                throw new SecurityException("Could not load key store.", e);
//            }
//        }
//
//        return this.keyStore;
//    }
}
