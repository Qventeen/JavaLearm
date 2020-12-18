package com.jr.level.level28.task2810.view;

import com.google.common.base.Charsets;
import com.jr.level.level28.task2810.Controller;
import com.jr.level.level28.task2810.vo.Vacancy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlView implements View {
    private final String EXCEPTION_STRING = "Some exception occurred";
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/"
            + this.getClass().getPackage().getName().replaceAll("\\.", File.separator)
            + "/vacancies.html";


    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            String newContent = getUpdatedFileContent(vacancies);
            updateFile(newContent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Kiev");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){
        String result = "";
        try {
            Document document = getDocument();
            cleanDocument(document);
            Element tmp = document.getElementsByClass("template").first();
            Element template = tmp.clone();
            template.removeAttr("style");
            template.removeClass("template");

            for(Vacancy vacancy : vacancies){
                Element element = template.clone();
                element.getElementsByTag("a").first()
                        .attr("href", vacancy.getUrl())
                        .text(vacancy.getTitle());
                element.getElementsByClass("city").first()
                        .text(vacancy.getCity());
                element.getElementsByClass("companyName").first()
                        .text(vacancy.getCompanyName());
                element.getElementsByClass("salary").first()
                        .text(vacancy.getSalary());
                tmp.before(element.outerHtml());
            }
            result = document.outerHtml();
        }catch (Exception e){
            e.printStackTrace();
            return EXCEPTION_STRING;
        }
        return result;
    }

    private void updateFile(String content){
        try (FileOutputStream fos = new FileOutputStream(filePath)){
            fos.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Document getDocument() throws IOException {
        File file = new File(filePath);
        return Jsoup.parse(file, Charsets.UTF_8.name());
    }

    private void cleanDocument(Document document){
        Elements elements = document.getElementsByTag("tr");
        for(Element e : elements){
            if(e.hasClass("vacancy") && !e.hasClass("template")){
                e.remove();
            }
        }
    }

}
