package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arms.Arms;

import java.util.function.IntSupplier;

public class WaitUntilStabilizersOnDeltaPositionByEncoder extends CommandBase {

    private final IntSupplier positionSupplier;
    private final AdvancedClimber advancedClimber;

    public WaitUntilStabilizersOnDeltaPositionByEncoder(AdvancedClimber advancedClimber, IntSupplier positionInEncoderUnitsSupplier) {
        this.positionSupplier = positionInEncoderUnitsSupplier;
        this.advancedClimber = advancedClimber;
    }

    public void initialize() {
        advancedClimber.initEncoderUnits();
    }

    @Override
    public boolean isFinished() {
        return advancedClimber.isEncoderOnTargetPositive(positionSupplier.getAsInt());
    }
}
