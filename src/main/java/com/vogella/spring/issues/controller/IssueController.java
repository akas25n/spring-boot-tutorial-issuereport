package com.vogella.spring.issues.controller;

import com.vogella.spring.issues.entities.IssueReport;
import com.vogella.spring.issues.repositories.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IssueController {

    IssueRepository issueRepository;

    public IssueController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @GetMapping("/issuereport")
    public String getReport(Model model, @RequestParam(name = "submitted", required = false) boolean submitted){
        model.addAttribute("submitted", submitted);
        model.addAttribute("issueReport", new IssueReport());
        return "issues/issueReport_form";
    }

    @PostMapping("/issuereport")
    public String submitForm(IssueReport issueReport, RedirectAttributes redirectAttributes){
        this.issueRepository.save(issueReport);
        redirectAttributes.addAttribute("submitted", true);
        return "redirect:/issuereport";
    }

    @GetMapping("/issues")
    public String getIssues(Model model){
        //markedAsPrivate = false
        model.addAttribute("issues", issueRepository.findAllByMarkedAsPrivate());
        return "issues/issuereport_list";
    }
}
