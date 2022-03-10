package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.ResetOdometryToPose;
import frc.robot.intake.Intake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.Paths.PATH_D_FIRST_BALL;
import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.*;

public class LowOneBall extends SequentialCommandGroup {

    public LowOneBall(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                      BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                      DistanceProvider distanceProvider, AngleProvider angleProvider) {
        super(
                new ResetOdometryToPose(driveTrain, PathCommandsConstants.StartPoses.START_POSE_D),
                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, PATH_D_FIRST_BALL),

                new ShootWithDelay(shooter, arc,turret, loader, ballTrigger, distanceProvider, angleProvider),

                new ResetOdometryToPose(driveTrain, new Pose2d(X_FIRST_BALL_D , Y_FIRST_BALL_D, Rotation2d.fromDegrees(ROTATION_FIRST_BALL_D)))
        );
    }
}
