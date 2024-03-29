package frc.robot.shooter;

import static frc.robot.shooter.ShooterConstants.ComponentsConstants.*;

public class ShooterConstants {

    static final int SEC_IN_MIN = 60;
    static final double DECI_SECONDS_PER_MINUTE = 600;
    static final double KP = 0.2;
    static final double KI = 0.001;
    static final double KD = 11;
    static final double INTEGRAL_ZONE = 150;
    static final double CLOSE_LOOP_OUTPUT = 1023;
    static final double MAX_VELOCITY = 14325 * 1.25;
    static final double KF = CLOSE_LOOP_OUTPUT / MAX_VELOCITY;
    static final double TOLERANCE = 100;
    static final double SPEED = 0;
    static final double OPEN_LOOP_RAMP = 0;
    static final double CLOSE_LOOP_RAMP = 0.8;
    static final double SUPPLY_CURRENT_LIMIT = 35;
    static final double SUPPLY_TRIGGER_THRESHOLD_CURRENT = 50;
    static final double SUPPLY_TRIGGER_THRESHOLD_TIME = 0.5;
    static final double STATOR_CURRENT_LIMIT = 0;
    static final double STATOR_TRIGGER_THRESHOLD_CURRENT = 0;
    static final double STATOR_TRIGGER_THRESHOLD_TIME = 0;
    static final double OFFSET = 40;
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
            /*if(distance > 400) {
                distance += OFFSET;
            }
            if (distance > 700){
                distance += OFFSET * 1.5;
            }*/
            return -7 * Math.pow(10, -6) * Math.pow(distance, 3) + 0.011 * Math.pow(distance, 2) - 2.4264 * distance
                    + 1939;
        }

        static double RPMToMPS(double RPM) {
            return ((2 * Math.PI * SHOOTER_MOTOR_RADIUS) / SEC_IN_MIN * RPM);
        }
    }
}
