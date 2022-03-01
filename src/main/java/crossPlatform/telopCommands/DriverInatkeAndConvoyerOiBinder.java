package crossPlatform.telopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;

import static crossPlatform.telopCommands.CrossPlatformConstants.*;

public class DriverInatkeAndConvoyerOiBinder {
    public DriverInatkeAndConvoyerOiBinder(Loader loader, BallTrigger ballTrigger, Intake intake, Trigger load) {
        load.whenActive(new MoveIntakeAndConveyor(intake, ballTrigger, loader, () -> LOADER_SPEED,
                () -> BALL_TRIGGER_SPEED, () -> INTAKE_SPEED));
    }
}
