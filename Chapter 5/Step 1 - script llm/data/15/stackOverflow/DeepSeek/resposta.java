public class Teste {

    public static void main(String[] args) {
        String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        Document doc = Jsoup.parse(html);
        doc.body().text();
    }

}
