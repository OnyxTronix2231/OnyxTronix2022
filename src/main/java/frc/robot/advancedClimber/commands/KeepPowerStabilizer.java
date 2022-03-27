package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.providers.ButtonProvider;
import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;

import java.util.function.DoubleSupplier;

public class KeepPowerStabilizer extends MoveStabilizerBySpeed {

    private final ButtonProvider buttonProvider;

    public KeepPowerStabilizer(AdvancedClimber advancedClimber, DoubleSupplier speedSupplier, ButtonProvider buttonProvider) {
        super(advancedClimber, speedSupplier);
        this.buttonProvider = buttonProvider;
    }

    @Override
    public boolean isFinished() {
        return buttonProvider.getClickedRelease();
    }
}
