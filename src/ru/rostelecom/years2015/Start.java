package ru.rostelecom.years2015;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Olcha on 02.11.2015.
 */
public class Start {
    public static void main(String[] args){
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        System.out.println(year);
        Document xml = DocumentHelper.createDocument();
        Element root = xml.addElement("soap:Envelope").
                addNamespace("soap", "http://schemas.xmlsoap.org/soap/envelope/").
                addNamespace("actor", "http://smev.gosuslugi.ru/actors/smev").
                addNamespace("wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd").
                addNamespace("ds", "http://www.w3.org/2000/09/xmldsig#")
                .addNamespace("atc", "http://at-sibir.ru/getDictionary")
                .addNamespace("smev", "http://smev.gosuslugi.ru/rev120315");
        Header head = new Header();
        head.generateHeader(root);
                Element body = root.addElement("soap:Body")
                    .addAttribute("wsu:Id", "body")
                    .addAttribute("xmlns:wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
                    Element getDictionary = body.addElement("atc:getDictionary");
                            Message message = new Message();
                            message.generateMessage(getDictionary);
                            MessageData messageData = new MessageData();
                            messageData.generateMessageData(getDictionary);
        System.out.println(root.asXML());
    }
}
