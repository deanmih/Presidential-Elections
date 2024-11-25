package com.example.Presidential.Elections;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidateController {

    public static class CandidateRequest {
        private String name;

        // Getter and setter for 'name'
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @PostMapping("/becomeCandidate")
    public void updateCompetes(@RequestBody CandidateRequest candidateRequest) {
        System.out.println("Candidate name: " + candidateRequest.getName());
    }
}