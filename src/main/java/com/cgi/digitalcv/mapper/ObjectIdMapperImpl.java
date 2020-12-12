package com.cgi.digitalcv.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.ap.internal.util.Strings;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ObjectIdMapperImpl implements ObjectIdMapper {

    @Override
    public ObjectId map(String value) {
        if(Strings.isEmpty(value)){
            return null;
        }
        return new ObjectId(value);
    }

    @Override
    public String map(ObjectId objectId) {
        if(objectId == null){
            return null;
        }
        return objectId.toString();
    }
}
