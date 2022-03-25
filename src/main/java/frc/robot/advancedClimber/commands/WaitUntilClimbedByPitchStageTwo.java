package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;

import java.util.function.DoubleSupplier;

public class WaitUntilClimbedByPitchStageTwo extends CommandBase {

    private final AdvancedClimber advancedClimber;
    private final DoubleSupplier pitchAngleSupplier;

    public WaitUntilClimbedByPitchStageTwo(AdvancedClimber advancedClimber, DoubleSupplier pitchAngleSupplier) {
        this.advancedClimber = advancedClimber;
        this.pitchAngleSupplier = pitchAngleSupplier;
        addRequirements(advancedClimber);
    }

    @Override
    public boolean isFinished() {
        return advancedClimber.isOnDesiredPitchAngleStageTwo(pitchAngleSupplier.getAsDouble());
    }
}
