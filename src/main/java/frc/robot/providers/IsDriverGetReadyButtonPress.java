package frc.robot.providers;

public class IsDriverGetReadyButtonPress {

    private static boolean press = false;
    private static boolean changed = false;

    public static void setPress(boolean isPress){
        if (isPress != press){
            changed = true;
        }
        press = isPress;
    }

    public static boolean isPress() {
        return press;
    }

    public static boolean wasChanged(){
        return changed;
    }
}
