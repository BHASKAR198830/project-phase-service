package com.projectdetails.controller;

import com.projectdetails.dto.ProjectPhaseDetailRequest;
import com.projectdetails.dto.ProjectPhaseDetailResponse;
import com.projectdetails.model.ProjectPhaseDetailModel;
import com.projectdetails.service.ProjectPhaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projectphasedetails")
public class ProjectPhaseDetailController {

    @Autowired
    private ProjectPhaseDetailService projectPhaseDetailService;

    @GetMapping("/{projectId}")
    public ProjectPhaseDetailResponse fetchdetailsByprojectId(@PathVariable String projectId) {
        ProjectPhaseDetailResponse projectPhaseDetailResponse = projectPhaseDetailService.fetchAllPhaseDetailByProjectId(projectId);

        return projectPhaseDetailResponse;

    }
    @GetMapping("/projectid/{projectId}")
    public List<ProjectPhaseDetailModel> GetAllProjectPhaseByProjectId(@PathVariable String projectId) throws InterruptedException {
        //Thread.sleep(20000);
        ProjectPhaseDetailResponse projectPhaseDetailResponse = projectPhaseDetailService.fetchAllPhaseDetailByProjectId(projectId);

        return projectPhaseDetailResponse.getData();

    }

    @PostMapping("/SaveDetails")
    public ProjectPhaseDetailResponse SaveDetails(@RequestBody ProjectPhaseDetailRequest projectPhaseDetailRequest) {
        ProjectPhaseDetailResponse projectPhaseDetailResponse = new ProjectPhaseDetailResponse();
        System.out.println("Start");
        projectPhaseDetailResponse= projectPhaseDetailService.SaveProjectPhaseDetail(projectPhaseDetailRequest);
        System.out.println("End" + projectPhaseDetailRequest);

        return projectPhaseDetailResponse;
    }


}
