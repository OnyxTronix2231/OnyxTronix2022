package frc.robot.RGB;

import com.ctre.phoenix.CANifier;

public class Constants {

    public final static CANifier.PWMChannel RGB_CONTROLLER_CHANNEL = CANifier.PWMChannel.PWMChannel2;

    public final static double DUTY_CYCLES = 0;
    public final static int LED_ID = 0;

    public final static int R_INDEX = 0;
    public final static int G_INDEX = 1;
    public final static int B_INDEX = 2;
    public final static int RGB_ARRAY_SIZE = 3;
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
    public final static float[] ORANGE_RGB = {255, 215, 0};
}
