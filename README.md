# AWSSimpleLambdaLab
AWS Lambda Training
Intructions 

# a-Lab-Simple-Lambda
  1 - Access to AWS Console 
  2 - Lambda services
  3 - Create Function
    3.1 - Create from scratch 
    3.2 - Function name 
    3.3 - Runtime Java 8 
  4 - Load Jar file
    4.1 - Inside the project a-Lab-Simple-Lambda run: mvn clean package
    4.2 - Load the Jar file 
    4.3 - Save
  5 - Test lambda function
    5.1 - Define a event 
    5.2 - Event's name
    5.3 - Event's body
      5.3.1 "name" (with the cuotes)
    5.4 - Create Event
 6 - Save and Test
 
 ####################################### Aditional Steps ############################################################
 
 # Create a bucket CLI 
  aws s3 mb s3://[bucket_name]  —profile [profile_name]
  
 #####################################################################################################################
 
 # b-Lab-Simple-Lambda-CLI
 
  1 - Inside b-Lab-Simple-Lambda-CLI run: mvn clean package
  2 - Copy Jar file to S3 bucket
	  2.1 - aws s3 cp [jar_relative_path]  s3://[bucket_name]/[jar_file] --profile [profile_name]
  3 - Create Policy
    3.1 - aws iam create-policy --policy_name [policy_name] --policy-document file//./[relative_path] --profile [profile_name]
  4 - Create a Role
    4.1 - aws iam create-role --role-name [role_name] --assume-role-policy-document file://./[relative_path] --profile [profile_name]
  5 - Attache the Policy to the Role
    5.1 - aws iam attach-role-policy --role-name [role_name] --policy-arn arn:aws:iam::[account_id]:policy/[policy_name] --profile [profile_name]
  6 - Create Lambda function providing Role and S3 Location 
    6.1 - aws lambda create-function \
        --function-name [lambda_name] --runtime [runtime] --role arn:aws:iam::[account_id]:role/[role_name] --handler [package_path]::[method_handler] --code S3Bucket=[bucket_name],S3Key=[jar_file] --timeout 15 --memory-size 512 --profile produser
  7 - Invoke Lambda from CLI
    7.1 - aws lambda invoke \ --invocation-type RequestResponse \ --function-name [lambda_name]\ --log-type Tail \ --payload [json_file] \ --profile [profile_name] [output_name].txt 
    
 ##################################### Manual Cleaning #################################################################
  1 - Delete the Lambda Function
    1.1 - aws lambda delete-function --function-name [function_name] --profile [profile_name]
  2 - Delete attache Policy-Role
    2.1 - aws iam detach-role-policy --role-name [role_name] --policy-arn arn:aws:iam::[aws_account_id]:policy/[policy_name] --profile [profile_name]
  3 - Delete Role
    3.1 - aws iam delete-role --role-name lambda_iam_role_test --profile [profile_name]
  4 - Delete policy 
    4.1 - aws iam delete-policy --policy-arn arn:aws:iam::[aws_account_id]:policy/[policy_name] --profile [profile_name]

 #########################################################################################################################
 
 # c-Lab-Simple-Lambda-CLI-CloudFormation
 
  1 - Inside c-Lab-Simple-Lambda-CLI-CloudFormation run: mvn clean package
  2 - Copy Jar File to S3 
    2.1 - aws s3 cp [local_file_path] s3://[bucket_name]/[file_name] --profile [profile_name]
  3 - Create Stack 
    3.1 - aws cloudformation create-stack --stack-name teststack --template-body file://./[template_file_name] --region us-east-1 --profile [profile_nae] --capabilities CAPABILITY_NAMED_IAM
  4 - Describe CloudFormation Stack
    4.1 - aws cloudformation describe-stacks --stack-name [stack_name] --region us-east-1 --profile [profile_name]
  5 - Invoking Lambda Function CloudFormation
    5.1 - aws lambda invoke --invocation-type RequestResponse --function-name [function_name] --log-type Tail --payload '{"name":"Heartin"}' --profile [pofile_name] outputfile.txt
  6 - Deleting CloudFormation Stack 
    6.1 aws cloudformation delete-stack --stack-name [stack_name] --region us-east-1 --profile [profile_name]
    
 # d-Lab-Simple-Lambda-Sdk-Aws-Iam
       (**In progress**)
  
 # e-Lab-Simple-API-CloudFormat
 
  1 - Inside the project e-Lab-Simple-API-CloudFormat -> resources
    1.1 - Resource api-using-cloudformat.yml
  2 - Create stack 
    2.1 - aws cloudformation create-stack --stack-name [stack_name] --template-url https://[bucket].s3.amazonaws.com/[tempate_file_name] --region us-east-1 --profile [profile_name]
  3 - Describe the stack 
    3.1 - aws cloudformation describe-stacks \ -stack-name [stack_name] --region us-east-1 --profile [profile_name]
    
  # f-Lab-Simple-Lambda-API-Integration
  1 - Inside project f-Lab-Simple-Lambda-API-Integration run: mvn clean package
  2 - Upload the jar file to the aws bucket
  3 - Upload the Template file to the aws bucket(api-gateway-for-lambda-integration-cf-template.yml)
  4 - Create the stack for the lambda function (**lambda-for-api-gateway-cf-template.yml**)
    4.1 - aws cloudformation create-stack --stack-name [stack_name]  --template-body file://./[templeta_file_name] --region us-east-1 --profile [profile_name] --capabilities CAPABILITY_NAMED_IAM
  5 - Create the stack for API gateway
    5.1 - aws cloudformation create-stack --stack-name [stack_name] --template-url https://[bucket_name].s3.amazonaws.com/api-gateway-for-lambda-integration-cf-template.yml --region us-east-1 --profile [profile_name]
  
  
  
