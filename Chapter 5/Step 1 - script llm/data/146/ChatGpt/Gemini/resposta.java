import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.ClusterEvent.MemberEvent;
import akka.cluster.ClusterEvent.MemberRemoved;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.ClusterEvent.UnreachableMember;
import akka.cluster.Member;
import akka.cluster.MemberStatus;

public class ClusterApp {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ClusterSystem");

        // Create an actor that will join the cluster
        system.actorOf(Props.create(ClusterActor.class), "clusterActor");

        // Join the cluster
        Cluster.get(system).registerOnMemberUp(() -> System.out.println("Cluster member is up!"));

        // Listen for cluster membership events
        Cluster.get(system).subscribe(system.actorOf(Props.create(ClusterListener.class)),
                ClusterEvent.initialStateAsEvents(), MemberEvent.class, UnreachableMember.class);

        // Wait for termination
        system.awaitTermination();
    }

    public static class ClusterActor extends AbstractActor {
        @Override
        public Receive createReceive() {
            return receiveBuilder().matchAny(System.out::println).build();
        }
    }

    public static class ClusterListener extends AbstractActor {
        private static final String MEMBER_PREFIX = "Member ";

        @Override
        public Receive createReceive() {
            return receiveBuilder().match(MemberUp.class, memberUp -> {
                Member member = memberUp.member();
                if (member.status().equals(MemberStatus.up())) {
                    System.out.println(MEMBER_PREFIX + member.address() + " is up!");
                }
            }).match(UnreachableMember.class, unreachableMember -> {
                Member member = unreachableMember.member();
                System.out.println(MEMBER_PREFIX + member.address() + " is unreachable!");
            }).match(MemberRemoved.class, memberRemoved -> {
                Member member = memberRemoved.member();
                System.out.println(MEMBER_PREFIX + member.address() + " is removed!");
            }).build();
        }
    }
}
