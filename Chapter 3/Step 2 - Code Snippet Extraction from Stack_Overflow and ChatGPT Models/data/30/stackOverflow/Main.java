

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"MovieCount\": 153,\"MoviesList\": [{},{}]}";
        try {
            List<Movie> movies = ((MovieWrapper) mapper.readValue(json, MovieWrapper.class)).moviesList;
            System.out.println(movies.size());
        }
        catch (Throwable t) {
            t.printStackTrace();
        }

    }

    static class MovieWrapper {

        @JsonProperty(value = "MovieCount")
        int movieCount;
        @JsonProperty(value = "MoviesList")
        List<Movie> moviesList;
    }

    static class Movie {

    }

}