public class DeepSeek {
    @Value("${my.array.property}")
    private String[] myArray;

    // Or if you need to specify a custom delimiter
    @Value("#{'${my.array.property}'.split(',')}")
    private List<String> myList;

}

