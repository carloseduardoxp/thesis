import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String[] tests = {"::2:3:4:5:6:7", "2:3:4:5:6:7", "::5:3:4:5:6:7:8", "::5:3:4:5:6:7:8:9:0", "1::8", "1::2:3", "1::2:3:4", "1::5:256.2.3.4", "1:1:3000.30.30.30", "ae80::217:f2ff:254.7.237.98", "1:2:3:4::5:1.2.3.4", "2001:0000:1234:0000:0000:C1C0:ABCD:0876", "12345::6:7:8", "1::1.2.900.4", "fe80::", "::ffff:0:0"};
        Collections.addAll(list, tests);

        System.out.println();
        System.out.println("Ascending Order");

        list.sort(new AlphanumComparator());
        for (String ip : list) {
            System.out.println(ip);
        }

        System.out.println();
        System.out.println("Descending Order");

        Collections.reverse(list);
        for (String ip : list) {
            System.out.println(ip);
        }
    }
}

class AlphanumComparator implements Comparator<String> {

    private boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private String getChunk(String s, int marker) {
        int end = marker + 1;
        boolean isNumeric = isDigit(s.charAt(marker));
        while (end < s.length() && isDigit(s.charAt(end)) == isNumeric) {
            end++;
        }
        return s.substring(marker, end);
    }

    @Override
    public int compare(String s1, String s2) {
        int thisMarker = 0;
        int thatMarker = 0;

        while (thisMarker < s1.length() && thatMarker < s2.length()) {
            String thisChunk = getChunk(s1, thisMarker);
            thisMarker += thisChunk.length();

            String thatChunk = getChunk(s2, thatMarker);
            thatMarker += thatChunk.length();

            // If both chunks are numeric, compare by length first.
            if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0))) {
                int lenDiff = thisChunk.length() - thatChunk.length();
                if (lenDiff != 0) {
                    return lenDiff;
                }
            }

            // For non-numeric chunks or numeric chunks of the same length,
            // a standard lexicographical comparison is sufficient.
            int result = thisChunk.compareTo(thatChunk);
            if (result != 0) {
                return result;
            }
        }

        return s1.length() - s2.length();
    }
}
