package com.cgi.digitalcv.repository;

import com.cgi.digitalcv.domain.Cv;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CvImperativeRepository implements PanacheMongoRepository<Cv> {
}
