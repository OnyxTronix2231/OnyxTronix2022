package frc.robot.shooter;

import static frc.robot.shooter.ShooterConstants.ComponentsConstants.ENCODER_UNITS_PER_ROUND;
import static frc.robot.shooter.ShooterConstants.ComponentsConstants.SHOOTER_MOTOR_RADIUS;

public class ShooterConstants {

    static final int SEC_IN_MIN = 60;
    static final double DECI_SECONDS_PER_MINUTE = 600;
    static final double KP = 0.2;
    static final double KI = 0;
    static final double KD = 10;
    static final double KF = 0.0482;
    static final double SPEED = 0;
    static final double TOLERANCE = 100;


    public static class ComponentsConstants {

        static final int MASTER_MOTOR_ID = 11;
        static final int SLAVE_MOTOR_ID = 12;
        static final double ENCODER_UNITS_PER_ROUND = 2048;
        static final double SHOOTER_MOTOR_RADIUS = 5.08;
    }

    public static class ShooterCalculations {

        static double RPMToEncUnitsDecisec(double rpm) {
            return (rpm * ENCODER_UNITS_PER_ROUND) / DECI_SECONDS_PER_MINUTE;
        }

        static double encUnitsDecisecToRPM(double encoderUnits){
            return (encoderUnits * DECI_SECONDS_PER_MINUTE) / ENCODER_UNITS_PER_ROUND;
        }

        static double RPMToMPS(double RPM) {
            return ((2 * Math.PI * SHOOTER_MOTOR_RADIUS) / SEC_IN_MIN * RPM);
        }
    }
}
