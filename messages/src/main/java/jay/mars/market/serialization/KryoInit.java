package jay.mars.market.serialization;

import com.esotericsoftware.kryo.Kryo;
import jay.mars.market.messages.CreateSequences;
import jay.mars.market.messages.DropSequence;
import jay.mars.market.messages.ListSequences;
import jay.mars.market.messages.NextValue;

public class KryoInit {
    public void customize(Kryo kryo) {
        kryo.register(CreateSequences.class);
        kryo.register(DropSequence.class);
        kryo.register(ListSequences.class);
        kryo.register(NextValue.class);
    }
}