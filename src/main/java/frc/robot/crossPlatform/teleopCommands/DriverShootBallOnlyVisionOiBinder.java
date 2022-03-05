package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.providers.AngleVisionProvider;
import frc.robot.providers.DistanceVisionProvider;
import frc.robot.providers.ShootBallConditionalsProviderAndVision;
import frc.robot.providers.ShootBallConditionsProvider;
import frc.robot.shooter.Shooter;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

public class DriverShootBallOnlyVisionOiBinder {

    public DriverShootBallOnlyVisionOiBinder(Shooter shooter, Arc arc, YawControl yawControl, BallTrigger ballTrigger,
                                             Loader loader, Trigger shoot, Vision vision) {
        shoot.whileActiveContinuous(new ShootBallByDistanceAndAngle(shooter, arc, yawControl, loader, ballTrigger,
                new DistanceVisionProvider(vision), new AngleVisionProvider(vision),
                new ShootBallConditionalsProviderAndVision(shooter, yawControl, arc, vision)));
    }
}
