package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.stabilizers.Stabilizers;

import java.util.function.IntSupplier;

public class WaitUntilStabilizersOnPositionByEncoder extends CommandBase {

    private final Stabilizers climberStabilizers;
    private final IntSupplier positionSupplier;

    public WaitUntilStabilizersOnPositionByEncoder(Stabilizers climberStabilizers,
                                                   IntSupplier positionInEncoderUnitsSupplier) {
        this.climberStabilizers = climberStabilizers;
        this.positionSupplier = positionInEncoderUnitsSupplier;
    }

    @Override
    public boolean isFinished() {
        return climberStabilizers.isEncoderOnTarget(positionSupplier.getAsInt());
    }
}
