package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;

import java.util.function.DoubleSupplier;

public class WaitUntilClimbedByPitchStageTwo extends CommandBase {

    private final AdvancedClimber advancedClimber;
    private final DoubleSupplier pitchAngleSupplier;
    private final int stage;

    public WaitUntilClimbedByPitchStageTwo(AdvancedClimber advancedClimber, DoubleSupplier pitchAngleSupplier,
                                           int stage) {
        this.advancedClimber = advancedClimber;
        this.pitchAngleSupplier = pitchAngleSupplier;
        this.stage = stage;
        addRequirements(advancedClimber);
    }

    @Override
    public boolean isFinished() {
        return advancedClimber.isOnDesiredPitchAngleStageTwo(pitchAngleSupplier.getAsDouble()) || advancedClimber.getStage() != stage;
    }

    @Override
    public void end(boolean interrupted) {
        if(stage == advancedClimber.getStage() && advancedClimber.isOnDesiredPitchAngleStageTwo(pitchAngleSupplier.getAsDouble()) ) {
            advancedClimber.setStage(stage + 1);
            System.out.println("Stage" + stage);
        }
    }
}
