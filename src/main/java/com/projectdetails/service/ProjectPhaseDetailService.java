package com.projectdetails.service;

import com.projectdetails.dto.ProjectPhaseDetailRequest;
import com.projectdetails.dto.ProjectPhaseDetailResponse;

public interface ProjectPhaseDetailService {

    ProjectPhaseDetailResponse fetchAllPhaseDetailByProjectId(String projectId);

    ProjectPhaseDetailResponse SaveProjectPhaseDetail(ProjectPhaseDetailRequest projectPhaseDetailRequest);



}
