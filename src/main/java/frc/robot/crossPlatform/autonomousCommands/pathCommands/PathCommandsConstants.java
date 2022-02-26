package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.List;

public class PathCommandsConstants {

    static final double X_START_POSE_A = 0;
    static final double X_START_POSE_B = 0;
    static final double X_START_POSE_C = 0;
    static final double X_START_POSE_D = 0;
    static final double X_START_POSE_E = 0;

    static final double Y_START_POSE_A = 0;
    static final double Y_START_POSE_B = 0;
    static final double Y_START_POSE_C = 0;
    static final double Y_START_POSE_D = 0;
    static final double Y_START_POSE_E = 0;

    static final double X_FIRST_BALL_A = 8.943985451508386;
    static final double X_SECOND_BALL_A = 11.531;
    static final double X_THIRD_BALL_A = 15.522984492476057;
    static final double X_FOURTH_BALL_A = 11.654308133342933;
    static final double X_ENEMY_BALL_A = 10.507200608251132;
    static final double X_SHOOTING_PLACE_A = 9.922400693498448;

    static final double X_FIRST_BALL_B = 8.943985451508386;
    static final double X_SECOND_BALL_B = 11.531;

    static final double X_FIRST_BALL_C = 8.943985451508386;
    static final double X_ENEMY_BALL_C = 7.415;

    static final double X_FIRST_BALL_D = 11.654308133342933;

    static final double X_FIRST_BALL_E = 11.654308133342933;
    static final double X_ENEMY_BALL_E = 10.507200608251132;

    static final double Y_FIRST_BALL_A = 7.960;
    static final double Y_SECOND_BALL_A = 6.352;
    static final double Y_THIRD_BALL_A = 7.162;
    static final double Y_FOURTH_BALL_A = 2.022;
    static final double Y_ENEMY_BALL_A = 0.886;
    static final double Y_SHOOTING_PLACE_A = 3.282;

    static final double Y_FIRST_BALL_B = 7.960;
    static final double Y_SECOND_BALL_B = 6.352;

    static final double Y_FIRST_BALL_C = 7.960;
    static final double Y_ENEMY_BALL_C = 7.926;

    static final double Y_FIRST_BALL_D = 2.022;

    static final double Y_FIRST_BALL_E = 2.022;
    static final double Y_ENEMY_BALL_E = 0.886;

    static final double ROTATION_START_POSE_A = 0;
    static final double ROTATION_START_POSE_B = 0;
    static final double ROTATION_START_POSE_C = 0;
    static final double ROTATION_START_POSE_D = 0;
    static final double ROTATION_START_POSE_E = 0;

    static final double ROTATION_FIRST_BALL_A = 0;
    static final double ROTATION_SECOND_BALL_A = 0;
    static final double ROTATION_THIRD_BALL_A = 0;
    static final double ROTATION_FOURTH_BALL_A = 0;
    static final double ROTATION_ENEMY_BALL_A = 0;
    static final double ROTATION_SHOOTING_PLACE_A = 0;

    static final double ROTATION_FIRST_BALL_B = 0;
    static final double ROTATION_SECOND_BALL_B = 0;

    static final double ROTATION_FIRST_BALL_C = 0;
    static final double ROTATION_ENEMY_BALL_C = 0;

    static final double ROTATION_FIRST_BALL_D = 0;

    static final double ROTATION_FIRST_BALL_E = 0;
    static final double ROTATION_ENEMY_BALL_E = 0;

    static final double VELOCITY_CONSTRAINT_A = 2;
    static final double CENTRIPETAL_ACCELERATION_CONSTRAINT_A = 2;

    static final double VELOCITY_CONSTRAINT_B = 2;
    static final double CENTRIPETAL_ACCELERATION_CONSTRAINT_B = 2;

    static final double VELOCITY_CONSTRAINT_C = 2;
    static final double CENTRIPETAL_ACCELERATION_CONSTRAINT_C = 2;

    static final double VELOCITY_CONSTRAINT_D = 2;
    static final double CENTRIPETAL_ACCELERATION_CONSTRAINT_D = 2;

    static final double VELOCITY_CONSTRAINT_E = 2;
    static final double CENTRIPETAL_ACCELERATION_CONSTRAINT_E = 2;

    public static final class StartPoses {

