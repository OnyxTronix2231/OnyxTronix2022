package frc.robot.conveyor;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.Loader;

import static frc.robot.conveyor.ConveyorConstant.BALLTRIGGER_CONVEYOR_SPEED;
import static frc.robot.conveyor.ConveyorConstant.LOADER_CONVEYOR_SPEED;

public class DriverConveyorOiBinder {

    public DriverConveyorOiBinder(Loader loader, BallTrigger ballTrigger, Trigger load) {
        load.whileActiveContinuous(new LoadBalls(loader, ballTrigger, () -> LOADER_CONVEYOR_SPEED));
    }
}
