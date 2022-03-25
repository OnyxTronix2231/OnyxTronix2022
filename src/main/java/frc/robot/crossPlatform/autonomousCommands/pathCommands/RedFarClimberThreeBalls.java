package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.GetReadyToShoot;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.autonomousPaths.PathRedFarClimberThreeBalls;
import frc.robot.intake.Intake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.yawControl.YawControl;


public class RedFarClimberThreeBalls extends SequentialCommandGroup {

    public RedFarClimberThreeBalls(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                   BallTrigger ballTrigger, YawControl turret, Shooter shooter, Arc arc,
                                   DistanceProvider distanceProvider, AngleProvider angleProvider, AngleProvider turretAngleProvider) {
        PathRedFarClimberThreeBalls p = new PathRedFarClimberThreeBalls();
        addCommands(
                new RedFarClimberTwoBalls(driveTrain, frontIntake, backIntake, loader,
                        ballTrigger, turret, shooter, arc, distanceProvider, angleProvider, turretAngleProvider ),

                new AutoMoveAndIntakeAndTurret(driveTrain, frontIntake, backIntake, loader, ballTrigger, turret, turretAngleProvider, p.getPath(1)),

                new ShootWithDelay(shooter, arc, turret, loader, ballTrigger, distanceProvider,
                        angleProvider)
        );
    }
}
