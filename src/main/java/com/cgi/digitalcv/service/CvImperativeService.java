package com.cgi.digitalcv.service;

import com.cgi.digitalcv.dto.CvDto;
import com.cgi.digitalcv.mapper.CvMapper;
import com.cgi.digitalcv.repository.CvImperativeRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CvImperativeService {

    @Inject
    CvMapper cvMapper;

    @Inject
    CvImperativeRepository cvImperativeRepository;

    public List<CvDto> getAll() {
        return cvMapper.toDtos(this.cvImperativeRepository.listAll());
    }
}
