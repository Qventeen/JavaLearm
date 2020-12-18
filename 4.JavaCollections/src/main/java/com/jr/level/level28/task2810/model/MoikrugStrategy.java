package com.jr.level.level28.task2810.model;

import com.jr.level.level28.task2810.vo.Vacancy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MoikrugStrategy implements Strategy {
    private final String SITE_NAME = "https://moikrug.ru";
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36";
    private final String REFERRED = SITE_NAME;



    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            Document document;
            Elements elements;
            int page = 0;
            do {
                document = getDocument(searchString, page++);
                elements = document.getElementsByClass("job");
                for (Element element : elements) {
                    vacancies.add(getVacancy(element));
                }
            }while (elements.size() > 0);
        } catch (IOException ignore) {}

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent(USER_AGENT).referrer(REFERRED).get();
    }

    private Vacancy getVacancy(Element element){
        Vacancy vacancy = new Vacancy();
        Elements title = element.getElementsByClass("title");
        Elements url = title.first().getElementsByAttribute("href");
        Elements company = element.getElementsByClass("company_name");
        Elements city = element.getElementsByClass("location");
        Elements salary = element.getElementsByClass("count");


        vacancy.setTitle(title.attr("title"));
        vacancy.setUrl(SITE_NAME + url.attr("href"));
        vacancy.setCompanyName(company.first().text());

        vacancy.setCity(city.size() > 0? city.first().text(): "");
        vacancy.setSalary(salary.size() > 0? salary.first().text(): "");
        vacancy.setSiteName(SITE_NAME);

        return vacancy;
    }

}
