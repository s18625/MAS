package MPx;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ObjectPlus implements Serializable {
    private static Map<Class<?>, List<? extends ObjectPlus>> allExtents = new HashMap<>();

    public ObjectPlus() {
        List<ObjectPlus> extent = null;
        Class<? extends ObjectPlus> theClass = this.getClass();

        if (allExtents.containsKey(theClass)) {
            extent = (List<ObjectPlus>) allExtents.get(theClass);
        } else {
            extent = new ArrayList<>();
            allExtents.put(theClass, extent);
        }
        extent.add(this);
    }

    public static void writeExtents(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeObject(allExtents);
    }

    public static void readExtents(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        allExtents = (Map<Class<?>, List<? extends ObjectPlus>>) inputStream.readObject();
    }

    public static <T> List<T> getExtentOfClass(Class<T> type) throws ClassNotFoundException {
        if (allExtents.containsKey(type)) {
            return (List<T>) allExtents.get(type);
        }
        throw new ClassNotFoundException(
                String.format("class %s not found", type.toString())
        );
    }

}
