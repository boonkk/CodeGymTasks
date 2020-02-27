package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.view.View;
import com.codegym.task.task28.task2810.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider... providers) throws IllegalArgumentException {
        if(providers == null || view == null || providers.length==0)
            throw new IllegalArgumentException("Illegal args");
        this.view = view;
        this.providers = providers;
    }


    public void selectCity(String city) {
        List<JobPosting> jobPostingList = new ArrayList<>();
        for(Provider provider : providers) {
            jobPostingList.addAll(provider.getJavaJobPostings(city));
        }
        view.update(jobPostingList);

    }
}
