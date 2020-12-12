package com.cgi.digitalcv.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.Qualifier;
import org.mapstruct.ap.internal.util.Strings;

public interface ObjectIdMapper {

    ObjectId map(String value);

    String map(ObjectId objectId);

}
