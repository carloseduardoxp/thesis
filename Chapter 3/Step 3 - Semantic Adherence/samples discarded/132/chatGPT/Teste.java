public class Teste {
  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5};

    for (int i = 0; i < numbers.length; i++) {
        System.out.println(numbers[i]);
    }

    int[] numbers1 = {1, 2, 3, 4, 5};

    for (int num : numbers1) {
        System.out.println(num);
    }

  }
}
