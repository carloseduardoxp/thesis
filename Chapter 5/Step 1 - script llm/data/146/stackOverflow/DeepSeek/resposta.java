import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.Member;
import akka.cluster.MemberStatus;

public class ClusterApp {

    public static void main(String[] args) {
        Cluster cluster = Cluster.get(context().system());
        SortedSet<Member> members = cluster.state().members();
        members.filter(__.status == MemberStatus.up());
    }
}