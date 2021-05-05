package MPx;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.*;

public abstract class ObjectPlusPlus extends ObjectPlus implements Serializable {
    private final Map<String, Map<Object, ObjectPlusPlus>> links = new Hashtable<>();
    private static final Set<ObjectPlusPlus> allParts = new HashSet<>();

    public ObjectPlusPlus() {
        super();
    }

    private void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier, int counter) {
        Map<Object, ObjectPlusPlus> objectLinks;
        if (counter < 1) {
            return;
        }
        if (links.containsKey(roleName)) {
            objectLinks = links.get(roleName);
        } else {
            objectLinks = new HashMap<>();
            links.put(roleName, objectLinks);
        }
        if (!objectLinks.containsKey(qualifier)) {
            objectLinks.put(qualifier, targetObject);
            targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
        }
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject, Object qualifier) {
        addLink(roleName, reverseRoleName, targetObject, qualifier, 2);
    }

    public void addLink(String roleName, String reverseRoleName, ObjectPlusPlus targetObject) {
        addLink(roleName, reverseRoleName, targetObject, targetObject);
    }

    public void addPart(String roleName, String reverseRoleName, ObjectPlusPlus partObject) throws Exception {
        if (allParts.contains(partObject)) {
            throw new Exception("The part is already connected to a whole!");
        }
        addLink(roleName, reverseRoleName, partObject);
        allParts.add(partObject);
    }

    public ObjectPlusPlus[] getLinks(String roleName) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;
        if (!links.containsKey(roleName)) {
            throw new Exception("No links for the role: " + roleName);
        }
        objectLinks = links.get(roleName);
        return (ObjectPlusPlus[]) objectLinks.values().toArray(new ObjectPlusPlus[0]);
    }

    public void showLinks(String roleName, PrintStream stream) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;
        if (!links.containsKey(roleName)) {
            throw new Exception("No links for the role: " + roleName);
        }
        objectLinks = links.get(roleName);
        Collection<ObjectPlusPlus> col = objectLinks.values();
        stream.println(this.getClass().getSimpleName() + " links, role '" + roleName + "':");
        for (Object obj : col) {
            stream.println(" " + obj);
        }
    }

    public boolean containTheRole(String roleName){
        return links.containsKey(roleName);
    }

    public ObjectPlusPlus getLinkedObject(String roleName, Object qualifier) throws Exception {
        Map<Object, ObjectPlusPlus> objectLinks;
        if (!links.containsKey(roleName)) {
            throw new Exception("No links for the role: " + roleName);
        }
        objectLinks = links.get(roleName);
        if (!objectLinks.containsKey(qualifier)) {
            throw new Exception("No link for the qualifer: " + qualifier);
        }
        return objectLinks.get(qualifier);
    }

    public void deleteObject(ObjectPlusPlus object,String role) throws Exception {
        ObjectPlusPlus[] objectLinks = null;
        try {
            objectLinks = object.getLinks(role);
        } catch (Exception ignored) {
        }
        if (objectLinks != null){
            for (var part : objectLinks
            ) {
                allParts.remove(part);
                if (role.equals(Roles.PART))part.removeObjectFromExtent();
                object.links.get(role).remove(part);
                deleteObject(part,Roles.WHOLE);
                deleteObject(part,Roles.PART);
            }
        }
//        object.removeObjectFromExtent();
    }



}
