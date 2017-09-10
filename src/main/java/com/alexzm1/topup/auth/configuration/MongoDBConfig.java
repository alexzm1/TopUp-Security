package com.alexzm1.topup.auth.configuration;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * <b>MongoDBConfig</b>
 * <p>
 * MongoDB Configuration class
 * <p>
 * <p>
 * Host: 127.0.0.1
 * </P>
 * <p>
 * Port: 27017
 * </P>
 *
 * @author alexzm1
 * @version 1.0
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.alexzm1.topup.auth.repository")
@EnableMongoRepositories(basePackages = "com.alexzm1.topup.auth.repository")
@PropertySource({"classpath:persistence.properties"})
public class MongoDBConfig extends AbstractMongoConfiguration {

    private final static Logger LOG = LoggerFactory.getLogger(MongoDBConfig.class);

    @Autowired
    private Environment env;

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getDatabaseName() {
        return env.getProperty("mongo.database");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Bean
    public Mongo mongo() throws UnknownHostException {
        final String host = env.getProperty("mongo.host");
        final int port = env.getProperty("mongo.port", Integer.class);
        final ServerAddress serverAddress = new ServerAddress(host, port);
        LOG.info(String.format("Mongo DB connected to host: %s:%s", host, port));
        final MongoCredential credentials = MongoCredential.createCredential(
                env.getProperty("mongo.username"),
                env.getProperty("mongo.database"),
                env.getProperty("mongo.password").toCharArray());

        return new MongoClient(serverAddress,
                Arrays.asList(credentials),
                buildMongoClientOption());
    }

    /**
     * Creates a {@link MongoClientOptions} instance
     *
     * @return An instance of {@link MongoClientOptions}
     */
    private MongoClientOptions buildMongoClientOption() {
        return MongoClientOptions.builder().writeConcern(WriteConcern.ACKNOWLEDGED).build();
    }

}
