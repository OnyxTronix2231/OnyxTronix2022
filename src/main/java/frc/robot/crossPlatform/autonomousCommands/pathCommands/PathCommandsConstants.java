package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.List;

public class PathCommandsConstants {

    static final double X_START_POSE_A = 8.943985451508386; // TODO: check
    static final double X_FIRST_BALL_A = 8.943985451508386;
    static final double X_SECOND_BALL_A = 11.531;
    static final double X_THIRD_BALL_A = 15.522984492476057;
    static final double X_SHOOTING_PLACE_A = 11.299;
    static final double X_FOURTH_BALL_A = 11.654308133342933;
    static final double X_ENEMY_BALL_A = 10.507200608251132;

    static final double X_START_POSE_B = 8.943985451508386; // TODO: check
    static final double X_FIRST_BALL_B = 8.943985451508386;
    static final double X_SECOND_BALL_B = 11.531;

    static final double X_START_POSE_C = 8.943985451508386; // TODO: check
    static final double X_FIRST_BALL_C = 8.943985451508386;
    static final double X_ENEMY_BALL_C = 7.568;

    static final double X_START_POSE_D = 10; // TODO: check
    static final double X_FIRST_BALL_D = 11.654308133342933;

    static final double X_START_POSE_E = 10; // TODO: check
    static final double X_FIRST_BALL_E = 11.654308133342933;
    static final double X_ENEMY_BALL_E = 10.507200608251132;

    static final double Y_START_POSE_A = 5.960; // TODO: check
    static final double Y_FIRST_BALL_A = 7.650;
    static final double Y_SECOND_BALL_A = 6.352;
    static final double Y_THIRD_BALL_A = 6.87;
    static final double Y_SHOOTING_PLACE_A = 5.476;
    static final double Y_FOURTH_BALL_A = 2.022;
    static final double Y_ENEMY_BALL_A = 0.886;

    static final double Y_START_POSE_B = 5.960; // TODO: check
    static final double Y_FIRST_BALL_B = 7.650;
    static final double Y_SECOND_BALL_B = 6.352;

    static final double Y_START_POSE_C = 5.960; // TODO: check
    static final double Y_FIRST_BALL_C = 7.650;
    static final double Y_ENEMY_BALL_C = 7.826;

    static final double Y_START_POSE_D = 3; // TODO: check
    static final double Y_FIRST_BALL_D = 2.022;

    static final double Y_START_POSE_E = 3; // TODO: check
    static final double Y_FIRST_BALL_E = 2.022;
    static final double Y_ENEMY_BALL_E = 0.886;

    // TODO: check all rotation constants
    static final double ROTATION_START_POSE_A = -90;
    static final double ROTATION_FIRST_BALL_A = -153.335;
    static final double ROTATION_SECOND_BALL_A = 168.53;
    static final double ROTATION_THIRD_BALL_A = 161.626;
    static final double ROTATION_SHOOTING_PLACE_A = -126.0368;
    static final double ROTATION_FOURTH_BALL_A = -44.72144;
    static final double ROTATION_ENEMY_BALL_A = -44.72144;

    static final double ROTATION_START_POSE_B = -90;
    static final double ROTATION_FIRST_BALL_B = -153.335;
    static final double ROTATION_SECOND_BALL_B = -153.335;

    static final double ROTATION_START_POSE_C = -90;
    static final double ROTATION_FIRST_BALL_C = 7.289;
    static final double ROTATION_ENEMY_BALL_C = 7.289;

    static final double ROTATION_START_POSE_D = 30.591;
    static final double ROTATION_FIRST_BALL_D = 30.591;

    static final double ROTATION_START_POSE_E = 30.591;
    static final double ROTATION_FIRST_BALL_E = -44.72144;
    static final double ROTATION_ENEMY_BALL_E = -44.72144;

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

    static final double LOADER_SPEED_SUPPLIER = 0.5;
    static final double BALL_TRIGGER_SPEED_SUPPLIER = 0.5;
    static final double INTAKE_SPEED_SUPPLIER = 0.5;

    public static final class StartPoses {
        //94
        //86

        public static final Pose2d START_POSE_A = new Pose2d(X_START_POSE_A, Y_START_POSE_A,
                Rotation2d.fromDegrees(ROTATION_START_POSE_A));
        public static final Pose2d START_POSE_B = new Pose2d(9.457, 6.02,
                Rotation2d.fromDegrees(-90));
        public static final Pose2d START_POSE_C = new Pose2d(X_START_POSE_C, Y_START_POSE_C,
                Rotation2d.fromDegrees(ROTATION_START_POSE_C));
        public static final Pose2d START_POSE_D = new Pose2d(X_START_POSE_D, Y_START_POSE_D,
                Rotation2d.fromDegrees(ROTATION_START_POSE_D));
        public static final Pose2d START_POSE_E = new Pose2d(X_START_POSE_E, Y_START_POSE_E,
                Rotation2d.fromDegrees(ROTATION_START_POSE_E));
    }

    public static final class Paths {

        public static final Path METER_FORWARD = new Path(
                List.of(),
                new Pose2d(1, 2, Rotation2d.fromDegrees(0)),
                new MaxVelocityConstraint(2),
                new CentripetalAccelerationConstraint(2)
        );

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
        ).setReversed();

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
                new Pose2d(9.443071650167077, 8.219544642013952, Rotation2d.fromDegrees(-90)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_B),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_B)
        ).setReversed();

        public static final Path PATH_B_SECOND_BALL = new Path(
                List.of(),
                new Pose2d(11.878199878396064, 7.964432847522264, Rotation2d.fromDegrees(0)),
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
        ).setReversed();

        public static final Path PATH_E_FIRST_BALL = new Path(
                List.of(),
                new Pose2d(X_FIRST_BALL_E, Y_FIRST_BALL_E, Rotation2d.fromDegrees(ROTATION_FIRST_BALL_E)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_E),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_E)
        ).setReversed();

        public static final Path PATH_E_ENEMY_BALL = new Path(
                List.of(),
                new Pose2d(X_ENEMY_BALL_E, Y_ENEMY_BALL_E, Rotation2d.fromDegrees(ROTATION_ENEMY_BALL_E)),
                new MaxVelocityConstraint(VELOCITY_CONSTRAINT_E),
                new CentripetalAccelerationConstraint(CENTRIPETAL_ACCELERATION_CONSTRAINT_E)
        );
    }
}
