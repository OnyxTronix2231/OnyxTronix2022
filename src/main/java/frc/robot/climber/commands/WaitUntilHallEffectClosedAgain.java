package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import java.util.function.BooleanSupplier;

import static frc.robot.climber.commands.ClimberCommandConstants.CLIMBER_DELAY_TIME;

public class WaitUntilHallEffectClosedAgain extends SequentialCommandGroup {

    public WaitUntilHallEffectClosedAgain(BooleanSupplier isHallEffectClosed) {
        super(new WaitUntilHallEffect( ()-> !isHallEffectClosed.getAsBoolean()),
                new WaitUntilCommand(isHallEffectClosed),
                new WaitCommand(CLIMBER_DELAY_TIME));
    }

}
