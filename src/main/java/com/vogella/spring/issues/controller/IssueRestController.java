package com.vogella.spring.issues.controller;

import com.vogella.spring.issues.entities.IssueReport;
import com.vogella.spring.issues.repositories.IssueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issues")
public class IssueRestController {

    IssueRepository issueRepository;

    public IssueRestController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @GetMapping
    public List<IssueReport> getAllIssues(){
        return issueRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueReport> getIssue(@PathVariable("id") Optional<IssueReport> issueReportOptional){
        return issueReportOptional
                .map(issueReport ->
                        new ResponseEntity<>(issueReport, HttpStatus.OK))
                .orElseGet(() ->
                        new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
