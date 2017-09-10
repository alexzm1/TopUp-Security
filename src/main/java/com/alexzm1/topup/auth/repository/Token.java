package com.alexzm1.topup.auth.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * <b>Token</b>
 *
 * @author alexzm1
 * @version 1.1
 * @since 1.1
 */
@Document(collection = "Tokens")
public class Token {

    @Id
    public String id;

    public String verifier;

    public String secret;

    @Field("user_name")
    public String userName;

    @Field("consumer_key")
    public String consumerKey;

    public long timestamp;

    public boolean isAccessToken;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the verifier
     */
    public String getVerifier() {
        return verifier;
    }

    /**
     * @param verifier the verifier to set
     */
    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    /**
     * @return the secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret the secret to set
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the consumerKey
     */
    public String getConsumerKey() {
        return consumerKey;
    }

    /**
     * @param consumerKey the consumerKey to set
     */
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    /**
     * @return the timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return the isAccessToken
     */
    public boolean isAccessToken() {
        return isAccessToken;
    }

    /**
     * @param isAccessToken the isAccessToken to set
     */
    public void setAccessToken(boolean isAccessToken) {
        this.isAccessToken = isAccessToken;
    }

}
