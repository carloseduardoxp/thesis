
public class Teste {

    public static void main(String[] args) {
        System.out.println(extractFirstBlock("{\"payday\":{\"fae\":\"boo\",\"ipsum\":[\"lom\",\"lorem\"]},\"signature\":\"somehmacsign\"},{\"payload\":{\"foo\":\"bar\",\"ipsum\":[\"lorem\",\"lorem\"]},\"signature\":\"somehmacsign\"}", "payload"));
    }

    public static String extractFirstBlock(String s, String key) {
        int length = s.length() - 1;
        int start = -1;
        int i = s.indexOf(key); //This should be done by reading characters one by one to check if this is a key or a value.

        if (i == -1) {
            return null;
        }

        i += key.length();

        int cntOpen = 0;
        while (i < length) {
            char c = s.charAt(i);
            if (c == '{') { //Need to check for character into String value too
                if (cntOpen++ == 0) {
                    start = i;
                }
            } else if (c == '}') {
                if (--cntOpen == 0) {
                    return s.substring(start, i + 1);
                }
            }
            ++i;
        }
        return null;
    }

}
