public class Teste {
  public static void main(String[] args) {
    Document doc = Jsoup.parse(htmlString);

    Elements links = doc.select("a[href]");
    for (Element link : links) {
        String href = link.attr("href");
        System.out.println(href);
    }


  }
}
