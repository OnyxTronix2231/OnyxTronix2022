package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import java.util.function.BooleanSupplier;

public class WaitUntilHallEffectConditional extends ConditionalCommand {
    public WaitUntilHallEffectConditional(BooleanSupplier isHallEffectClosed, boolean isInner) {
        super(new WaitUntilHallEffectOpenedAgain(isHallEffectClosed),
                new WaitUntilHallEffect(isHallEffectClosed), ()->isInner);
    }
}
