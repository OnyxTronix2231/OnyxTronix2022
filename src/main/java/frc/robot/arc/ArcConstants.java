package frc.robot.arc;

public class ArcConstants {

    public static final int ARCH_CHANNEL = 8;
    public static final int ARCH_MAX_LENGTH = 50;
    public static final int ARC_MAX_SPEED = 32;
    public static final double ARC_MAX_ANGLE = 28;
    public static final double ARC_MIN_ANGLE = 15;

    public static class ArcCalculations {

        public static double getAngleFromLinearServoPosition(double position) {
            return ((ARC_MAX_ANGLE + ARC_MIN_ANGLE) * position) / ARCH_MAX_LENGTH + ARC_MIN_ANGLE;
        }

        public static double getLinearServoPositionFromAngle(double angle) {
            return (ARCH_MAX_LENGTH * (angle - ARC_MIN_ANGLE)) / (ARC_MAX_ANGLE-ARC_MIN_ANGLE);
        }

        public static double getAngleFromTargetDistance(double distance) {
            return 0; //todo find the calculations for this
        }
    }
}
