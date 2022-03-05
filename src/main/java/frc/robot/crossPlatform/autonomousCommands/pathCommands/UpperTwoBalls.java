package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.ShootBallByDistanceAndAngleRTR;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.ResetOdometryToPose;
import frc.robot.intake.Intake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.Paths.*;

public class UpperTwoBalls extends SequentialCommandGroup {

    public UpperTwoBalls(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                         BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                         DistanceProvider distanceProvider, AngleProvider angleProvider) {
        super(
                new ResetOdometryToPose(driveTrain, PathCommandsConstants.StartPoses.START_POSE_B),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, PATH_B_FIRST_BALL),

                new ShootBallByDistanceAndAngleRTR(shooter, arc, turret, loader, ballTrigger, distanceProvider,
                        angleProvider),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, PATH_B_SECOND_BALL),

                new ShootBallByDistanceAndAngleRTR(shooter, arc, turret, loader, ballTrigger, distanceProvider,
                        angleProvider)
        );
    }
}
