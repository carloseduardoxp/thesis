public class RemoveNumbers {
    public static void main(String[] args) {
        String originalString = "Hello123World456Java789";
        String stringWithoutNumbers = originalString.replaceAll("[0-9]", "");
        System.out.println("Original String: " + originalString);
        System.out.println("String without numbers: " + stringWithoutNumbers);

        String anotherString = "123TestString456with789numbers";
        String anotherStringWithoutNumbers = anotherString.replaceAll("[0-9]", "");
        System.out.println("Original String: " + anotherString);
        System.out.println("String without numbers: " + anotherStringWithoutNumbers);
    }
}
