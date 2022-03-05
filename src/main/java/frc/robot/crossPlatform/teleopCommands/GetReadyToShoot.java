package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcByTargetDistance;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.commands.ShootByRPM;
import frc.robot.shooter.commands.ShootByTargetDistance;
import frc.robot.turret.Turret;
import frc.robot.turret.commands.RotateByAngle;
import frc.robot.turret.commands.RotateToAngleRTR;
import frc.robot.turret.commands.SmartRotateByAngle;

import java.util.function.DoubleSupplier;

public class GetReadyToShoot extends ParallelCommandGroup {

    public GetReadyToShoot(Shooter shooter, Arc arc, Turret turret,
                           DoubleSupplier distanceFromTarget, DoubleSupplier angle) {
        super(
                new ShootByRPM(shooter, distanceFromTarget),
                new MoveArcToAngle(arc, distanceFromTarget),
                new SmartRotateByAngle(turret, angle));
    }
}
