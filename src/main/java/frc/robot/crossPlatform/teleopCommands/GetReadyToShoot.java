package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.RGB.logicCommands.RGB_DefaultStaticColor;
import frc.robot.RGB.logicCommands.RGB_FoundTarget;
import frc.robot.RGB.logicCommands.RGB_SearchForTarget;
import frc.robot.RGB.logicCommands.RGB_Shooting;
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
import frc.robot.vision.Vision;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class GetReadyToShoot extends ParallelCommandGroup {

    public GetReadyToShoot(Shooter shooter, Arc arc, Turret turret,
                           DoubleSupplier distanceFromTarget, DoubleSupplier angle, BooleanSupplier con) {
        super(
                new ShootByTargetDistance(shooter, distanceFromTarget),
                new MoveArcByTargetDistance(arc, distanceFromTarget),
                new SmartRotateByAngle(turret, angle),
                new ConditionalCommand(new RGB_FoundTarget(), new RGB_SearchForTarget(), ()->
                        Vision.getInstance().hasTarget() || con.getAsBoolean()));
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        CommandScheduler.getInstance().schedule(new RGB_DefaultStaticColor());
    }
}
