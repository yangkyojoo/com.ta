import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class toXml {

    public void toXml() throws ParserConfigurationException, TransformerException {
        // XML 문서 파싱
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        // 새로운 XML 생성! //
        // 새로운 Document 객체 생성
        Document document = documentBuilder.newDocument();

        // root 생성
        Element root = document.createElement("class");
        // root 속성 설정
        root.setAttribute("name", "how to use xml parser");

        // 자식 노드 생성
        Element teacher = document.createElement("teacher");
        teacher.setAttribute("name", "t1");
        // 텍스트 설정
        teacher.setTextContent("선생님입니다.");

        Element teacher2 = document.createElement("teacher");
        teacher2.setAttribute("name", "t2");
        // 텍스트 설정
        teacher2.setTextContent("선생님입니다.");

        Element teacher3 = document.createElement("teacher");
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
}
