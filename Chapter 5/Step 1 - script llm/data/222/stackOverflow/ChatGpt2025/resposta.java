public class Teste {

    @Test
    public void sampleTest(){
        int i = 5;
        incrementBy100(i);
        System.out.println("passed ==> "+ i);
        Integer j = 5;
        incrementBy100(j);
        System.out.println("passed ==> "+ j);
    }
    /**
     * @param i
     */
    private void incrementBy100(int i) {
        i += 100;
        System.out.println("incremented = "+ i);
    }
}