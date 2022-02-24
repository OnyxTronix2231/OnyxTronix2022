package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.List;

public class PathCommandsConstants {

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
