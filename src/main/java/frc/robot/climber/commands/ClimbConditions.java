package frc.robot.climber.commands;

import static frc.robot.climber.commands.ClimberCommandConstants.CLIMBER_DELAY_TIME;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.climber.Climber;
import sensors.Switch.Microswitch;

import java.util.function.BooleanSupplier;

public class ClimbConditions extends SequentialCommandGroup {
    public ClimbConditions(BooleanSupplier isMicroSwitchOpen) {
        super(new WaitUntilCommand(() -> !isMicroSwitchOpen.getAsBoolean()), new WaitUntilCommand(isMicroSwitchOpen),
            new WaitCommand(CLIMBER_DELAY_TIME));
    }
}
