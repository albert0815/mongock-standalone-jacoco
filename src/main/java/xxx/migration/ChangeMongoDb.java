package xxx.migration;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

@ChangeLog
public class ChangeMongoDb {

  @ChangeSet(order = "1", author = "Albert", id = "ChangeMongoDb-change", runAlways = true)
  public void change(MongoDatabase mongoDatabase) {
    mongoDatabase.getCollection("coll").insertOne(new Document("field", "value"));
  }

}
