package simplelab.lambda.cli;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import simplelab.lambda.cli.model.HandlerResponse;
import simplelab.lambda.cli.model.HandlerRequest;

public final class LambdaHandler implements RequestHandler<HandlerRequest, HandlerResponse> {

    public HandlerResponse handleRequest( final HandlerRequest request, final Context context) {
        context.getLogger().log("Hello " + request.getName());
        return new HandlerResponse("Hello " + request.getName());
    }
}
