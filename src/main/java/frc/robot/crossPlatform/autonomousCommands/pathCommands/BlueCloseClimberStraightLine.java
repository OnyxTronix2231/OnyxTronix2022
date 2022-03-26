package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.autonomousPaths.PathBlueCloseClimberStraightLine;
import frc.robot.drivetrain.commands.ResetOdometryToPose;
import frc.robot.intake.Intake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.yawControl.YawControl;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class BlueCloseClimberStraightLine extends SequentialCommandGroup {
    public BlueCloseClimberStraightLine(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                        BallTrigger ballTrigger, YawControl turret, Shooter shooter, Arc arc,
                                        DoubleSupplier distanceProvider, DoubleSupplier angleProvider,
                                        BooleanSupplier shooterConditions) {
        PathBlueCloseClimberStraightLine p = new PathBlueCloseClimberStraightLine();
        addCommands(
                new ResetOdometryToPose(driveTrain, p.getStartPose()),

                new AutoMoveAndIntake(driveTrain, frontIntake, backIntake, loader, ballTrigger, p.getPath(1)),

                new ShootWithDelay(shooter, arc, turret, loader, ballTrigger, distanceProvider, angleProvider,
                        shooterConditions)
        );
    }
}
