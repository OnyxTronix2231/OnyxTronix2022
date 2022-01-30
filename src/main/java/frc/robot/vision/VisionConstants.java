package frc.robot.vision;

public final class VisionConstants {

    public static final double OUTER_TARGET_HEIGHT_CM = 153;
    public static final double LIMELIGHT_HEIGHT_TO_FLOOR_CM = 59.3;
    public static final double LIMELIGHT_ANGLE_TO_HORIZON_DEG = 17.6;
    public static final double LIMELIGHT_TO_TARGET_CM =
            OUTER_TARGET_HEIGHT_CM - LIMELIGHT_HEIGHT_TO_FLOOR_CM;
    public static final double MID_TARGET_X_RTF = 0;  // TODO: check and change
    public static final double MID_TARGET_Y_RTF = 0;  // TODO: check and change
    public static final double LIMELIGHT_TO_TURRET_CM = 15.195728859;
}
