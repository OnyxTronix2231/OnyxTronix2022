package frc.robot.shooter;

public class ShooterConstants {

    static final int MASTER_MOTOR_ID = 1;
    static final int SLAVE_MOTOR_ID = 1;
    static final double ENCODER_UNITS_PER_ROUND = 1;
    static final double DECI_SECONDS_PER_MINUTE = 1;
    static final double SPEED = 0.5;
    static final double KP = 0; //TODO calibrate value
    static final double KI = 0; //TODO calibrate value
    static final double KD = 0; //TODO calibrate value
    static final double KF = 0; //TODO calibrate value
    static final double SHOOTER_MOTOR_RADIUS = 0; //TODO check with mechanics
    public static final int SEC_IN_MIN = 60;

    public static class ShooterCalculations {
        static double rpmToEncoderUnitsInDecisecond(double rpm) {
            return (rpm * ENCODER_UNITS_PER_ROUND) / DECI_SECONDS_PER_MINUTE;
        }

        static double rpmToMetersPerSec(double rpm) {
            return ((2 * Math.PI * SHOOTER_MOTOR_RADIUS) / SEC_IN_MIN * rpm);
        }
    }
}
