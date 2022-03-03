package frc.robot.vision;

public final class VisionConstants {

    public static final double TARGET_HEIGHT_CM = 266;
    public static final double LIMELIGHT_HEIGHT_TO_FLOOR_CM = 107;
    public static final double LIMELIGHT_ANGLE_TO_HORIZON_DEG = 33.1;
    public static final double LIMELIGHT_TO_TARGET_CM = TARGET_HEIGHT_CM - LIMELIGHT_HEIGHT_TO_FLOOR_CM;
    public static final double LIMELIGHT_TO_TURRET_CM = 19.5;
    public static final double TURRET_TOLERANCE = 0.5;
    public static final Vector2dEx LIMELIGHT_TO_TURRET_VECTOR_RTT =
            Vector2dEx.fromMagnitudeDirection(LIMELIGHT_TO_TURRET_CM, 0);
    public static final double TARGET_NOT_FOUND = 0;
    public static final double TARGET_X_RTF = 800;  //TODO: check and change
    public static final double TARGET_Y_RTF = 500;  //TODO: check and change
}
