package frc.robot.arc;

import static frc.robot.arc.ArcConstants.ComponentsConstants.*;

public class ArcConstants {

    public static final double SPEED = 0;
    public static final double MAX_CLOSED_LOOP_OUTPUT = 1023;
    public static final double MAX_VELOCITY = 0; //ToDo check.
    public static final double KP = 0;  //TODO calibrate
    public static final double KI = 0;  //TODO calibrate
    public static final double KD = 0;  //TODO calibrate
    public static final double KF = MAX_CLOSED_LOOP_OUTPUT / MAX_VELOCITY;

    public static class ComponentsConstants {

        public static final int MOTOR_ID = 1;
        public static final double ENCODER_UNITS_PER_ROUND = 2048;
        public static final double ARC_MAX_ANGLE = 35;
        public static final double ARC_MIN_ANGLE = 23.48;
        public static final double ANGLE_PER_MOTOR_ROTATION = 1; // TODO check.
    }

    public static class ArcCalculations {

        public static double angleToEncoderUnits(double angle) {
            return (angle / ANGLE_PER_MOTOR_ROTATION) * ENCODER_UNITS_PER_ROUND;
        }

        public static double distanceToAngle(double distance) {
            return distance; //todo find the calculations for this
        }
    }
}
