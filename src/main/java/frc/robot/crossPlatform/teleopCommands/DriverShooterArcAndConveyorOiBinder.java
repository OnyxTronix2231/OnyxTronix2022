package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;

public class DriverShooterArcAndConveyorOiBinder {

    public DriverShooterArcAndConveyorOiBinder(Loader loader, BallTrigger ballTrigger, Shooter shooter, Arc arc,
                                               Trigger shoot){
        shoot.whileActiveContinuous(new ShootBall(loader, ballTrigger, shooter, arc));
    }
}
