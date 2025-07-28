public class Teste {
  public static void main(String[] args) {
    // Create a RestTemplate object
    RestTemplate restTemplate = new RestTemplate();

    // Create a request object with the data to be sent
    String url = "https://jsonplaceholder.typicode.com/posts";
    Post post = new Post(1, "Title", "Body");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Post> request = new HttpEntity<>(post, headers);

    // Make a POST request
    String response = restTemplate.postForObject(url, request, String.class);

    // Print the response
    System.out.println(response);

 
  }
}
