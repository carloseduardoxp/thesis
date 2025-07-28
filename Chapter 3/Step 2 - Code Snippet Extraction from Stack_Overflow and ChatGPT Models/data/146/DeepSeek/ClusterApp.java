import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ClusterApp {
    public static void main(String[] args) {
        if (args.length == 0) {
            startup(new String[] {"2551", "2552", "0"});
        } else {
            startup(args);
        }
    }

    public static void startup(String[] ports) {
        for (String port : ports) {
            Config config = ConfigFactory.parseString(
                    "akka.remote.artery.canonical.port=" + port)
                .withFallback(ConfigFactory.load());

            ActorSystem system = ActorSystem.create("ClusterSystem", config);

            // Create an actor that handles cluster domain events
            system.actorOf(Props.create(SimpleClusterListener.class), "clusterListener");
        }
    }
}

class SimpleClusterListener extends AbstractActor {
    Cluster cluster = Cluster.get(getContext().getSystem());

    @Override
    public void preStart() {
        cluster.subscribe(getSelf(), ClusterEvent.initialStateAsEvents(),
                ClusterEvent.MemberEvent.class, ClusterEvent.UnreachableMember.class);
    }

    @Override
    public void postStop() {
        cluster.unsubscribe(getSelf());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
            .match(ClusterEvent.MemberUp.class, mUp -> {
                System.out.println("Member is Up: " + mUp.member());
            })
            .match(ClusterEvent.UnreachableMember.class, mUnreachable -> {
                System.out.println("Member detected as unreachable: " + mUnreachable.member());
            })
            .match(ClusterEvent.MemberRemoved.class, mRemoved -> {
                System.out.println("Member is Removed: " + mRemoved.member());
            })
            .match(ClusterEvent.MemberEvent.class, event -> {
                // ignore
            })
            .build();
    }
}
