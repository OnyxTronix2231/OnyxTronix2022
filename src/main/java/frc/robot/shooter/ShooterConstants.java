package frc.robot.shooter;

import static frc.robot.shooter.ShooterConstants.RobotConstants.ENCODER_UNITS_PER_ROUND;

public class ShooterConstants {

    public static final int SEC_IN_MIN = 60;
    public static final double DECI_SECONDS_PER_MINUTE = 600;
    public static final double SPEED = 0.5;
    public static final double KP = 0; //TODO calibrate value
    public static final double KI = 0; //TODO calibrate value
    public static final double KD = 0; //TODO calibrate value
    public static final double KF = 0; //TODO calibrate value

    public static class RobotConstants {

        public static final int MASTER_MOTOR_ID = 11;
        public static final int SLAVE_MOTOR_ID = 12;
        public static final double ENCODER_UNITS_PER_ROUND = 2048;
        public static final double SHOOTER_MOTOR_RADIUS = 0; //TODO check with mechanics
    }

    public static class ShooterCalculations {

        public static double rpmToEncUnitsDecisec(double rpm) {
            return (rpm * ENCODER_UNITS_PER_ROUND) / DECI_SECONDS_PER_MINUTE;
        }

        public static double rpmToMPS(double rpm) {
            return ((2 * Math.PI * RobotConstants.SHOOTER_MOTOR_RADIUS) / SEC_IN_MIN * rpm);
        }
    }
}
