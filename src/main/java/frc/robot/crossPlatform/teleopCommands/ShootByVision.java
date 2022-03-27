package frc.robot.crossPlatform.teleopCommands;

import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.providers.AngleProviderByVision;
import frc.robot.providers.DistanceProviderByVision;
import frc.robot.providers.ShootBallConditionalsWithVisionProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

public class ShootByVision extends ShootBallByDistanceAndAngle {

    public ShootByVision(Shooter shooter, Arc arc, Turret turret, Loader loader, BallTrigger ballTrigger,
                         DriveTrain driveTrain) {
        super(shooter, arc, turret, loader, ballTrigger,
                new DistanceProviderByVision(),
                new AngleProviderByVision(),
                new ShootBallConditionalsWithVisionProvider(shooter, turret, arc, driveTrain));
    }
}
