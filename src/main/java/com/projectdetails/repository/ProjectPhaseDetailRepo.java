package com.projectdetails.repository;

import com.projectdetails.model.ProjectPhaseDetailModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPhaseDetailRepo extends MongoRepository<ProjectPhaseDetailModel, String> {

}
