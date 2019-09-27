package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller

@RequestMapping(value = "search")

public class SearchController {


    @RequestMapping(value = "")

    public String search(Model model) {

        model.addAttribute("columns", ListController.columnChoices);

        return "search";

    }

    @RequestMapping(value = "results")

    public String searching(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {

        if (searchType.equals("all")) {

            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);

            model.addAttribute("jobs", jobs);

            model.addAttribute("columns", ListController.columnChoices);

            return "search";

        } else {

            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchType, searchTerm);

            model.addAttribute("columns", ListController.columnChoices);

            model.addAttribute("jobs", jobs);

            return "search";



        }



    }