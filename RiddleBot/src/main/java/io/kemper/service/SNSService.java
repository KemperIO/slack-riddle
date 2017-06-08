package io.kemper.service;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

public class SNSService {

    private static final String TOPIC_ARN = "arn:aws:sns:us-east-1:660085092387:riddle";

    public static PublishResult publishMessage(String message) {

        //create a new SNS client and set endpoint
        //AmazonSNSClient snsClient = new AmazonSNSClient(new ProfileCredentialsProvider("tj"));
        AmazonSNSClient snsClient = new AmazonSNSClient();
        snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));

        //publish to an SNS topic
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, message);
        PublishResult publishResult = snsClient.publish(publishRequest);

        //print MessageId of message published to SNS topic
        System.out.println("MessageId - " + publishResult.getMessageId());

        return publishResult;

    }

}
