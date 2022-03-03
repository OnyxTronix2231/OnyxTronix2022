package frc.robot.arc;

import static frc.robot.arc.ArcConstants.ComponentsConstants.*;

public class ArcConstants {

    static final int TIME_OUT = 100;
    static final int MAX_ACC = 0; //TODO: calibrate
    static final int ACC_SMOOTHING = 0; //TODO: calibrate
    static final int CRUISE_VELOCITY = 0; //TODO: calibrate
    static final double SPEED = 0;
    static final double MAX_CLOSED_LOOP_OUTPUT = 1023;
    static final double MAX_VELOCITY = 1; //ToDo check.
    static final double KP = 0;  //TODO calibrate
    static final double KI = 0;  //TODO calibrate
    static final double KD = 0;  //TODO calibrate
    static final double KF = MAX_CLOSED_LOOP_OUTPUT / MAX_VELOCITY;
    public static final double CALIBRATION_SPEED = 0;

    public static class ComponentsConstants {

        static final int MOTOR_ID = 1;
        static final double CONVERSION_RATE = 1000;
        static final double ENCODER_UNITS_PER_ROUND = 2048 * CONVERSION_RATE;
        static final double ANGLE_PER_MOTOR_ROTATION = 0.36;
        public static final double ARC_MIN_ANGLE = 20;
        static final double ARC_MAX_ANGLE = 65;
    }

    public static class ArcCalculations {

        public static double angleToEncoderUnits(double angle) {
            return (angle - ARC_MIN_ANGLE / ANGLE_PER_MOTOR_ROTATION) * ENCODER_UNITS_PER_ROUND;
        }

        public static double encoderUnitsToAngle(double encoderUnits) {
            return ((encoderUnits / ENCODER_UNITS_PER_ROUND) * ANGLE_PER_MOTOR_ROTATION) + ARC_MIN_ANGLE;
        }

        public static double distanceToAngle(double distance) {
            return distance; //todo find the calculations for this
        }
    }
}
