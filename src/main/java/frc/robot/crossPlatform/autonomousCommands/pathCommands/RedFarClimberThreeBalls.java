package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.autonomousPaths.PathRedFarClimberThreeBalls;
import frc.robot.intake.Intake;
import frc.robot.shooter.Shooter;
import frc.robot.yawControl.YawControl;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class RedFarClimberThreeBalls extends SequentialCommandGroup {

    public RedFarClimberThreeBalls(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                   BallTrigger ballTrigger, YawControl turret, Shooter shooter, Arc arc,
                                   DoubleSupplier distanceProvider, DoubleSupplier angleProvider,
                                   BooleanSupplier shooterConditions) {
        PathRedFarClimberThreeBalls p = new PathRedFarClimberThreeBalls();
        addCommands(
                new RedFarClimberTwoBalls(driveTrain, frontIntake, backIntake, loader,
                        ballTrigger, turret, shooter, arc, distanceProvider, angleProvider,
                        shooterConditions),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, p.getPath(1)),

                new AutoMoveAndIntakeAndTurret(driveTrain, frontIntake, backIntake, loader, ballTrigger, turret,
                        angleProvider, p.getPath(2)),

                new ShootWithDelay(shooter, arc, turret, loader, ballTrigger, distanceProvider,
                        angleProvider, shooterConditions)
        );
    }
}
