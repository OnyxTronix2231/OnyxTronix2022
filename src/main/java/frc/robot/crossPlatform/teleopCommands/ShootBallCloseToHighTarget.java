package frc.robot.crossPlatform.teleopCommands;

import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

import java.util.function.BooleanSupplier;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.ARC_CLOSE_TO_HIGH_TARGET_ANGLE;
import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.SHOOT_CLOSE_TO_HIGH_TARGET_RPM;

public class ShootBallCloseToHighTarget extends ShootBallByDistanceAndAngle {

    public ShootBallCloseToHighTarget(Shooter shooter, Arc arc, Turret turret, Loader loader, BallTrigger ballTrigger,
                                      BooleanSupplier conditions) {
        super(shooter,arc,turret,loader,ballTrigger,()-> SHOOT_CLOSE_TO_HIGH_TARGET_RPM, () -> ARC_CLOSE_TO_HIGH_TARGET_ANGLE, conditions);
    }
}
