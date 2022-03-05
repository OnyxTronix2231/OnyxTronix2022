package frc.robot.shooter;

import static frc.robot.shooter.ShooterConstants.ComponentsConstants.ENCODER_UNITS_PER_ROUND;
import static frc.robot.shooter.ShooterConstants.ComponentsConstants.SHOOTER_MOTOR_RADIUS;

public class ShooterConstants {

    static final int SEC_IN_MIN = 60;
    static final double DECI_SECONDS_PER_MINUTE = 600;
    static final double KP = 0.14;
    static final double KI = 0.0004;
    static final double KD = 15;
    static final double INTEGRAL_ZONE = 40;
    static final double CLOSE_LOOP_OUTPUT = 1023;
    static final double MAX_VELOCITY = 16325 * 1.25;
    static final double KF = CLOSE_LOOP_OUTPUT / MAX_VELOCITY;
    static final double TOLERANCE = 15;
    static final double SPEED = 0;
    static final double OPEN_LOOP_RAMP = 0;
    static final double CLOSE_LOOP_RAMP = 0.8;
    static final double SUPPLY_CURRENT_LIMIT = 35;
    static final double SUPPLY_TRIGGER_THRESHOLD_CURRENT = 50;
    static final double SUPPLY_TRIGGER_THRESHOLD_TIME = 0.5;
    static final double STATOR_CURRENT_LIMIT = 0;
    static final double STATOR_TRIGGER_THRESHOLD_CURRENT = 0;
    static final double STATOR_TRIGGER_THRESHOLD_TIME = 0;
    static final boolean SUPPLY_CURRENT_LIMIT_ENABLED = true;
    static final boolean STATOR_CURRENT_LIMIT_ENABLED = false;

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

        static double encUnitsDecisecToRPM(double encoderUnits) {
            return (encoderUnits * DECI_SECONDS_PER_MINUTE) / ENCODER_UNITS_PER_ROUND;
        }

        static double distanceToRPM(double distance) {
            return 0;
        }

        static double RPMToMPS(double RPM) {
            return ((2 * Math.PI * SHOOTER_MOTOR_RADIUS) / SEC_IN_MIN * RPM);
        }
    }
}
