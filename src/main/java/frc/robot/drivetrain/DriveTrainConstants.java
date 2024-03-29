package frc.robot.drivetrain;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public final class DriveTrainConstants {

    static final int DECISECOND_IN_SECOND = 10;
    static final int ENCODER_UNITS = 2048;
    static final double CONVERSION_RATE = 8.4;
    static final double VOLTS = 12;
    static final double WHEEL_DIAMETER_METER = 0.1524;
    static final double PERIMETER_METER = WHEEL_DIAMETER_METER * Math.PI;
    static final double ENCODER_UNITS_PER_ROTATION = ENCODER_UNITS * CONVERSION_RATE;
    static final double ROTATION_SENSITIVITY = 0.5;
    static final double SPEED_SENSITIVITY = 0.8;
    static final double STOPPING_SPEED_TOLERANCE = 0.05;

    static final double MAX_SPEED_METERS_PER_SECOND = 4.5; // TODO: check
    static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 3; // TODO: check
    static final double TRACKWIDTH_METERS = 0.68;
    public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
            new DifferentialDriveKinematics(TRACKWIDTH_METERS);
    static final double KS = 0.64545; // TODO: calibrate
    static final double KV = 2.1106; // TODO: calibrate
    static final double KA = 0.057821; // TODO: calibrate
    public static final SimpleMotorFeedforward FEEDFORWARD = new SimpleMotorFeedforward(KS, KV, KA);

    public static final double LAUNCH_PAD_POSITION_RED_X = 12.86;
    public static final double LAUNCH_PAD_POSITION_RED_Y = 2.731;
    public static final double LAUNCH_PAD_RED_DEGREE = 180;
    public static final double LAUNCH_PAD_POSITION_BLUE_X = 3.738;
    public static final double LAUNCH_PAD_POSITION_BLUE_Y = 5.525;
    public static final double LAUNCH_PAD_BLUE_DEGREE = 0;
    public static final double ABLE_TO_SHOOT_SPEED = 0; //todo find value mps

    public static final class ComponentsConstants {

        static final int RIGHT_MASTER_MOTOR_PORT = 1;
        static final int RIGHT_SLAVE_MOTOR_PORT = 2;
        static final int LEFT_MASTER_MOTOR_PORT = 3;
        static final int LEFT_SLAVE_MOTOR_PORT = 4;
        static final int PIGEON_PORT = 0;

        static final double MAX_OUTPUT_FORWARD = 1;
        static final double MAX_OUTPUT_REVERSE = -1;
        static final double CURRENT_LIMIT = 40;
        static final double TRIGGER_THRESHOLD_CURRENT = 0;
        static final double TRIGGER_THRESHOLD_TIME = 0;
        static final double RAMP_TIME = 0.4;
        static final boolean SUPPLY_CURRENT_LIMIT_ENABLED = true;
    }
    public static final class Calculations {

        static double encoderUnitsToMeter(double encodeUnits) {
            return (encodeUnits / ENCODER_UNITS_PER_ROTATION) * WHEEL_DIAMETER_METER * Math.PI;
        }

        static double meterToEncoderUnits(double meters) {
            return meters * ENCODER_UNITS_PER_ROTATION;
        }

        static double encoderUnitsToMeters(double units) {
            return units * PERIMETER_METER / ENCODER_UNITS_PER_ROTATION;
        }

        static double encoderUnitsDeciSecToMetersSec(double unitsDeciSec) {
            return encoderUnitsToMeters(unitsDeciSec * DECISECOND_IN_SECOND);
        }

        static double getAverageSpeed(double leftSpeed, double rightSpeed) {
            return (leftSpeed + rightSpeed) / 2;
        }
    }
}
