package org.wso2.samples.osgi.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.samples.osgi.SampleFederatedAuthenticator;

import java.util.Hashtable;

/**
 * @scr.component name="org.wso2.samples.osgi.internal.componant"
 * immediate="true"
 */
public class SampleServiceComponant {
    private static final Log LOGGER = LogFactory.getLog(SampleServiceComponant.class);

    protected void activate(ComponentContext ctxt) {
        try {
            SampleFederatedAuthenticator sampleFederatedAuthenticator = new SampleFederatedAuthenticator();
            Hashtable<String, String> props = new Hashtable<String, String>();

            ctxt.getBundleContext().registerService(SampleFederatedAuthenticator.class.getName(),
                    sampleFederatedAuthenticator, props);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("sampleFederatedAuthenticator Custome Authenticator bundle is activated");
            }
        } catch (Throwable e) {
            LOGGER.fatal(" Error while activating sampleFederatedAuthenticator authenticator ", e);
        }
    }

    protected void deactivate(ComponentContext ctxt) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("sampleFederatedAuthenticator Custom Authenticator bundle is deactivated");
        }
    }
}