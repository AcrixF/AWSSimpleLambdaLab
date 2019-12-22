package simplelab.lambda.cli.model;

import lombok.Data;

/**
 * Request POJO.
 */
@Data
public class HandlerRequest {
    private String name;
    private String time;
}
