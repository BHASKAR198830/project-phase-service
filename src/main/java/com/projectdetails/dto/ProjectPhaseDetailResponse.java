package com.projectdetails.dto;

import com.projectdetails.model.ProjectPhaseDetailModel;
import lombok.Data;

import java.util.List;

@Data
public class ProjectPhaseDetailResponse {
    private String message;
    private String statusCode;
    private List<ProjectPhaseDetailModel> data;
}
