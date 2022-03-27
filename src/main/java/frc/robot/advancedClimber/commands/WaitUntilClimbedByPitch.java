package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;

import java.util.function.DoubleSupplier;

public class WaitUntilClimbedByPitch extends CommandBase {

    protected final AdvancedClimber advancedClimber;
    protected final DoubleSupplier pitchAngleSupplier;

    public WaitUntilClimbedByPitch(AdvancedClimber advancedClimber, DoubleSupplier pitchAngleSupplier) {
        this.advancedClimber = advancedClimber;
        this.pitchAngleSupplier = pitchAngleSupplier;
        addRequirements(advancedClimber);
    }

    @Override
    public boolean isFinished() {
        return advancedClimber.isOnDesiredPitchAngle(pitchAngleSupplier.getAsDouble());
    }
}
