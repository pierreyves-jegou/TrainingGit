package com.cgi.digitalcv.mapper;

import com.cgi.digitalcv.domain.Cv;
import com.cgi.digitalcv.dto.CvDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi", uses = ObjectIdMapper.class)
public interface CvMapper {

    Cv toDomain(CvDto cvDto);

    List<CvDto> toDtos(List<Cv> cvs);

    CvDto toDto(Cv cv);

}
