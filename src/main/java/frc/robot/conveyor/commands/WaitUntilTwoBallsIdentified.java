package frc.robot.conveyor.commands;

import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;

public class WaitUntilTwoBallsIdentified extends WaitUntilCommand {

    public WaitUntilTwoBallsIdentified(Loader loader, BallTrigger ballTrigger) {
        super(() -> ballTrigger.isBallIdentified() && loader.identifiedBall());
    }
}
