package com.cgi.digitalcv.service;

import com.cgi.digitalcv.domain.Cv;
import com.cgi.digitalcv.dto.CvDto;
import com.cgi.digitalcv.mapper.CvMapper;
import com.cgi.digitalcv.repository.CvReactiveRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CvReactiveService {

    @Inject
    CvReactiveRepository cvReactiveRepository;

    @Inject
    CvMapper cvMapper;

    public Uni<CvDto> create(CvDto cvDto) {
        return Uni.createFrom().item(() -> cvMapper.toDomain(cvDto))
                .flatMap(cv -> this.validateCvNotExists(cv))
                .flatMap(cv -> this.cvReactiveRepository.persistAndReturn(cv))
                .map(cv -> cvMapper.toDto(cv));
    }

    private Uni<Cv> validateCvNotExists(Cv cv) {
        return this.cvReactiveRepository.existsByFirstNameAndLastName(cv.getFirstName(), cv.getLastName())
                .map(exists -> {
                    if (Boolean.TRUE.equals(exists)) {
                        throw new RuntimeException("Cv with firstName and lastName already exists");
                    }
                    return cv;
                });
    }

}
