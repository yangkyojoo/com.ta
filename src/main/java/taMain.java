import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import javax.swing.text.AbstractDocument;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class taMain {
    public static int cnt =0;
    public static void main(String[] args){
        try{
            Connection conn = Jsoup.connect("https://www.daum.net/");
            File input = new File("C:/Users/dad/Downloads/test.html");
            Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
            //Document doc = conn.get();
            Element eles = doc.body();


            new taMain().toXml(eles);


        }catch (Throwable e){
            e.printStackTrace();
        }
    }


    public void toXml(Element el) throws ParserConfigurationException, TransformerException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        // 새로운 XML 생성! //
        // 새로운 Document 객체 생성
        org.w3c.dom.Document document = documentBuilder.newDocument();f

        // root 생성
        org.w3c.dom.Element root = document.createElement("class");
        // root 속성 설정
        root.setAttribute("name", "how to use xml parser");



        org.w3c.dom.Element teacher2 = document.createElement("teacher");
        teacher2.setAttribute("name", "t2");
        // 텍스트 설정
        teacher2.setTextContent("선생님입니다.");

        org.w3c.dom.Element teacher3 = document.createElement("teacher");
        teacher3.setAttribute("name", "t3");
        // 텍스트 설정
        teacher3.setTextContent("선생님입니다.");

        // 자식 요소 추가
        document.appendChild(root);
        root.appendChild(teacher);
        root.appendChild(teacher2);
        root.appendChild(teacher3);

        // XML 문자열로 변환하기! //
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(out);

        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();

        // 출력 시 문자코드: UTF-8
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        // 들여 쓰기 있음
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);

        System.out.println(new String(out.toByteArray(), StandardCharsets.UTF_8));
    }

    public org.w3c.dom.Element addXmlElement(HashMap<String, Object> params)
    {
        org.w3c.dom.Element el = null;


        // 자식 노드 생성
        org.jdom.Element elName = new Element((params.get("Element").toString());

        elName.setAttribute("name", "t1");
        // 텍스트 설정
        elName.setText("선생님입니다.");

        return el;
                
    }

    public void childNode(Element el)  {

//        for(int i=0; i<el.childrenSize(); i++)
//        {
//            cnt++;
//           // org.w3c.dom.Element teacher = document.createElement(el.child(i).tagName());
//            if(el.child(i).tagName().equals("td")) {
//                // 자식 노드 생성
//
//                if (!el.child(i).attr("rowspan").isEmpty()) {
//                    teacher.setAttribute("rowspan", el.child(i).attr("rowspan"));
//                }
//                if (!el.child(i).attr("colspan").isEmpty()) {
//                    teacher.setAttribute("colspan", el.child(i).attr("colspan"));
//                }
//                // 텍스트 설정
//
//            }
//            teacher.setTextContent(el.child(i).text());
//            root.appendChild(teacher);
//
//            // childNode(el.child(i));
//            cnt--;
//        }
    }
}
