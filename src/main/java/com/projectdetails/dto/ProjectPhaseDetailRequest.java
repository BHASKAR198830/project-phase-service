package com.projectdetails.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ProjectPhaseDetailRequest {
    private String projectId;
    private String projectPhaseDescription;
    private List<Map<String, String>> deliverables;
}
