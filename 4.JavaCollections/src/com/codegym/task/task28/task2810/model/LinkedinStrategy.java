package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.vo.JobPosting;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkedinStrategy implements Strategy {
    private static final String URL_FORMAT = "https://www.linkedin.com/jobs/search?keywords=Java+%s&start=%d";
    String s = String.format(URL_FORMAT, "San+Francisco", 75);
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36 OPR/66.0.3515.103";
    String referrer = "no-referrer-when-downgrade";

    String cachedLinkedinPage = "http://codegym.cc/testdata/big28data.html";

    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        return Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                .timeout(5000)
                .referrer("http://google.pl")
                .get();
    }
    @Override
    public List<JobPosting> getJobPostings(String searchString) {
        List<JobPosting> list = new ArrayList<>();
        try {
            int i = 0;
            while (true) {
                Document document = getDocument(searchString, i);
                if (!document.getElementsByClass("jobs-search-result-item").isEmpty()) {
                    for (Element e : document.getElementsByClass("jobs-search-result-item")) {
                        JobPosting job = new JobPosting();
                        job.setTitle(e.getElementsByClass("listed-job-posting__title").text());
                        job.setCity(e.getElementsByClass("listed-job-posting__location").text());
                        job.setCompanyName(e.getElementsByClass("listed-job-posting__company").text());
                        job.setWebsiteName(URL_FORMAT);
                        Element link = e.select("meta[itemprop=url]").first();
                        job.setUrl(link.attr("content"));
                        if(!list.contains(job))
                            list.add(job);
                    }
                    i++;
                }
                else break;
            }
        }
        catch (IOException ignored){}

        return list;
    }
}
