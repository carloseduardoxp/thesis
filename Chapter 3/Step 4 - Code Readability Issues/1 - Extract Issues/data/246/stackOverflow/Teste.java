
public class Teste {

    public static void main(String[] args) {
        JsonArrayBuilder jarr = Json.createArrayBuilder();
        for (int i = 0; i < posts[i]; i++) {
            jarr.add(Json.createObjectBuilder()
                    .add("post", posts[i])
                    .add("id", ids[i]).build());
        }
        jarr.build();
    }
}
