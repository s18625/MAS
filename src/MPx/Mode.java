package MPx;

public abstract class Mode extends ObjectPlusPlus{
    public Mode(PrivateLesson privateLesson) throws Exception {
        if (privateLesson == null) throw new Exception("required PrivateLesson object");
        if (!privateLesson.containTheRole(Roles.PART))privateLesson.addPart(Roles.PART,Roles.WHOLE,this);
    }

}
