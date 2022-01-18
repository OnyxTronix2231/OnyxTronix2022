package frc.robot.climber;

public class ClimberConstants {

    static final int FORWARD_CHANNEL = 1; //TODO: Check and change
    static final int BACKWARD_CHANNEL = 2; //TODO: Check and change
    static final int ENCODER_UNITS_PER_ROUND = 2048;
    static final int ARM_kP = 0;
    static final int ARM_kI = 0;
    static final int ARM_kD = 0;
    static final int ARM_kF = 0;
    static final int ARM_ACCELERATION = 0;
    static final int ARM_CRUISE_VELOCITY = 0;
    static final int ARM_ACCELERATION_SMOOTHING = 0;
    static final int ARM_METERS_PER_ROUND = 1;
    static final int RAIL_kP = 0;
    static final int RAIL_kI = 0;
    static final int RAIL_kD = 0;
    static final int RAIL_kF = 0;
    static final int RAIL_ACCELERATION = 0;
    static final int RAIL_CRUISE_VELOCITY = 0;
    static final int RAIL_ACCELERATION_SMOOTHING = 0;
    static final int RAIL_METERS_PER_ROUND = 1;
    static final double ARM_DISTANCE = 1;
    static final double ARM_DISTANCE_2 = 1;
    static final double PERCENT_OUTPUT = 0.8;
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
