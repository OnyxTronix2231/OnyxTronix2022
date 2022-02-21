package frc.robot.drivetrain;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import java.util.List;

public final class DriveTrainConstants {

    static final double ROTATION_SENSITIVITY = 1;
    static final double SPEED_SENSITIVITY = 1;

    static final int DECISECOND_IN_SECOND = 10;
    static final int ENCODER_UNITS = 2048;
    static final double CONVERSION_RATE = 8.4;
    static final double VOLTS = 12;
    static final double WHEEL_DIAMETER_METER = 0.1524;
    static final double PERIMETER_METER = WHEEL_DIAMETER_METER * Math.PI;
    static final double ENCODER_UNITS_PER_ROTATION = ENCODER_UNITS * CONVERSION_RATE;

    static final double MAX_SPEED_METERS_PER_SECOND = 4.5; // TODO: check
    static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = 3; // TODO: check
    static final double TRACKWIDTH_METERS = 0.68;
    public static final double TRAJECTORY_P = 0;
    static final double KS = 0.68132; // TODO: calibrate
    static final double KV = 2.0333; // TODO: calibrate
    static final double KA = 0.0073009; // TODO: calibrate

    public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
            new DifferentialDriveKinematics(TRACKWIDTH_METERS);
    public static final SimpleMotorFeedforward FEEDFORWARD = new SimpleMotorFeedforward(KS, KV, KA);

    public static final class ComponentsConstants {

        static final int RIGHT_MASTER_MOTOR_PORT = 1;
        static final int RIGHT_SLAVE_MOTOR_PORT = 2;
        static final int LEFT_MASTER_MOTOR_PORT = 3;
        static final int LEFT_SLAVE_MOTOR_PORT = 4;
        static final int PIGEON_PORT = 0;

        static final double MAX_OUTPUT_FORWARD = 1;
        static final double MAX_OUTPUT_REVERSE = -1;
        static final double CURRENT_LIMIT = 40;
        static final double TRIGGER_THRESHOLD_CURRENT = 40;
        static final double TRIGGER_THRESHOLD_TIME = 0.03;
        static final double RAMP_TIME = 0.3;
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
    }

    public static final class StartPoses {

        public static final Pose2d S1 = new Pose2d(2, 3, new Rotation2d(30));
    }

    public static final class Paths {

        public static final Path PATH_A_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(8.943985451508386, 7.960, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        ).setReversed();

        public static final Path PATH_A_SECOND_BALL = new Path(
                List.of(),
                new Pose2d(11.531, 6.352, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_A_THIRD_BALL = new Path(
                List.of(),
                new Pose2d(15.522984492476057, 7.162, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_A_SHOOTING_PLACE = new Path(
                List.of(),
                new Pose2d(9.922400693498448, 3.282, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_A_FOURTH_BALL = new Path(
                List.of(),
                new Pose2d(11.654308133342933, 2.022, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_A_ENEMY_BALL = new Path(
                List.of(),
                new Pose2d(10.507200608251132, 0.886, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_B_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(8.943985451508386, 7.960, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        ).setReversed();

        public static final Path PATH_B_SECOND_BALL = new Path(
                List.of(),
                new Pose2d(11.531, 6.352, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_C_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(8.943985451508386, 7.960, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        ).setReversed();

        public static final Path PATH_C_ENEMY_BALL = new Path(
                List.of(),
                new Pose2d(7.415,7.926,Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_D_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(11.654308133342933, 2.022, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_E_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(11.654308133342933, 2.022, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );

        public static final Path PATH_E_ENEMY_BALL = new Path(
                List.of(),
                new Pose2d(10.507200608251132, 0.886, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(1.5)
        );
    }
}
