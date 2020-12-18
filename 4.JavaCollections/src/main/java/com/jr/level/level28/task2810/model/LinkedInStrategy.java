package com.jr.level.level28.task2810.model;

import com.jr.level.level28.task2810.vo.Vacancy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LinkedInStrategy implements Strategy {
    private final String USER_FORMAT = "https://www.linkedin.com/jobs/search/?keywords=java junior&location=%s&start=%d";
    private final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36";
    private final String SITE_NAME = "https://www.linkedin.com/jobs/";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int start = 0;
            Document document;
            Elements elements;
            do {
                document = getDocument(searchString, start);
                elements = document.getElementsByClass("jobs-search__results-list").first().children();

                start += elements.size();
                for(Element element : elements){
                    vacancies.add(getVacancy(element));
                }
            }while(elements.size() > 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vacancies;
    }

    private Vacancy getVacancy(Element element){
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle(element.getElementsByClass("job-result-card__title").text());
        vacancy.setUrl(element.getElementsByClass("result-card__full-card-link").attr("href"));
        vacancy.setCity(element.getElementsByClass("job-result-card__location").text());
        vacancy.setCompanyName(element.getElementsByClass("job-result-card__subtitle").text());
        vacancy.setSalary("");
        vacancy.setSiteName(SITE_NAME);
        return vacancy;
    }

    public Document getDocument(String searchString, int start) throws IOException {
        String query = String.format(USER_FORMAT, searchString, start);
        return Jsoup.connect(query).userAgent(USER_AGENT).referrer("").get();
    }

}
