package frc.robot.crossPlatform.teleopCommands.ShootWhileDriving;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.commands.MoveConveyor;
import frc.robot.conveyor.loader.Loader;

public class LoadBallsOiBinder {

    public LoadBallsOiBinder(BallTrigger ballTrigger, Loader loader, Trigger loadTriger) {
        loadTriger.whileActiveContinuous(new MoveConveyor(loader, ballTrigger, () -> 0.5, () ->5));
    }


}
