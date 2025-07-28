public class Teste {

    
    public static void main(String[] args) {
        String html = "<html><body><h1> Hello, World! </h1></body></html>";
        Document doc = Jsoup.parse(html);
        String text = doc.body().text();
        System.out.println(text);
    }
    
}