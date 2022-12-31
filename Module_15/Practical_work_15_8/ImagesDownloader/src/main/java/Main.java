import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "https://skillbox.ru/";
        Document doc = Jsoup.connect(url).get();
    }
}
