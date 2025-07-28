
import java.util.*;
import java.util.Comparator;

public class Test {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        String[] tests = {"::2:3:4:5:6:7", "2:3:4:5:6:7", "::5:3:4:5:6:7:8", "::5:3:4:5:6:7:8:9:0", "1::8", "1::2:3", "1::2:3:4", "1::5:256.2.3.4", "1:1:3000.30.30.30", "ae80::217:f2ff:254.7.237.98", "1:2:3:4::5:1.2.3.4", "2001:0000:1234:0000:0000:C1C0:ABCD:0876", "12345::6:7:8", "1::1.2.900.4", "fe80::", "::ffff:0:0"};
        for (String test1 : tests) {
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

class AlphanumComparator implements Comparator {

    private final boolean isDigit(char ch) {
        return ch >= 48 && ch <= 57;
    }

    private final String getChunk(String s, int slength, int marker) {
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

    public int compare(Object o1, Object o2) {
        if (!(o1 instanceof String) || !(o2 instanceof String)) {
            return 0;
        }
        String s1 = (String) o1;
        String s2 = (String) o2;

        int thisMarker = 0;
        int thatMarker = 0;
        int s1Length = s1.length();
        int s2Length = s2.length();

        while (thisMarker < s1Length && thatMarker < s2Length) {
            String thisChunk = getChunk(s1, s1Length, thisMarker);
            thisMarker += thisChunk.length();

            String thatChunk = getChunk(s2, s2Length, thatMarker);
            thatMarker += thatChunk.length();

            int result = 0;
            if (isDigit(thisChunk.charAt(0)) && isDigit(thatChunk.charAt(0))) {
                int thisChunkLength = thisChunk.length();
                result = thisChunkLength - thatChunk.length();
                if (result == 0) {
                    for (int i = 0; i < thisChunkLength; i++) {
                        result = thisChunk.charAt(i) - thatChunk.charAt(i);
                        if (result != 0) {
                            return result;
                        }
                    }
                }
            } else {
                result = thisChunk.compareTo(thatChunk);
            }

            if (result != 0) {
                return result;
            }
        }

        return s1Length - s2Length;
    }
}
