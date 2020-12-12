package com.cgi.digitalcv.domain;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@Data
@MongoEntity
public class Cv {

    @BsonId
    ObjectId id;
    String lastName;
    String firstName;

}
