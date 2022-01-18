package frc.robot.drivetrain;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public final class DriveTrainConstants {
    static final int LEFT_MASTER_PORT = 3;
    static final int LEFT_SLAVE_PORT = 4;
    static final int RIGHT_MASTER_PORT = 1;
    static final int RIGHT_SLAVE_PORT = 2;
    static final double MAX_OUTPUT_FORWARD = 0;
    static final double MAX_OUTPUT_REVERSE = 0;
    static final double CURRENT_LIMIT = 0;
    static final double TRIGGER_THRESHOLD_CURRENT = 0;
    static final double TRIGGER_THRESHOLD_TIME = 0;
    static final double RAMP_TIME = 0.3;
    static final double ENCODER_UNITS_TO_METER = 1;
    static final double CONVENTION = 1;
    static final double ENCODER_UNITS_PER_ROTATION = 2048*CONVENTION;
    static final double WHEEL_DIAMETER = 0.1524;
    static final double kP = 0;
    static final double kI = 0;
    static final double kD = 0;
    static final double kF = 0;
    static final int acceleration = 0;
    static final int cruiseVelocity = 0;
    static final int accelerationSmoothing = 0;
    static final double tolerance = 0.05;

    public static class Calculations{

        static double encoderUnitsToMeter(double encodeUnits){
            return (encodeUnits / ENCODER_UNITS_PER_ROTATION) * WHEEL_DIAMETER * Math.PI;
        }

        static double meterToEncoderUnits(double meters){
            return meters * ENCODER_UNITS_PER_ROTATION;
        }
    }
}
