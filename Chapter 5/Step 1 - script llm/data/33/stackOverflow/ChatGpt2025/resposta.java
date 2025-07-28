import java.util.*;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        String[] tests = {
            "::2:3:4:5:6:7", "2:3:4:5:6:7", "::5:3:4:5:6:7:8", "::5:3:4:5:6:7:8:9:0",
            "1::8", "1::2:3", "1::2:3:4", "1::5:256.2.3.4", "1:1:3000.30.30.30",
            "ae80::217:f2ff:254.7.237.98", "1:2:3:4::5:1.2.3.4", "2001:0000:1234:0000:0000:C1C0:ABCD:0876",
            "12345::6:7:8", "1::1.2.900.4", "fe80::", "::ffff:0:0"
        };
        // S3012: Use Arrays.copyOf (not really needed here, but for demonstration)
        String[] testsCopy = Arrays.copyOf(tests, tests.length);
        for (String test1 : testsCopy) {
            list.add(test1);
        }

        System.out.println();
        System.out.println("Ascending Order");

        Collections.sort(list, new AlphanumComparator());
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

// S3740: Provide the parametrized type for this generic.
class AlphanumComparator implements Comparator<String> {

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private String getChunk(String s, int slength, int marker) {
        StringBuilder chunk = new StringBuilder();
        char c = s.charAt(marker);
        chunk.append(c);
        marker++;
        if (isDigit(c)) {
            while (marker < slength) {
                c = s.charAt(marker);
                if (!isDigit(c)) {
                    break;
                }
                chunk.append(c);
                marker++;
            }
        } else {
            while (marker < slength) {
                c = s.charAt(marker);
                if (isDigit(c)) {
                    break;
                }
                chunk.append(c);
                marker++;
            }
        }
        return chunk.toString();
    }

    // S3776: Refactor this method to reduce its Cognitive Complexity
    @Override
    public int compare(String s1, String s2) {
        int thisMarker = 0;
        int thatMarker = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();

        while (thisMarker < s1Length && thatMarker < s2Length) {
            String thisChunk = getChunk(s1, s1Length, thisMarker);
            thisMarker += thisChunk.length();

            String thatChunk = getChunk(s2, s2Length, thatMarker);
            thatMarker += thatChunk.length();

            int result = compareChunks(thisChunk, thatChunk);
            if (result != 0) {
                return result;
            }
        }

        return s1Length - s2Length;
    }

    private int compareChunks(String thisChunk, String thatChunk) {
        boolean thisChunkIsDigit = isDigit(thisChunk.charAt(0));
        boolean thatChunkIsDigit = isDigit(thatChunk.charAt(0));

        if (thisChunkIsDigit && thatChunkIsDigit) {
            int result = thisChunk.length() - thatChunk.length();
            if (result != 0) {
                return result;
            }
            for (int i = 0; i < thisChunk.length(); i++) {
                result = thisChunk.charAt(i) - thatChunk.charAt(i);
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        } else {
            return thisChunk.compareTo(thatChunk);
        }
    }
}
