package frc.robot.climber;

public class ClimberConstants {

    static final int RAIL_MASTER_MOTOR_ID = 13;
    static final int RAIL_SLAVE_MOTOR_ID = 14;
    static final int ARM_RIGHT_MOTOR_ID = 15;
    static final int ARM_LEFT_MOTOR_ID = 16;
    static final int INNER_HALL_EFFECT_CHANNEL = 1;
    static final int MAX_CLOSE_LOOP_OUTPUT = 1023;
    static final int ARM_LEFT_MAX_VELOCITY = 0; //TODO: Check and change
    static final int ARM_RIGHT_MAX_VELOCITY = 0; //TODO: Check and change
    static final int RAIL_MAX_VELOCITY = 0; //TODO: Check and change
    static final int ENCODER_UNITS_PER_ROUND = 2048; //TODO: Check and change
    static final int ARM_ACCELERATION = 0; //TODO: Check and change
    static final int ARM_CRUISE_VELOCITY = 0; //TODO: Check and change
    static final int ARM_ACCELERATION_SMOOTHING = 0; //TODO: Check and change
    static final int ARM_METERS_PER_ROUND = 1; //TODO: Check and change
    static final int RAIL_ACCELERATION = 0; //TODO: Check and change
    static final int RAIL_CRUISE_VELOCITY = 0; //TODO: Check and change
    static final int RAIL_ACCELERATION_SMOOTHING = 0; //TODO: Check and change
    static final int RAIL_METERS_PER_ROUND = 1; //TODO: Check and change
    static final double ARM_DISTANCE = 1; //TODO: Check and change
    static final double ARM_DISTANCE_2 = 1; //TODO: Check and change
    static final double ARM_TOLERANCE = 0.01; //TODO: Check and change
    static final double RAIL_TOLERANCE = 0.01; //TODO: Check and change
    static final double PERCENT_OUTPUT = 0.8; //TODO: Check and change
    static final double ARM_RIGHT_KP = 0; //TODO: Check and change
    static final double ARM_RIGHT_KI = 0; //TODO: Check and change
    static final double ARM_RIGHT_KD = 0; //TODO: Check and change
    static final double ARM_RIGHT_KF = ARM_RIGHT_MAX_VELOCITY / MAX_CLOSE_LOOP_OUTPUT;
    static final double ARM_RIGHT_ARB_FF = 0; //TODO: Check and Change
    static final double ARM_LEFT_KP = 0; //TODO: Check and change
    static final double ARM_LEFT_KI = 0; //TODO: Check and change
    static final double ARM_LEFT_KD = 0; //TODO: Check and change
    static final double ARM_LEFT_KF = ARM_LEFT_MAX_VELOCITY / MAX_CLOSE_LOOP_OUTPUT;
    static final double ARM_LEFT_ARB_FF = 0; //TODO: Check and change
    static final double RAIL_KP = 0; //TODO: Check and change
    static final double RAIL_KI = 0; //TODO: Check and change
    static final double RAIL_KD = 0; //TODO: Check and change
    static final double RAIL_KF = RAIL_MAX_VELOCITY / MAX_CLOSE_LOOP_OUTPUT;

    static class Calculations {

        static double armEncoderUnitsToMeter(double encoderUnits) {
            return (encoderUnits / ENCODER_UNITS_PER_ROUND) * ARM_METERS_PER_ROUND;
        }

        static double armMeterToEncoderUnits(double meters) {
            return (meters / ARM_METERS_PER_ROUND) * ENCODER_UNITS_PER_ROUND;
        }

        static double railEncoderUnitsToMeter(double encoderUnits) {
            return (encoderUnits / ENCODER_UNITS_PER_ROUND) * RAIL_METERS_PER_ROUND;
        }

        static double railMeterToEncoderUnits(double meters) {
            return (meters / RAIL_METERS_PER_ROUND) * ENCODER_UNITS_PER_ROUND;
        }
    }
}
