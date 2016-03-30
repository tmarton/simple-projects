package net.marton.trainingjournal.security.startup.configuration;

import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

import javax.enterprise.event.Observes;

/**
 * Created by tmarton on 9/13/15.
 *
 * Http Security configuration for PicketLink before its initialization
 */
public class HttpSecurityConfiguration {

//    public void onInit(@Observes SecurityConfigurationEvent event) {
//        SecurityConfigurationBuilder builder = event.getBuilder();

//        builder
//                .identity()
//                .stateless()
//                .http()
//                .forPath("/rest/api/xxx/*")
//                .authenticateWith()
//                .token()
//                .cors()
//                .allowAll();
//    }
}
