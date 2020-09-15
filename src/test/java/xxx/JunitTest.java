package xxx;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunitTest {
  @Test
  public void testMongock() {
    MongoClient mongoClient = MongoClients.create();
    MongoCollection<Document> coll = mongoClient.getDatabase("database").getCollection("coll");
    coll.drop();
    new MongockStarter().startMongock();
    Assertions.assertEquals(1, coll.countDocuments());
  }
}
