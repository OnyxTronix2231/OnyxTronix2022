package frc.robot.stabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;

import java.util.function.IntSupplier;

public class WaitUntilStabilizersOnPositionByEncoderStages extends WaitUntilStabilizersOnPositionByEncoder {

    private final int stage;

    public WaitUntilStabilizersOnPositionByEncoderStages(AdvancedClimber advancedClimber,
                                                   IntSupplier positionInEncoderUnitsSupplier, int stage) {
        super(advancedClimber, positionInEncoderUnitsSupplier);
        this.stage = stage;
    }

    @Override
    public boolean isFinished() {
        return advancedClimber.isEncoderOnTarget(positionSupplier.getAsInt()) || stage != advancedClimber.getStage();
    }

    @Override
    public void end(boolean interrupted) {
        if (stage == advancedClimber.getStage() && advancedClimber.isEncoderOnTarget(positionSupplier.getAsInt())) {
            advancedClimber.setStage(stage + 1);
            System.out.println("Stage" + stage);
        }
    }
}
