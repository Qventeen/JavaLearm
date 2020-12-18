package com.jr.level.level33.task3309;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* 
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        //Построить документ из переданного объекта
        Document document = getDomFromObject(obj);

        //Дополнить документ необходимым комментарием
        updateDocument(document, tagName, comment);

        //Трансформировать документ в строку
        String result = transformDocumentToString(document);

        return result;
    }

    private static Document getDomFromObject(Object object){
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
            df.setCoalescing(true);
            DocumentBuilder db = df.newDocumentBuilder();
            Document doc = db.newDocument();

            marshaller.marshal(object,doc);

            return doc;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void updateDocument(Document document, String tagName, String commentString){
        //Получить теги по имени
        NodeList list = document.getElementsByTagName(tagName);
        for(int i = 0; i < list.getLength(); i++){
            Node node = list.item(i);

            //Дополнить теги комментарием
            Comment comment = document.createComment(commentString);
            node.getParentNode().insertBefore(comment, node);
        }
    }

    private static String transformDocumentToString(Document document){
        StringWriter sw = new StringWriter();
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");

            transformer.transform(
                    new DOMSource(document),
                    new StreamResult(sw));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    public static void main(String[] args) {

    }

}
