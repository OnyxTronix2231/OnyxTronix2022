package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;
import frc.robot.yawControl.YawControl;

public class DriverShootBallBlindOiBinder {

    public DriverShootBallBlindOiBinder(Shooter shooter, Arc arc, YawControl yawControl, BallTrigger ballTrigger, Loader loader, Trigger shoot) {
        shoot.whileActiveContinuous(new ShootBallBlind(shooter, arc, yawControl, loader, ballTrigger, () -> 4000, () -> 20,
                () -> 0));
    }
}
