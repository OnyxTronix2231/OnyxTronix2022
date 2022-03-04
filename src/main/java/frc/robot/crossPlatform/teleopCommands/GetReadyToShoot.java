package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcByTargetDistance;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.commands.ShootByTargetDistance;
import frc.robot.turret.Turret;
import frc.robot.turret.commands.RotateToAngleRTR;

import java.util.function.DoubleSupplier;

public class GetReadyToShoot extends ParallelDeadlineGroup {

    public GetReadyToShoot(Shooter shooter, Arc arc, Turret turret,
                           DoubleSupplier distanceFromTarget, DoubleSupplier angleRTR) {
        super(
                new ShootByTargetDistance(shooter, distanceFromTarget),
                new MoveArcByTargetDistance(arc, distanceFromTarget),
                new RotateToAngleRTR(turret, angleRTR),
                new WaitUntilReadyToShoot(shooter::isOnTarget, arc::isOnTarget, turret::isOnTarget)
        );
    }
}
