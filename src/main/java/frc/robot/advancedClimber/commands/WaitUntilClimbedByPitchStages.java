package frc.robot.advancedClimber.commands;

import frc.robot.advancedClimber.AdvancedClimber;

import java.util.function.DoubleSupplier;

public class WaitUntilClimbedByPitchStages extends WaitUntilClimbedByPitch {

    private final int stage;

    public WaitUntilClimbedByPitchStages(AdvancedClimber advancedClimber, DoubleSupplier pitchAngleSupplier, int stage) {
        super(advancedClimber, pitchAngleSupplier);
        this.stage = stage;
    }

    @Override
    public boolean isFinished() {
        return super.isFinished() || stage != advancedClimber.getStage();
    }

    @Override
    public void end(boolean interrupted) {
        if(stage == advancedClimber.getStage() && advancedClimber.isOnDesiredPitchAngle(pitchAngleSupplier.getAsDouble())) {
            advancedClimber.setStage(stage + 1);
            System.out.println("Stage" + stage);
        }
    }
}
