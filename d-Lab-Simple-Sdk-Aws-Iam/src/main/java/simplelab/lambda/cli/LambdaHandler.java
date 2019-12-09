package simplelab.lambda.cli;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import simplelab.lambda.cli.model.IAMOperationRequest;
import simplelab.lambda.cli.model.IAMOperationResponse;
import simplelab.lambda.cli.services.IAMService;

public class LambdaHandler implements RequestHandler<IAMOperationRequest, IAMOperationResponse> {

    private IAMService service;

    public LambdaHandler() {
        this.service = new IAMService();
    }

    /**
     * Handle request
     * @param request - input to lambda handler
     * @param context - context object
     * @return Greeting text
     */

    @Override
    public IAMOperationResponse handleRequest(IAMOperationRequest request, Context context) {
        context.getLogger().log("Request Operation = " + request.getOperation() + " User name = " + request.getUserName());

        switch (request.getOperation()) {
            case "CREATE":
                return this.service.createUser(request.getUserName());
            case "CHECK":
                return this.service.checkUser(request.getUserName());
            case "DELETE":
                return this.service.deleteUser(request.getUserName());
            default:
                return new IAMOperationResponse(null, "Invalid operation " + request.getOperation() + " Allowed: CREATE, CHECK, DELETE");
        }
    }
}
