public class Teste {

    public static void main(String[] args) {        
        MockNeat m = MockNeat.threadLocal();
        final Path path = Paths.get("cc.txt");
    
        // Write in a file 1000 credit cards AMEX and Mastercard:
        m.creditCards()
                    .types(MASTERCARD, AMERICAN_EXPRESS)
                    .list(1000)
                    .consume(list -> {
                        try { Files.write(path, list, CREATE, WRITE); }
                        catch (IOException e) { e.printStackTrace(); }
                    });
    }
}