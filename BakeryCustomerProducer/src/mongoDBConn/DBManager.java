package mongoDBConn;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
/**
import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import customerRegister.Customer;**/

public class DBManager {
	
	/**	public String collectionName = "Customer";
	String url = "mongodb://localhost:27017";
	MongoClient mongoClient = MongoClients.create(url);
	MongoDatabase database = mongoClient.getDatabase("bakery");
	MongoCollection<Document> collection = database.getCollection(collectionName);
	Scanner input = new Scanner(System.in);
	Gson gson = new Gson();
	
	
	public void connectToDatabase() {
		try (var mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            var database = mongoClient.getDatabase("Bakery");

            System.out.println("database name -> " + database.getName());

            for (String name: database.listCollectionNames()) {

                System.out.println(name);
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	
	public void inserttoDB(String name) {
		//Document customer = new Document("name", name);
		//collection.insertOne(customer);
		this.connectToDatabase();
		System.out.println("Hiiiiiii" + name );
	}
	

	
	//Insert to DB
	public void saveHashMap(ArrayList<Document> documents) {
		if (collection.countDocuments() > 0) {
			
				database.createCollection(collectionName);
				collection = database.getCollection(collectionName);
				collection.insertMany(documents);
				
			
		}
		else {
			try {
				collection.insertMany(documents);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	//Load from DB
	public ArrayList<Customer> loadHashMap() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		if (collection.countDocuments() <=0) {
			System.out.println("Collection Emplty, Cannot Load");
		}
		else {
			MongoCursor<Document> cursor = collection.find().iterator();
			try {
				while (cursor.hasNext()) {
					customers.add(gson.fromJson(cursor.next().toJson(), Customer.class));	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				cursor.close();
			}
		}
		
		return customers;
	}**/
	
}
