package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Logger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;

import static frc.robot.crossPlatform.teleopCommands.TeleopCommandsConstants.*;

public class DriverIntakeAndLoadBallsOiBinder{

    public DriverIntakeAndLoadBallsOiBinder(Intake intake, Loader loader, BallTrigger ballTrigger, Trigger load) {
        load.whileActiveContinuous(new IntakeAndLoadBalls(intake, ballTrigger, loader,
                () -> LOADER_SPEED, () -> BALL_TRIGGER_SPEED, () -> INTAKE_SPEED));
    }
}
