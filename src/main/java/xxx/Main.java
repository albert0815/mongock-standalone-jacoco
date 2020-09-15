package xxx;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

public class Main {
  public static void main(String args[]) {
    MongoClient mongoClient = MongoClients.create();
    mongoClient.getDatabase("database").getCollection("coll").drop();
    new MongockStarter().startMongock();
  }
}
