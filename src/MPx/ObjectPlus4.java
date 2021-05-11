package MPx;

import java.util.LinkedList;
import java.util.List;

public abstract class ObjectPlus4 extends ObjectPlusPlus {
    private final List<String> rolesXOR = new LinkedList<>();
    public void addXorRole(String xorRoleName) {
        rolesXOR.add(xorRoleName);
    }
    public void addLinkXor(String roleName, String reverseRoleName, ObjectPlusPlus
            targetObject) throws Exception {
        if(rolesXOR.contains(roleName)) {
            if(isXorLink()) {
                throw new Exception("There is a link for a XOR roles!");
            }
        }
        rolesXOR.add(roleName);
        super.addLink(roleName, reverseRoleName, targetObject);
    }
    private boolean isXorLink() {
        for(String role : rolesXOR) {
            if(this.anyLink(role)) {
                return true;
            }
        }
        return false;
    }
}
