package net.marton.trainingjournal.security;

import net.marton.trainingjournal.entities.Person;
import net.marton.trainingjournal.security.authentication.JWSToken;
import net.marton.trainingjournal.service.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.credential.Token;
import org.picketlink.idm.model.Account;
import org.picketlink.idm.model.basic.BasicModel;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.query.IdentityQuery;
import org.picketlink.idm.query.IdentityQueryBuilder;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by tmarton on 9/13/15.
 */
@Stateless
public class IdentityModelManager {

//    @Inject
//    private IdentityManager identityManager;
//
//    @Inject
//    private RelationshipManager relationshipManager;
//
//    @Inject
//    private Token.Provider<JWSToken> tokenProvider;
//
//    @Inject
//    private PersonService personService;
//
//    public User findByLoginName(String loginName) {
//        return findByLoginName(loginName, this.identityManager);
//    }
//
//    public User createAccount(JsRegistrationObject jsRegistrationObject) {
//        if (!jsRegistrationObject.isValid()) {
//            throw new IllegalArgumentException("Insufficient information");
//        }
//
//        Person person = new Person();
//        person.setFirstName(jsRegistrationObject.getFirstName());
//        person.setLastName(jsRegistrationObject.getLastName());
//
//        personService.createUser(person);
//
//        User newUser = new User(jsRegistrationObject.getLoginName());
//        newUser.setPerson(person);
//
//        this.identityManager.add(newUser);
//        updatePassword(newUser, jsRegistrationObject.getPassword());
//
//        return newUser;
//    }
//
//    public void updatePassword(Account account, String password) {
//        this.identityManager.updateCredential(account, new Password(password));
//    }
//
//    public void grantRole(User account, String roleName) {
//        Role role = BasicModel.getRole(this.identityManager, roleName);
//        BasicModel.grantRole(this.relationshipManager, account, role);
//    }
//
//    public boolean hasRole(User account, String roleName) {
//        Role role = BasicModel.getRole(this.identityManager, roleName);
//        return BasicModel.hasRole(this.relationshipManager, account, role);
//    }
//
//    public Token issueToken(Account account) {
//        return this.tokenProvider.issue(account);
//    }
//
//    public static User findByLoginName(String loginName, IdentityManager identityManager) {
//        if (StringUtils.isBlank(loginName)) {
//            throw new IllegalArgumentException("Invalid login name.");
//        }
//
//        IdentityQueryBuilder queryBuilder = identityManager.getQueryBuilder();
//        IdentityQuery<User> query = queryBuilder.createIdentityQuery(User.class);
//
//        query.where(queryBuilder.equal(User.USER_NAME, loginName));
//        List<User> result = query.getResultList();
//
//        if (result!= null && !result.isEmpty()) {
//            return result.get(0);
//        }
//
//        return null;
//    }
}
