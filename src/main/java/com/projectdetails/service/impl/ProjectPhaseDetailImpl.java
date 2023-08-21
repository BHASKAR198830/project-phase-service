package com.projectdetails.service.impl;

import com.projectdetails.dto.ProjectPhaseDetailRequest;
import com.projectdetails.dto.ProjectPhaseDetailResponse;
import com.projectdetails.model.ProjectPhaseDetailModel;
import com.projectdetails.repository.ProjectPhaseDetailRepo;
import com.projectdetails.service.ProjectPhaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProjectPhaseDetailImpl implements ProjectPhaseDetailService {

    @Autowired
    ProjectPhaseDetailRepo projectPhaseDetailRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public ProjectPhaseDetailResponse fetchAllPhaseDetailByProjectId(String projectId) {
        ProjectPhaseDetailResponse projectPhaseDetailResponse = new ProjectPhaseDetailResponse();
        List<ProjectPhaseDetailModel> lstAllPhaseDetail = null;
        try {
           Query query=new Query();
           query.addCriteria(Criteria.where("projectId").is(projectId));
            lstAllPhaseDetail=mongoTemplate.find(query,ProjectPhaseDetailModel.class);
            if (lstAllPhaseDetail.size() == 0) {
                projectPhaseDetailResponse.setMessage("No Record found");
                projectPhaseDetailResponse.setStatusCode("200");
            } else {
                projectPhaseDetailResponse.setData(lstAllPhaseDetail);
                projectPhaseDetailResponse.setMessage("Success");
                projectPhaseDetailResponse.setStatusCode("200");
            }

        } catch (Exception ex) {
            projectPhaseDetailResponse.setMessage("Exception" + ex.getMessage());
            projectPhaseDetailResponse.setStatusCode("200");
        }

        return projectPhaseDetailResponse;
    }

    @Override
    public ProjectPhaseDetailResponse SaveProjectPhaseDetail(ProjectPhaseDetailRequest projectPhaseDetailRequest) {
        ProjectPhaseDetailResponse projectPhaseDetailResponse = new ProjectPhaseDetailResponse();

        try {
            ProjectPhaseDetailModel projectPhaseDetailModel = new ProjectPhaseDetailModel();
            projectPhaseDetailModel.setProjectId(projectPhaseDetailRequest.getProjectId());
            projectPhaseDetailModel.setProjectPhaseDescription(projectPhaseDetailRequest.getProjectPhaseDescription());
            projectPhaseDetailModel.setDeliverables(projectPhaseDetailRequest.getDeliverables());
            System.out.println("projectPhaseDetailModel" + projectPhaseDetailModel);
            projectPhaseDetailRepo.save(projectPhaseDetailModel);
            projectPhaseDetailResponse.setMessage("Success");
            projectPhaseDetailResponse.setStatusCode("200");

        } catch (Exception ex) {
            projectPhaseDetailResponse.setMessage("Exception" + ex.getMessage());
            projectPhaseDetailResponse.setStatusCode("200");
        }
        System.out.println("projectPhaseDetailResponse"+projectPhaseDetailResponse);
        return projectPhaseDetailResponse;

    }
}