        public static final Pose2d START_POSE_A = new Pose2d(X_START_POSE_A, Y_START_POSE_A,
                new Rotation2d(ROTATION_START_POSE_A));
        public static final Pose2d START_POSE_B = new Pose2d(X_START_POSE_B, Y_START_POSE_B,
                new Rotation2d(ROTATION_START_POSE_B));
        public static final Pose2d START_POSE_C = new Pose2d(X_START_POSE_C, Y_START_POSE_C,
                new Rotation2d(ROTATION_START_POSE_C));
        public static final Pose2d START_POSE_D = new Pose2d(X_START_POSE_D, Y_START_POSE_D,
                new Rotation2d(ROTATION_START_POSE_D));
        public static final Pose2d START_POSE_E = new Pose2d(X_START_POSE_E, Y_START_POSE_E,
                new Rotation2d(ROTATION_START_POSE_E));
    }

    public static final class Paths {

        public static final Path PATH_A_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(X_FIRST_BALL_A, Y_FIRST_BALL_A, Rotation2d.fromDegrees(ROTATION_FIRST_BALL_A)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_A),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_A)
        ).setReversed();

        public static final Path PATH_A_SECOND_BALL = new Path(
                List.of(),
                new Pose2d(X_SECOND_BALL_A, Y_SECOND_BALL_A, Rotation2d.fromDegrees(ROTATION_SECOND_BALL_A)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_A),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_A)
        );

        public static final Path PATH_A_THIRD_BALL = new Path(
                List.of(),
                new Pose2d(X_THIRD_BALL_A, Y_THIRD_BALL_A, Rotation2d.fromDegrees(ROTATION_THIRD_BALL_A)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_A),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_A)
        );

        public static final Path PATH_A_SHOOTING_PLACE = new Path(
                List.of(),
                new Pose2d(X_SHOOTING_PLACE_A, Y_SHOOTING_PLACE_A, Rotation2d.fromDegrees(ROTATION_SHOOTING_PLACE_A)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_A),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_A)
        );

        public static final Path PATH_A_FOURTH_BALL = new Path(
                List.of(),
                new Pose2d(X_FOURTH_BALL_A, Y_FOURTH_BALL_A, Rotation2d.fromDegrees(ROTATION_FOURTH_BALL_A)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_A),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_A)
        );

        public static final Path PATH_A_ENEMY_BALL = new Path(
                List.of(),
                new Pose2d(X_ENEMY_BALL_A, Y_ENEMY_BALL_A, Rotation2d.fromDegrees(ROTATION_ENEMY_BALL_A)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_A),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_A)
        );

        public static final Path PATH_B_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(X_FIRST_BALL_B, Y_FIRST_BALL_B, Rotation2d.fromDegrees(ROTATION_FIRST_BALL_B)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_B),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_B)
        ).setReversed();

        public static final Path PATH_B_SECOND_BALL = new Path(
                List.of(),
                new Pose2d(X_SECOND_BALL_B, Y_SECOND_BALL_B, Rotation2d.fromDegrees(ROTATION_SECOND_BALL_B)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_B),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_B)
        );

        public static final Path PATH_C_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(X_FIRST_BALL_C, Y_FIRST_BALL_C, Rotation2d.fromDegrees(ROTATION_FIRST_BALL_C)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_C),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_C)
        ).setReversed();

        public static final Path PATH_C_ENEMY_BALL = new Path(
                List.of(),
                new Pose2d(X_ENEMY_BALL_C, Y_ENEMY_BALL_C, Rotation2d.fromDegrees(ROTATION_ENEMY_BALL_C)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_C),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_C)
        );

        public static final Path PATH_D_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(X_FIRST_BALL_D, Y_FIRST_BALL_D, Rotation2d.fromDegrees(ROTATION_FIRST_BALL_D)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_D),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_D)
        );

        public static final Path PATH_E_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(X_FIRST_BALL_E, Y_FIRST_BALL_E, Rotation2d.fromDegrees(ROTATION_FIRST_BALL_E)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_E),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_E)
        );

        public static final Path PATH_E_ENEMY_BALL = new Path(
                List.of(),
                new Pose2d(X_ENEMY_BALL_E, Y_ENEMY_BALL_E, Rotation2d.fromDegrees(ROTATION_ENEMY_BALL_E)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_E),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_E)
        );
    }
}
