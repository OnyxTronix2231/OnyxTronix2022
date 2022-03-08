package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.Paths.*;

public class UpperFourBalls extends SequentialCommandGroup {
    public UpperFourBalls(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                          BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                          DistanceProvider distanceProvider, AngleProvider angleProvider) {
        super(
                new UpperThreeBalls(driveTrain, frontIntake, backIntake, loader,
                        ballTrigger, turret, shooter, arc, distanceProvider, angleProvider),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, PATH_B_THIRD_BALL),

                new WaitCommand(0.3),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, PATH_B_SHOOTING_PLACE),

                new ShootWithDelay(shooter, arc, turret, loader, ballTrigger, distanceProvider,
                        angleProvider));
    }
}
