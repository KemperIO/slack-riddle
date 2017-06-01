package io.kemper.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.domain.Riddle;

import java.io.IOException;
import java.util.Random;

public class DynamoRiddleService implements RiddleService {

    private static DynamoRiddleService ourInstance = new DynamoRiddleService();
    private final static String TABLE_NAME = "riddles";
    private Table table;
    private Random randy;

    public static RiddleService getInstance() {
        return ourInstance;
    }

    private DynamoRiddleService() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);
        table = dynamoDB.getTable(TABLE_NAME);
        randy = new Random();
    }

    private Riddle getRiddleFromDynamoItem(Item item) {
        int id = item.getInt("riddleId");
        String question = item.getString("question");
        String answer = item.getString("answer");
        return new Riddle(id, question, answer);
    }

    @Override
    public Riddle getRandomRiddle() {
        //Note: this breaks for sparse IDs
        int maxId = table.describe().getItemCount().intValue();
        int randId = randy.nextInt(maxId);
        return getRiddle(randId);
    }

    @Override
    public Riddle getRiddle(Integer id) {
        //Note: id is a String param in the DB
        String stringId = String.valueOf(id);
        GetItemSpec spec = new GetItemSpec().withPrimaryKey("riddleId", stringId);
        Item dynamoItem = table.getItem(spec);
        return getRiddleFromDynamoItem(dynamoItem);
    }
}
