package frc.robot.arc;

import static frc.robot.arc.ArcConstants.ComponentsConstants.*;

public class ArcConstants {

    public static class ComponentsConstants {

        public static final int LINEAR_SERVO_CHANNEL = 0;
        public static final int LINEAR_SERVO_MAX_LENGTH = 50;
        public static final int LINEAR_SERVO_MAX_SPEED = 32;
        public static final double ARC_MAX_ANGLE = 35;
        public static final double ARC_MIN_ANGLE = 23.48;
        public static final double ANGLE = 23.48;
        public static final double SPEED = 0;
    }

    public static class ArcCalculations {

        public static double linearServoPosToAngle(double position) {
            return ((ARC_MAX_ANGLE - ARC_MIN_ANGLE) * position) / LINEAR_SERVO_MAX_LENGTH + ARC_MIN_ANGLE;
        }

        public static double angleToLinearServoPos(double angle) {
            return (LINEAR_SERVO_MAX_LENGTH * (angle - ARC_MIN_ANGLE)) / (ARC_MAX_ANGLE - ARC_MIN_ANGLE);
        }

        public static double distanceToAngle(double distance) {
            return 0; //todo find the calculations for this
        }
    }
}
