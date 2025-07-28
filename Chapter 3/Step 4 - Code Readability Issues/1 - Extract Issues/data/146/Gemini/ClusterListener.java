import akka.actor.ActorSystem;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent.MemberEvent;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.ClusterEvent.UnreachableMember;
import akka.cluster.ClusterEvent.MemberRemoved;
import akka.cluster.ClusterEvent.ReachableMember;
import akka.actor.AbstractBehavior;
import akka.actor.Behavior;
import akka.actor.Props;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.ReceiveBuilder;
import akka.event.Logging;
import akka.event.LoggingAdapter;

// Example Actor that subscribes to cluster events
public class ClusterListener extends AbstractBehavior<MemberEvent> {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final Cluster cluster = Cluster.get(getContext().getSystem());

    private ClusterListener(ActorContext<MemberEvent> context) {
        super(context);
    }

    public static Behavior<MemberEvent> create() {
        return Behaviors.setup(ClusterListener::new);
    }

    @Override
    public Receive<MemberEvent> createReceive() {
        return newReceiveBuilder()
                .onMessage(MemberUp.class, this::onMemberUp)
                .onMessage(UnreachableMember.class, this::onUnreachableMember)
                .onMessage(MemberRemoved.class, this::onMemberRemoved)
                .onMessage(ReachableMember.class, this::onReachableMember)
                .build();
    }

    private Behavior<MemberEvent> onMemberUp(MemberUp memberUp) {
        log.info("Member is Up: {}", memberUp.member().address());
        return this;
    }

    private Behavior<MemberEvent> onUnreachableMember(UnreachableMember unreachableMember) {
        log.warning("Member is Unreachable: {}", unreachableMember.member().address());
        return this;
    }

    private Behavior<MemberEvent> onMemberRemoved(MemberRemoved memberRemoved) {
        log.info("Member is Removed: {}", memberRemoved.member().address());
        return this;
    }

    private Behavior<MemberEvent> onReachableMember(ReachableMember reachableMember) {
        log.info("Member is Reachable: {}", reachableMember.member().address());
        return this;
    }

    @Override
    public void preStart() {
        // Subscribe to cluster changes
        cluster.subscribe(getContext().getSelf(), MemberEvent.class);
    }

    @Override
    public void postStop() {
        // Unsubscribe on stop
        cluster.unsubscribe(getContext().getSelf());
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            startupClusterNodes(java.util.Arrays.asList("2551", "2552", "0")); // 0 means dynamic port
        } else {
            startupClusterNodes(java.util.Arrays.asList(args));
        }
    }

    private static void startupClusterNodes(java.util.List<String> ports) {
        System.out.printf("Starting cluster on port(s) %s%n", ports);
        ports.forEach(port -> {
            // Load configuration
            com.typesafe.config.Config config =
                    com.typesafe.config.ConfigFactory.parseString("akka.remote.artery.canonical.port=" + port)
                            .withFallback(com.typesafe.config.ConfigFactory.load());

            akka.actor.ActorSystem system = akka.actor.ActorSystem.create("MyClusterSystem", config);

            // Start the cluster listener actor
            system.actorOf(akka.actor.typed.Props.create(ClusterListener.class), "clusterListener");

            system.log().info("Akka node {} started", system.provider().getDefaultAddress());
        });
    }
}
