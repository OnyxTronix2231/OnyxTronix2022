package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

public class WaitUntilStabilizersOnPositionByEncoder extends CommandBase {

    private final Climber climber;
    private final IntSupplier positionSupplier;
    public WaitUntilStabilizersOnPositionByEncoder(Climber climber, IntSupplier positionInEncoderUnitsSupplier) {
        this.climber = climber;
        this.positionSupplier = positionInEncoderUnitsSupplier;
    }

    @Override
    public boolean isFinished() {
        return climber.isStabilizerMotorEncoderOnTarget(positionSupplier.getAsInt());
    }
}
