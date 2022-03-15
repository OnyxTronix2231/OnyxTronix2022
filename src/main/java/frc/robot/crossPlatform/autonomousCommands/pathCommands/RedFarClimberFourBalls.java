package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.autonomousPaths.PathRedFarClimberFourBalls;
import frc.robot.intake.Intake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

public class RedFarClimberFourBalls extends SequentialCommandGroup {

    public RedFarClimberFourBalls(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                   BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                                   DistanceProvider distanceProvider, AngleProvider angleProvider) {
        PathRedFarClimberFourBalls p = new PathRedFarClimberFourBalls();
        addCommands(
                new RedFarClimberThreeBalls(driveTrain, frontIntake, backIntake, loader, ballTrigger, turret, shooter,
                        arc, distanceProvider, angleProvider),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, p.getPath(1)),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, p.getPath(2)),

                new ShootWithDelay(shooter, arc, turret, loader, ballTrigger, distanceProvider, angleProvider)
        );
    }
}
