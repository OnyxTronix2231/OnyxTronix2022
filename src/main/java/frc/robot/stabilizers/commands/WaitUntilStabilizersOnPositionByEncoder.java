package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.stabilizers.Stabilizer;

import java.util.function.IntSupplier;

public class WaitUntilStabilizersOnPositionByEncoder extends CommandBase {

    private final Stabilizer climberStabilizer;
    private final IntSupplier positionSupplier;

    public WaitUntilStabilizersOnPositionByEncoder(Stabilizer climberStabilizer,
                                                   IntSupplier positionInEncoderUnitsSupplier) {
        this.climberStabilizer = climberStabilizer;
        this.positionSupplier = positionInEncoderUnitsSupplier;
    }

    @Override
    public boolean isFinished() {
        return climberStabilizer.isEncoderOnTarget(positionSupplier.getAsInt());
    }
}
