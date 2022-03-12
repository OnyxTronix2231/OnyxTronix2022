package frc.robot.vision;

public final class VisionConstants {

    static final double TARGET_HEIGHT_CM = 266;
    static final double LIMELIGHT_HEIGHT_TO_FLOOR_CM = 108.5;
    static final double LIMELIGHT_TO_TARGET_CM = TARGET_HEIGHT_CM - LIMELIGHT_HEIGHT_TO_FLOOR_CM;
    static final double LIMELIGHT_TO_TURRET_CM = 21.4;
    static final double TARGET_RADIUS = 134.0 / 2;
    static final double TURRET_TOLERANCE = 2;
    static final Vector2dEx LIMELIGHT_TO_TURRET_VECTOR_RTT =
            Vector2dEx.fromMagnitudeDirection(LIMELIGHT_TO_TURRET_CM, 0);
    static final double TARGET_NOT_FOUND = -999;
    static final double TARGET_X_RTF = 800;  //TODO: check and change
    static final double TARGET_Y_RTF = 500;  //TODO: check and change
    static final double LIMELIGHT_ANGLE_TO_HORIZON_DEG = 30;
    static final int PIPELINE = 2;
    static final double CM_TO_METERS = 100;
}
