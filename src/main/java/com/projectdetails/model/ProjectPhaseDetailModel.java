package com.projectdetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@Document(collection = "projectPhaseDetails")
@AllArgsConstructor
public class ProjectPhaseDetailModel {

    public ProjectPhaseDetailModel() {
        this.projectPhaseId = UUID.randomUUID().toString();
        this.insertedDate = new Date();
    }
    private String projectPhaseId;
    private String projectId;
    private String projectPhaseDescription;
    private List<Map<String, String>> deliverables;
    @CreatedDate
    private Date insertedDate;


}
