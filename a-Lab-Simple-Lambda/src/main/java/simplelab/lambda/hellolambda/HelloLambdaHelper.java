package simplelab.lambda.hellolambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HelloLambdaHelper implements RequestHandler<String, String> {

    public String handleRequest(final String s, final Context context) {
       context.getLogger().log("input: " + s + "\n");
       String greeting = "Hello " + s;
       return greeting;
    }
}
