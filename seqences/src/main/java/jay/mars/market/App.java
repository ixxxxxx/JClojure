package jay.mars.market;

import akka.actor.AbstractActor;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

public class App extends AbstractActor {
    private LoggingAdapter log = Logging.getLogger(this.context().system(), this.getClass());

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(Long.class, msg -> {
            log.info("received long: {}", msg);
        }).build();
    }

    public static void main(String[] args) {
        ActorSystem seqSys = ActorSystem.create("sequences");
        ActorSystem appSys = ActorSystem.create("app");
        var seqRef = seqSys.actorOf(SequencesActor.props(), "sequences");
        var mineRef = appSys.actorOf(Props.create(App.class), "ask");
        while (true) {
            seqRef.tell("next", mineRef);
            try { 
                Thread.sleep(1000); 
                } catch (InterruptedException e) { 
                    System.out.println("Thread sleep exception e="+e.getMessage());
                    e.printStackTrace(); 
            }
        }
    }
}