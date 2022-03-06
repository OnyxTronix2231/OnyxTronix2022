package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class DriverShootBallOiBinder {

    public DriverShootBallOiBinder(Shooter shooter, Arc arc, BallTrigger ballTrigger, Loader loader,
                                   Vision vision, YawControl yawControl, DoubleSupplier distanceSupplier, DoubleSupplier angleSupplier,
                                   BooleanSupplier conditionsSupplier, Trigger shoot) {
        shoot.whileActiveContinuous(new ShootBallByDistanceAndAngle(shooter, arc, yawControl, loader, ballTrigger,
                distanceSupplier, angleSupplier, conditionsSupplier));
    }
}
