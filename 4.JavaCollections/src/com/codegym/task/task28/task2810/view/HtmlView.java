package com.codegym.task.task28.task2810.view;

import com.codegym.task.task28.task2810.Controller;
import com.codegym.task.task28.task2810.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/jobPostings.html";
    private Controller controller;
    @Override
    public void update(List<JobPosting> jobPostings) {
        updateFile(getUpdatedFileContents(jobPostings));
    }

    private String getUpdatedFileContents(List<JobPosting> postings){
        Document document = null;
        try {
            document = getDocument();

            Element templateOriginal = document.getElementsByClass("template").first();
            Element copyTemplate = templateOriginal.clone();
            copyTemplate.removeAttr("style");
            copyTemplate.removeClass("template");
            document.select("tr[class=vacancy]").remove();

            for (JobPosting jobPosting : postings) {
                Element localClone = copyTemplate.clone();
                localClone.getElementsByClass("city").first().text(jobPosting.getCity());
                localClone.getElementsByClass("companyName").first().text(jobPosting.getCompanyName());
                Element link = localClone.getElementsByTag("a").first();
                link.text(jobPosting.getTitle());
                link.attr("href", jobPosting.getUrl());

                templateOriginal.before(localClone.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return document.html();}


    private void updateFile(String content){
        try (FileWriter fileWriter = new FileWriter(new File(filePath))) {
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void emulateCitySelection() {
        controller.onCitySelected("Odessa");
    }
}
