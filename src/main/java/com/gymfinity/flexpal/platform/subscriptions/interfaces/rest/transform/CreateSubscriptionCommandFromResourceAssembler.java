package com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.transform;

import com.gymfinity.flexpal.platform.subscriptions.domain.model.commands.CreateSubscriptionCommand;
import com.gymfinity.flexpal.platform.subscriptions.interfaces.rest.resources.CreateSubscriptionResource;

public class CreateSubscriptionCommandFromResourceAssembler {

    public static CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionResource resource) {
        return new CreateSubscriptionCommand(resource.price(), resource.services());
    }
}
