public class Split {
    public static void main(String[] argv) {
        String s = "a:b";
        String[] res = s.split(":");
        System.out.println(res.length);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}
