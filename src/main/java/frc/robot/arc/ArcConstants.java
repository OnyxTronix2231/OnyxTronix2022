package frc.robot.arc;

import static frc.robot.arc.ArcConstants.ComponentsConstants.*;

public class ArcConstants {

    static final int TIME_OUT = 100;
    static final int MAX_ACC = 1000;
    static final int ACC_SMOOTHING = 0;
    static final int CRUISE_VELOCITY = 500;
    static final double SPEED = 0;
    static final double KP = 0.5;
    static final double KI = 0.00251;
    static final double KD = 8;
    static final double KF = 1.657;
    public static final double CALIBRATION_SPEED = -0.2;
    static final double INTEGRAL_ZONE = 25;

    public static class ComponentsConstants {

        static final int MOTOR_ID = 13;
        static final double CONVERSION_RATE = 1;
        static final double ENCODER_UNITS_PER_ROUND = 4096 * CONVERSION_RATE;
        static final double ANGLE_PER_MOTOR_ROTATION = 45;
        public static final double ARC_MIN_ANGLE = 15.33;
        static final double ARC_MAX_ANGLE = 62;
    }

    public static class ArcCalculations {

        public static double angleToEncoderUnits(double angle) {
            return ((angle - ARC_MIN_ANGLE) / ANGLE_PER_MOTOR_ROTATION) * ENCODER_UNITS_PER_ROUND;
        }

        public static double encoderUnitsToAngle(double encoderUnits) {
            return ((encoderUnits / ENCODER_UNITS_PER_ROUND) * ANGLE_PER_MOTOR_ROTATION) + ARC_MIN_ANGLE;
        }

        public static double distanceToAngle(double distance) {
            return distance; //todo find the calculations for this
        }
    }
}
