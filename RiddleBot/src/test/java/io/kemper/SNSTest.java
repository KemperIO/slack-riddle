package io.kemper;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import org.junit.Test;

public class SNSTest {

    public static final String TOPIC_ARN = "arn:aws:sns:us-east-1:660085092387:riddle";

    @Test
    public void testPublish() {

        //create a new SNS client and set endpoint
        AmazonSNSClient snsClient = new AmazonSNSClient(new ProfileCredentialsProvider("tj"));
        snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));

        //publish to an SNS topic
        String msg = "trying to publish";
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, msg);
        PublishResult publishResult = snsClient.publish(publishRequest);

        //print MessageId of message published to SNS topic
        System.out.println("MessageId - " + publishResult.getMessageId());
    }

}
