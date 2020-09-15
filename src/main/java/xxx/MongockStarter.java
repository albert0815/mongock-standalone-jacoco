package xxx;

import com.github.cloudyrock.mongock.driver.mongodb.sync.v4.driver.MongoSync4Driver;
import com.github.cloudyrock.standalone.MongockStandalone;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongockStarter {
  public void startMongock() {
    MongoClient mongoClient = MongoClients.create();

    MongoSync4Driver driver = MongoSync4Driver.withLockSetting(mongoClient, "database", 5, 5, 5);
    driver.setChangeLogCollectionName("mongock_change_log");
    driver.setLockCollectionName("mongock_lock_collection");
    driver.setIndexCreation(true);
    driver.disableTransaction();

    MongockStandalone.Runner runner =
        MongockStandalone.builder()
            .setDriver(driver)
            .addChangeLogsScanPackage("xxx.migration")
            .setTrackIgnored(true)
            .setEnabled(true)
            .buildRunner();

    runner.execute();

  }
}
