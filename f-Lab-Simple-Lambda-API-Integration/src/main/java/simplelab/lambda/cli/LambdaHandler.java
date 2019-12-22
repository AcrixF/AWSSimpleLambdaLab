package simplelab.lambda.cli;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import simplelab.lambda.cli.model.HandlerRequest;
import simplelab.lambda.cli.model.HandlerResponse;

/**
 * RequestHandler implementation.
 */
public final class LambdaHandler implements RequestHandler<HandlerRequest, HandlerResponse> {

    /**
     * Handle request.
     *
     * @param request  - input to lambda handler
     * @param context - context object
     * @return greeting text
     */
    public HandlerResponse handleRequest(final HandlerRequest request, final Context context) {

        String greeting = "";

        if (!isEmpty(request.getTime())) {
            greeting = "Good " + request.getTime() + ", ";
        } else {
            greeting = "Good Day, ";
        }

        if (!isEmpty(request.getName())) {
            greeting = greeting + request.getName();
        } else {
            greeting = greeting + "User";
        }

        context.getLogger().log(greeting);

        return new HandlerResponse(greeting);
    }

    private boolean isEmpty(final String str) {
        return (str == null || str.isEmpty());
    }

}
