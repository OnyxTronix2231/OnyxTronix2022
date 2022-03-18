package frc.robot.arc;

import static frc.robot.arc.ArcConstants.ComponentsConstants.ANGLE_PER_MOTOR_ROTATION;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ENCODER_UNITS_PER_ROUND;

public class ArcConstants {

    static final int TIME_OUT = 100;
    static final int MAX_ACC = 3000;
    static final int ACC_SMOOTHING = 0;
    static final int CRUISE_VELOCITY = 550;
    static final double SPEED = 0;
    static final double CLOSE_LOOP_OUTPUT = 1023;
    static final double MAX_VELOCITY = 510 * 1.25;
    static final double KP = 8;
    static final double KI = 0;
    static final double KD = 20;
    static final double KF = CLOSE_LOOP_OUTPUT / MAX_VELOCITY;
    static final double INTEGRAL_ZONE = 100;
    static final double TOLERANCE = 1;

    public static class ComponentsConstants {

        static final int MOTOR_ID = 13;
        static final double CONVERSION_RATE = 1;
        static final double ENCODER_UNITS_PER_ROUND = 4096 * CONVERSION_RATE;
        static final double ANGLE_PER_MOTOR_ROTATION = 45;
        static final double ARC_MIN_ANGLE = 15.33;
        static final double ARC_MAX_ANGLE = 62;
    }

    public static class ArcCalculations {

        static double angleToEncoderUnits(double angle) {
            return ((angle) / ANGLE_PER_MOTOR_ROTATION) * ENCODER_UNITS_PER_ROUND;
        }

        static double encoderUnitsToAngle(double encoderUnits) {
            return ((encoderUnits / ENCODER_UNITS_PER_ROUND) * ANGLE_PER_MOTOR_ROTATION);
        }

        static double distanceToAngle(double distance) {
            if (distance == 0) {
                return 20;
            }

            return -9e-05 * Math.pow(distance, 2) + 0.129 * distance + 10.012;
        }
    }
}
