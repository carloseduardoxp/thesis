import java.util.concurrent.CompletableFuture;

public class Teste {
  public static void main(String[] args) throws Exception {
      CompletableFuture<String> futureResult = CompletableFuture.supplyAsync(() -> "result");
      futureResult.get();

      CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
      CompletableFuture<Integer> future2 = future1.thenApply(x -> x * 2);
      CompletableFuture<Integer> future3 = future2.thenCompose(x -> CompletableFuture.supplyAsync(() -> x + 5));

      future3.get();
  }
}