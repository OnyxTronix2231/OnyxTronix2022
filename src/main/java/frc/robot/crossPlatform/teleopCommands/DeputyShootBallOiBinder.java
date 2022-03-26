package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

public class DeputyShootBallOiBinder {

    public DeputyShootBallOiBinder(DriveTrain driveTrain, Shooter shooter, Arc arc, Loader loader, BallTrigger ballTrigger,
                                   Vision vision, Turret turret, Trigger shootToEjectEnemyBalls,
                                   Trigger shootByVision) {
        shootToEjectEnemyBalls.whileActiveContinuous(new EjectEnemyBall(shooter, arc, loader, ballTrigger));
        shootByVision.whileActiveContinuous(new ShootByVision(shooter, arc, turret, loader, ballTrigger, vision,
                driveTrain));
    }
}
