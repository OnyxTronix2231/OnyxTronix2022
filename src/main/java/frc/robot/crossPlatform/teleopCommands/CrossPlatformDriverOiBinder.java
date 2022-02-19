package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.intake.Intake;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.ballTrigger.BallTrigger;

import static frc.robot.crossPlatform.teleopCommands.CrossPlatformConstants.LOADER_SPEED;
import static frc.robot.crossPlatform.teleopCommands.CrossPlatformConstants.TRIGGER_SPEED;

public class CrossPlatformDriverOiBinder {
    public CrossPlatformDriverOiBinder(Loader loader, BallTrigger ballTrigger, Intake intake, Trigger intakeAndConveyor){
        intakeAndConveyor.whileActiveContinuous(new LoadBalls(ballTrigger,loader,()-> LOADER_SPEED, ()->TRIGGER_SPEED));
    }
}
