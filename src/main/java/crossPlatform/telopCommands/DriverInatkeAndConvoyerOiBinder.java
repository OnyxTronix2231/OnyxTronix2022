package crossPlatform.telopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class DriverInatkeAndConvoyerOiBinder {
    public DriverInatkeAndConvoyerOiBinder(Loader loader, BallTrigger ballTrigger, Intake intake, Trigger load) {
        load.whenActive(new MoveIntakeAndConveyor(intake, ballTrigger, loader));
    }
}
