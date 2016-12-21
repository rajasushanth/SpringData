package org.spring.mongodb.example;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import com.mongodb.Mongo;

public class MongoApp {
	private static final Log log = LogFactory.getLog(MongoApp.class);

	public static void main(String[] args) throws Exception {
		MongoOperations mongoOps = new MongoTemplate(new Mongo(), "database");
		mongoOps.insert(new Person("Joe", 34));
		log.info(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class));
		mongoOps.dropCollection("person");
	}
}