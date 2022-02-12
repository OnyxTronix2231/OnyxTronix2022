package frc.robot.drivetrain;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;

import java.util.List;

public final class DriveTrainConstants {
    public static final int LEFT_MASTER_MOTOR_PORT = 3;
    public static final int LEFT_SLAVE_MOTOR_PORT = 4;
    public static final int RIGHT_MASTER_MOTOR_PORT = 1;
    public static final int RIGHT_SLAVE_MOTOR_PORT = 2;
    public static final int PIGEON_PORT = 0;

    public static final double MAX_OUTPUT_FORWARD = 1;
    public static final double MAX_OUTPUT_REVERSE = -1;
    public static final double CURRENT_LIMIT = 40;
    public static final double TRIGGER_THRESHOLD_CURRENT = 40;
    public static final double TRIGGER_THRESHOLD_TIME = 0.03;
    public static final double RAMP_TIME = 0.3;

    public static final int DECISECOND_IN_SECOND = 10;
    public static final int ENCODER_UNITS = 2048;
    public static final double CONVERSION_RATE = 9;
    public static final double VOLTS = 12;
    public static final double WHEEL_DIAMETER_METER = 0.1524;
    public static final double PERIMETER_METER = WHEEL_DIAMETER_METER * Math.PI;
    public static final double ENCODER_UNITS_PER_ROTATION = ENCODER_UNITS * CONVERSION_RATE;

    public static final double MAX_SPEED_METERS_PER_SECOND = 4.5;
    public static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 3;
    public static final double TRACKWIDTH_METERS = 0.69;
    public static final double TRAJECTORY_P = 0;
    public static final double KS = 0.68132;
    public static final double KV = 2.5333;
    public static final double KA = 0.0073009;

    public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
            new DifferentialDriveKinematics(TRACKWIDTH_METERS);
    public static final SimpleMotorFeedforward FEEDFORWARD = new SimpleMotorFeedforward(KS, KV, KA);

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
    }

    public static final class Paths {

        public static final Path PATH_1 = new Path(
            new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
            List.of(new Translation2d(2, 0), new Translation2d(2,2)),
            new Pose2d(4, 2, Rotation2d.fromDegrees(0)),
            false,
            new CentripetalAccelerationConstraint(1),
            new MaxVelocityConstraint(1));

        public static final Path ONE_METER_FORWARD = new Path(
                new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(1, 0, Rotation2d.fromDegrees(0)),
                false,
                new MaxVelocityConstraint(1.5));

        public static final Path ONE_METER_BACKWARD = new Path(
                new Pose2d(1, 0, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                true,
                new MaxVelocityConstraint(1.5));

        public static final Path path1 = new Path(
                new Pose2d(8.943985451508386, 5.520, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(8.943985451508386, 7.960, Rotation2d.fromDegrees(0)),
                true,
                new MaxVelocityConstraint(1.5)
        );

        public static final Path path2 = new Path(
                new Pose2d(9.000216212542298, 7.533, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(8.943985451508386, 6.352, Rotation2d.fromDegrees(0)),
                false,
                new MaxVelocityConstraint(1.5)
        );

        public static final Path path3 = new Path(
                new Pose2d(11.688046589963278, 5.947, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(15.522984492476057, 7.162, Rotation2d.fromDegrees(0)),
                false,
                new MaxVelocityConstraint(1.5)
        );

        public static final Path path4 = new Path(
                new Pose2d(15.28681529613363, 6.397, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(9.922400693498448, 3.282, Rotation2d.fromDegrees(0)),
                false,
                new MaxVelocityConstraint(1.5)
        );

        public static final Path path5 = new Path(
                new Pose2d(9.967385302325578, 3.158, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(11.654308133342933, 2.022, Rotation2d.fromDegrees(0)),
                false,
                new MaxVelocityConstraint(1.5)
        );

        public static final Path path6 = new Path(
                new Pose2d(11.553092763481887, 2.011, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(10.507200608251132, 0.886, Rotation2d.fromDegrees(0)),
                false,
                new MaxVelocityConstraint(1.5)
        );

        public static final Path path7 = new Path(
                new Pose2d(10.77710826121391, 1.246, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(12.104154221614227, 5.047, Rotation2d.fromDegrees(0)),
                false,
                new MaxVelocityConstraint(1.5)
        );

        public static final Path path8 = new Path(
                new Pose2d(8.943985451508386, 7.960, Rotation2d.fromDegrees(0)),
                List.of(),
                new Pose2d(7.415,7.926,Rotation2d.fromDegrees(0)),
                false,
                new MaxVelocityConstraint(1.5)
        );
    }
}
