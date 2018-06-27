import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DocumentHelper {
    public Document getDocumentFromUrl(String url){
        Document document = null;

        try {
            document = Jsoup.connect(url).validateTLSCertificates(false).get();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return document;
    }
}
