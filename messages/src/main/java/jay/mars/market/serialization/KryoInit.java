package jay.mars.market.serialization;

import clojure.lang.*;
import com.esotericsoftware.kryo.Kryo;
import com.fasterxml.jackson.databind.node.*;
import jay.mars.market.messages.CreateSequences;
import jay.mars.market.messages.DropSequence;
import jay.mars.market.messages.ListSequences;
import jay.mars.market.messages.NextValue;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class KryoInit {
    public void customize(Kryo kryo) {
        kryo.register(CreateSequences.class);
        kryo.register(DropSequence.class);
        kryo.register(ListSequences.class);
        kryo.register(NextValue.class);
        kryo.register(ObjectNode.class);
        kryo.register(ArrayNode.class);
        kryo.register(LongNode.class);
        kryo.register(TextNode.class);
        kryo.register(ArrayList.class);
        kryo.register(LinkedHashMap.class);
        kryo.register(JsonNodeFactory.class);
        kryo.register(PersistentArrayMap.class);
        kryo.register(PersistentVector.class);
        kryo.register(PersistentList.class);
        kryo.register(Keyword.class);
        kryo.register(Symbol.class);
        kryo.register(LazySeq.class);
    }
}