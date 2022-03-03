package frc.robot.shooter;

import static frc.robot.shooter.ShooterConstants.ComponentsConstants.ENCODER_UNITS_PER_ROUND;
import static frc.robot.shooter.ShooterConstants.ComponentsConstants.SHOOTER_MOTOR_RADIUS;

public class ShooterConstants {

    public static final int SEC_IN_MIN = 60;
    public static final double DECI_SECONDS_PER_MINUTE = 600;
    public static final double KP = 0.2;
    public static final double KI = 0;
    public static final double KD = 10;
    public static final double KF = 0.0482;
    public static final double SPEED = 0;

    public static class ComponentsConstants {

        public static final int MASTER_MOTOR_ID = 11;
        public static final int SLAVE_MOTOR_ID = 12;
        public static final double ENCODER_UNITS_PER_ROUND = 2048;
        public static final double SHOOTER_MOTOR_RADIUS = 0; //TODO check with mechanics
    }

    public static class ShooterCalculations {

        public static double RPMToEncUnitsDecisec(double rpm) {
            return (rpm * ENCODER_UNITS_PER_ROUND) / DECI_SECONDS_PER_MINUTE;
        }

        public static double encUnitsDecisecToRPM(double encoderUnits){
            return (encoderUnits * DECI_SECONDS_PER_MINUTE) / ENCODER_UNITS_PER_ROUND;
        }

        public static double RPMToMPS(double RPM) {
            return ((2 * Math.PI * SHOOTER_MOTOR_RADIUS) / SEC_IN_MIN * RPM);
        }
    }
}
