package com.refinitiv.cdb.aws.dynamodb.sample;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class MoviesReadItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
				new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).build();
		 */
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
    			.withRegion(Regions.US_EAST_1)
    			.build();
		
		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable("Movies");

		int year = 2015;
		String title = "The Big New Movie";

		GetItemSpec spec = new GetItemSpec().withPrimaryKey("year", year, "title", title);

		try {
			System.out.println("Attempting to read the item...");
			Item outcome = table.getItem(spec);
			System.out.println("GetItem succeeded: " + outcome);

		} catch (Exception e) {
			System.err.println("Unable to read item: " + year + " " + title);
			System.err.println(e.getMessage());
		}
	}

}
