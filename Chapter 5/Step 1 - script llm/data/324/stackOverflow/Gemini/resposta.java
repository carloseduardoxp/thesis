import java.net.http.HttpResponse.BodyHandler;
import java.util.logging.Handler;

public class Main extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest request) {

                System.out.println(request.getParam("username"));

            }
        }).listen(8888);

        final Router router = Router.router(vertex);
// Adding a BodyHandler for routes
        router.route().handler(BodyHandler.create());
        router.post("/your/endpoint").handler(routingContext -> System.out.println(routingContext.getBodyAsString()));

    }
}
