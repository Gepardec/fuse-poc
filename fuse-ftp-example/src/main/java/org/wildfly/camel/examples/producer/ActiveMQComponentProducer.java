package org.wildfly.camel.examples.producer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.activemq.camel.component.ActiveMQComponent;

public class ActiveMQComponentProducer {

    @Produces
    @Named("activemq")
    public ActiveMQComponent createActiveMQComponent() {
        ActiveMQComponent activeMQComponent = ActiveMQComponent.activeMQComponent();
        activeMQComponent.setBrokerURL("failover:tcp://192.168.214.1:61616");
        return activeMQComponent;
    }
}
