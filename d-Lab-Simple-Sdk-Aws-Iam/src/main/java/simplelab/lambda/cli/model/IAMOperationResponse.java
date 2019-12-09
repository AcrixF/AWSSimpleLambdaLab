package simplelab.lambda.cli.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IAMOperationResponse {
    private String message;
    private String errorMessage;
}
