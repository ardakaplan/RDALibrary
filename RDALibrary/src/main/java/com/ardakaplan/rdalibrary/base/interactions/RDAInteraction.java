package com.ardakaplan.rdalibrary.base.interactions;

import com.ardakaplan.rdalibrary.RDARequestException;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.HoustonWeHaveAProblemHere;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.RDAAuthorizationErrorInteractionException;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.RDAInteractionException;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.RDANoNetworkInteractionException;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.RDANotFoundInteractionException;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.RDANullResponseInteractionException;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.RDAServerInteractionException;
import com.ardakaplan.rdalibrary.base.interactions.exceptions.ServerMessageInteractionException;

/**
 * Created by Arda Kaplan at 12/13/2018
 * <p>
 * arda.kaplan09@gmail.com
 */
public abstract class RDAInteraction<In, Out> {

    private In in;

    public RDAInteraction(In in) {
        this.in = in;
    }

    public RDAInteraction() {
        this.in = null;
    }

    public In getIn() {
        return in;
    }

    public void setIn(In in) {
        this.in = in;
    }

    public abstract void execute(RDAInteractionResultListener<Out> rdaInteractionResultListener);

    protected RDAInteractionException handleHttpError(RDARequestException rdaRequestException) {

        switch (rdaRequestException.getHttpError()) {

            case AUTHENTICATION_ERROR:

                return new RDAAuthorizationErrorInteractionException();

            case SERVER_ERROR:

                return new RDAServerInteractionException();

            case NOT_FOUND_ERROR:

                return new RDANotFoundInteractionException();

            case NO_NETWORK_ERROR:

                return new RDANoNetworkInteractionException();

            case NULL_RESPONSE_ERROR:

                return new RDANullResponseInteractionException();

            case SHOW_SERVER_MESSAGE_ERROR:

                return new ServerMessageInteractionException(rdaRequestException.getMessage());

            default:

                return new HoustonWeHaveAProblemHere();
        }
    }
}
