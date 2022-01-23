package frc.robot.RGB;

import com.ctre.phoenix.CANifier;

public class Constants {
    public final static CANifier.PWMChannel kMotorControllerCh = CANifier.PWMChannel.PWMChannel2;

    public final static double DUTY_CYCLES = 0;

    public final static int DEFAULT_COLOR_VALUE = 0;

    public final static int RGB_ARRAY_SIZE = 3;
    public final static int R = 0;
    public final static int G = 1;
    public final static int B = 2;
    public final static int MAX_RGB_VALUE = 255;
    public final static int MIN_RGB_VALUE = 0;

    public final static float[] RED_RGB = {255, 0, 0};
    public final static float[] BLUE_RGB = {0, 0, 255};
    public final static float[] GREEN_RGB = {0, 255, 0};
    public final static float[] YELLOW_RGB = {255, 255, 0};
    public final static float[] PINK_RGB = {255, 20, 147};
    public final static float[] PURPLE_RGB = {128, 0, 128};
    public final static float[] WHITE_RGB = {255, 255, 255};
    public final static float[] BLACK_RGB = {0, 0, 0};
}
