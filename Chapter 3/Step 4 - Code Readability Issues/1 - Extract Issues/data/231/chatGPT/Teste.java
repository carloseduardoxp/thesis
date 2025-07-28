

public class Teste {
  public static void main(String[] args) {
    // Create the source array
    int[] source = {1, 2, 3, 4, 5};

    // Create the destination array
    int[] destination = new int[source.length];

    // Copy the elements of the source array to the destination array
    System.arraycopy(source, 0, destination, 0, source.length);


  }
}
