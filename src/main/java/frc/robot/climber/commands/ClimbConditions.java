package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import java.util.function.BooleanSupplier;

import static frc.robot.climber.commands.ClimberCommandConstants.CLIMBER_DELAY_TIME;

public class ClimbConditions extends SequentialCommandGroup {

    public ClimbConditions(BooleanSupplier isMicroSwitchPressedSupplier) {
        super(new WaitUntilCommand(() -> !isMicroSwitchPressedSupplier.getAsBoolean()),
                new WaitUntilCommand(isMicroSwitchPressedSupplier), new WaitCommand(CLIMBER_DELAY_TIME));
    }
}
