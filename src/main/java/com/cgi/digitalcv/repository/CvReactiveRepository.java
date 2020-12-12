package com.cgi.digitalcv.repository;

import com.cgi.digitalcv.domain.Cv;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CvReactiveRepository implements ReactivePanacheMongoRepository<Cv> {


    public Uni<Cv> persistAndReturn(Cv cv) {
        return this.persist(cv).map(unused -> cv);
    }

    public Uni<Boolean> existsByFirstNameAndLastName(String firstName, String lastName){
        return this.find("firstName=?1 AND lastName=?2", firstName, lastName)
                .count().map(number -> {
                if(number > 0){
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
        });
    }



}
