package frc.robot.crossPlatform.teleopCommands.ShootWhileDriving;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.commands.ShootByRPM;
import frc.robot.yawControl.Commands.RotateToAngleRTF;
import frc.robot.yawControl.YawControl;

import static frc.robot.shooter.ShooterConstants.ShooterCalculations.MPSToRPM;

public class ShootWhileDrivingCmd extends ParallelCommandGroup {

    public ShootWhileDrivingCmd(YawControl yawControl, Arc arc, Shooter shooter, ShootWhileDrivingCalc SWDControl) {
        super(
                new RotateToAngleRTF(yawControl, SWDControl::getTurretFixedDirection),
                new ShootByRPM(shooter, () -> 3000),
                new MoveArcToAngle(arc, SWDControl::getArcFixedDirection),
                new ShootByRPM(shooter, () -> MPSToRPM(SWDControl.getShooterFixedSpeedMPS()))
        );
    }
}
