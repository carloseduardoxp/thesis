
import java.util.concurrent.CompletableFuture;

public class Teste {
  public static void main(String[] args) {
      CompletableFuture<String> futureResult = CompletableFuture.supplyAsync(() -> {
        // Perform some long-running operation
        return "result";
      });
  
     String result = futureResult.get(); // This line "awaits" the completion of the future

     CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
     CompletableFuture<Integer> future2 = future1.thenApply(x -> x * 2);
     CompletableFuture<Integer> future3 = future2.thenCompose(x -> CompletableFuture.supplyAsync(() -> x + 5));

     int result = future3.get(); // result = 25

  
  }
}
