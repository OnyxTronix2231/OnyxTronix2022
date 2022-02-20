package frc.robot.conveyor;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;

public class DriverConveyorOiBinder {

    public DriverConveyorOiBinder(Loader loader, BallTrigger ballTrigger, Trigger load){
        load.whileActiveContinuous(new LoadBalls(loader, ballTrigger, ()-> 0.5, ()-> 0.5));
    }
}
