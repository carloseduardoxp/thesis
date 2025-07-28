import akka.actor.ActorSystem;
import akka.actor.AbstractActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.ClusterEvent.MemberUp;

public class ClusterApp {

    static class SimpleActor extends AbstractActor {
        private final Cluster cluster = Cluster.get(getContext().getSystem());

        // Registrar para eventos do cluster
        @Override
        public void preStart() {
            cluster.subscribe(getSelf(), ClusterEvent.initialStateAsEvents(),
                    MemberUp.class);
        }

        @Override
        public void postStop() {
            cluster.unsubscribe(getSelf());
        }

        @Override
        public Receive createReceive() {
            return receiveBuilder()
                .match(MemberUp.class, mUp -> 
                    System.out.println("Novo membro UP: " + mUp.member())
                )
                .build();
        }
    }

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ClusterSystem");
        system.actorOf(SimpleActor.props(), "simpleActor");
    }
}