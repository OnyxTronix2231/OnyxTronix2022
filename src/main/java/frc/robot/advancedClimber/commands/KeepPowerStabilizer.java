package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import java.util.function.DoubleSupplier;

public class KeepPowerStabilizer extends MoveStabilizerBySpeed {

    public KeepPowerStabilizer(AdvancedClimber advancedClimber, DoubleSupplier speedSupplier) {
        super(advancedClimber, speedSupplier);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
