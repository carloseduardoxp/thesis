public class Teste {

    String ssort(String s) {
        if (s.length() < 2) {
            return s;
        }

        int pos = 0;
        char min = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < min) {
                min = c;
                pos = i;
            }
        }

        System.out.printf("%c | %s%n", min, s.substring(0, pos) + s.substring(pos + 1));

        return min + ssort(s.substring(0, pos) + s.substring(pos + 1));
    }
}