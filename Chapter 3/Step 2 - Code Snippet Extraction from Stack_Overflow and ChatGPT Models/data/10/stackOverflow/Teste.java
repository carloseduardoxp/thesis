public class Teste {

    @Value("#{'${property.values}'.split(',')}") 
    List<String> eachLineOfPropertyFile;


}