package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.stabilizers.Stabilizer;

import java.util.function.IntSupplier;

public class WaitUntilStabilizersOnPositionByEncoder extends CommandBase {

    protected final AdvancedClimber advancedClimber;
    protected final IntSupplier positionSupplier;

    public WaitUntilStabilizersOnPositionByEncoder(AdvancedClimber advancedClimber,
                                                   IntSupplier positionInEncoderUnitsSupplier) {
        this.advancedClimber = advancedClimber;
        this.positionSupplier = positionInEncoderUnitsSupplier;
    }

    @Override
    public boolean isFinished() {
        return advancedClimber.isEncoderOnTarget(positionSupplier.getAsInt());
    }
}
