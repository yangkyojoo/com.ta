import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.Arrays;

public class taMain {
    public static int cnt =0;
    public static void main(String[] args){
        try{
            Connection conn = Jsoup.connect("https://www.daum.net/");
            Document doc = conn.get();
            Element eles = doc.body();
            new taMain().childNode(eles);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    public void childNode(Element el){

        for(int i=0; i<el.childrenSize(); i++)
        {
            cnt++;

            if(Arrays.asList("a","span").contains(el.child(i).tagName()))
                System.out.println(Integer.toString(cnt)+" : "+el.child(i).tagName());
            childNode(el.child(i));
            cnt--;
        }

    }
}
