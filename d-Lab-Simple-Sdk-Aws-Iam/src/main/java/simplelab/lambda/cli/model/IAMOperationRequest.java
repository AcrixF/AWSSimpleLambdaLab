package simplelab.lambda.cli.model;

import lombok.Data;

@Data
public class IAMOperationRequest {
    private String operation;
    private String userName;
}
