package frc.robot.climber;

public class ClimberConstants {

    static final int FORWARD_CHANNEL = 1; //TODO: Check and change
    static final int BACKWARD_CHANNEL = 2; //TODO: Check and change
    static final int kP = 0;
    static final int kI = 0;
    static final int kD = 0;
    static final int kF = 0;
    static final int ACCELERATION = 0;
    static final int CRUISE_VELOCITY = 0;
    static final int ACCELERATION_SMOOTHING = 0;
    static final int ENCODER_UNITS_PER_ROUND = 2048;
    static final int METERS_PER_ROUND = 1;

    static class Calculations {

        static double encoderUnitsToMeter(double encoderUnits) {
            return (encoderUnits / ENCODER_UNITS_PER_ROUND) * METERS_PER_ROUND;
        }

        static double meterToEncoderUnits(double meters) {
            return (meters / METERS_PER_ROUND) * ENCODER_UNITS_PER_ROUND;
        }
    }
}
