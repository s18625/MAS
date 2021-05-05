package MPx;

public class Mode extends ObjectPlusPlus{
    public Mode(PrivateLesson privateLesson) throws Exception {
        if (privateLesson == null) throw new Exception("required PrivateLesson object");
        privateLesson.addPart(Roles.PART,Roles.WHOLE,this);
    }

}
