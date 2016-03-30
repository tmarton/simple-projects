package net.marton.trainingjournal.security.startup.configuration;

import net.marton.trainingjournal.security.User;
import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

import javax.enterprise.event.Observes;

/**
 * Created by tmarton on 9/13/15.
 *
 * Identity Management configuration for PicketLink before its initialization
 */
public class IDMConfiguration {

//    public void configureIdentityManagement(@Observes SecurityConfigurationEvent event) {
//        SecurityConfigurationBuilder builder = event.getBuilder();

//        builder
//                .idmConfig()
//                .named("default.config")
//                .stores()
//                .jpa()
//                .supportType(User.class)
//                .supportAllFeatures();
//    }
}
