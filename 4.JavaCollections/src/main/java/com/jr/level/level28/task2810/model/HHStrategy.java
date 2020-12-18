package com.jr.level.level28.task2810.model;

import com.jr.level.level28.task2810.vo.Vacancy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import static java.lang.String.format;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String userAgent = "Chrome/87.0.4280.66";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int counter = 0;
            Document document;
            Elements elements;
            do{
                document = getDocument(searchString, counter++);
                elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                for (Element element : elements) {
                    vacancies.add(getVacancy(element));
                }
            } while(elements.size() > 0);
        } catch (IOException ignore) {}

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws  IOException {
        Document document = null;
        String request = format(URL_FORMAT, searchString, page);
        document = Jsoup.connect(request)
                    .userAgent(userAgent).referrer("").get();

        return document;
    }

    private Vacancy getVacancy(Element element){
        Vacancy vacancy = new Vacancy();
        vacancy.setTitle(element.getElementsByAttributeValueEnding("data-qa", "-title").text());
        vacancy.setUrl(element.getElementsByAttributeValueEnding("data-qa", "-title").attr("href"));
        vacancy.setSalary(element.getElementsByAttributeValueEnding("data-qa", "-compensation").text());
        vacancy.setCity(element.getElementsByAttributeValueEnding("data-qa", "-address").text());
        vacancy.setCompanyName(element.getElementsByAttributeValueEnding("data-qa", "-employer").text());
        vacancy.setSiteName("http://hh.ua");
        return vacancy;
    }
}
