package frc.robot.drivetrain;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public final class DriveTrainConstants {
    public static final double MAX_OUTPUT_FORWARD = 0;
    public static final double MAX_OUTPUT_REVERSE = 0;
    public static final double CURRENT_LIMIT = 0;
    public static final double TRIGGER_THRESHOLD_CURRENT = 0;
    public static final double TRIGGER_THRESHOLD_TIME = 0;
    public static final double RAMP_TIME = 0.3;
    static final int DECISECOND_IN_SECOND = 10;
    static final int ENCODER_UNITS = 2048;
    static final double CONVERSION_RATE = 0; //
    public static final double ENCODER_UNITS_TO_METER = 1;
    public static final double VOLTS = 12;
    public static final double WHEEL_DIAMETER_METER = 0.1524;
    public static final double PERIMETER_METER = WHEEL_DIAMETER_METER * Math.PI;
    static final int PIGEON_PORT = 0;
    static final double kP = 0;
    static final double kI = 0;
    static final double kD = 0;
    static final double kF = 0;
    static final int acceleration = 0;
    static final int cruiseVelocity = 0;
    static final int accelerationSmoothing = 0;
    static final double tolerance = 0.05;

    public static final double TRAJECTORY_P = 0;
    public static final double ENCODER_CPR = ENCODER_UNITS * CONVERSION_RATE;
    public static final double MAX_SPEED_METERS_PER_SECOND = 0;
    public static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 0;
    public static final double TRACKWIDTH_METERS = 0;
    private static final double KS = 0;
    private static final double KV = 0;
    private static final double KA = 0;
    public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
            new DifferentialDriveKinematics(TRACKWIDTH_METERS);
    public static final SimpleMotorFeedforward FEEDFORWARD = new SimpleMotorFeedforward(KS, KV, KA);


    public static final class Calculations {

        public static double encoderUnitsToMeter(double encoderUnites){
            return 0.0;
        }

        public static double meterToEncoderUnits(double meters){
            return 0.0;
        }

    }
}
