package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.autonomousPaths.PathBlueCloseClimberTwoBalls;
import frc.robot.drivetrain.commands.ResetOdometryToPose;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.OpenAndIntake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.AutoMoveAndIntake.INTAKE_SPEED_SUPPLIER;

public class BlueCloseClimberTwoBalls extends SequentialCommandGroup {
    public BlueCloseClimberTwoBalls(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                    BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                                    DistanceProvider distanceProvider, AngleProvider angleProvider) {
        PathBlueCloseClimberTwoBalls p = new PathBlueCloseClimberTwoBalls();
        addCommands(
                new ResetOdometryToPose(driveTrain, p.getStartPose()),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, p.getPath(1)),

                new ShootWithDelay(shooter, arc, turret, loader, ballTrigger, distanceProvider, angleProvider)
        );
    }
}
