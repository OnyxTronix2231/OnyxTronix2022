package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import java.util.function.BooleanSupplier;

import static frc.robot.climber.commands.ClimberCommandConstants.CLIMBER_DELAY_TIME;

public class ClimbConditions extends SequentialCommandGroup {

    public ClimbConditions(BooleanSupplier isMicroSwitchOpenSupplier) {
        super(new WaitUntilCommand(() -> !isMicroSwitchOpenSupplier.getAsBoolean()),
                new WaitUntilCommand(isMicroSwitchOpenSupplier), new WaitCommand(CLIMBER_DELAY_TIME));
    }
}
