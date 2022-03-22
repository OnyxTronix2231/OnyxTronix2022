package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.autonomousPaths.PathRedCloseClimberTwoBalls;
import frc.robot.drivetrain.commands.DriveBySpeed;
import frc.robot.drivetrain.commands.ResetOdometryToPose;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenAndIntake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.AutoMoveAndIntake.INTAKE_SPEED_SUPPLIER;
import static frc.robot.crossPlatform.autonomousCommands.pathCommands.AutonomousConstants.RESET_TIME_DELAY;


public class RedCloseClimberTwoBalls extends SequentialCommandGroup {

    public RedCloseClimberTwoBalls(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                   BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                                   DistanceProvider distanceProvider, AngleProvider angleProvider) {
        PathRedCloseClimberTwoBalls p = new PathRedCloseClimberTwoBalls();
        addCommands(
                new ResetOdometryToPose(driveTrain, p.getStartPose()),

                new WaitCommand(RESET_TIME_DELAY),

                //new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, p.getPath(1)),

                new ShootWithDelay(shooter, arc, turret, loader, ballTrigger, distanceProvider,
                        angleProvider),

                (new DriveBySpeed(driveTrain, ()-> 0.5, ()-> 0).alongWith(
                        new OpenAndIntake(backIntake, ()-> 0.8))).withTimeout(2.5),

                new ShootWithDelay(shooter, arc, turret, loader, ballTrigger, distanceProvider, angleProvider)
        );
    }
}

