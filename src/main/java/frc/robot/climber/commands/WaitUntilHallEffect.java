package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import java.util.function.BooleanSupplier;

public class WaitUntilHallEffect extends WaitUntilCommand {
    public WaitUntilHallEffect(BooleanSupplier isHallEffectClosed){
        super(() -> isHallEffectClosed.getAsBoolean());

    }
}
