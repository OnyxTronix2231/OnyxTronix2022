package frc.robot.ClimberStabilizers.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ClimberStabilizers.ClimberStabilizers;
import frc.robot.climberArms.ClimberArms;

import java.util.function.IntSupplier;

public class WaitUntilStabilizersOnPositionByEncoder extends CommandBase {

    private final ClimberStabilizers climberStabilizers;
    private final IntSupplier positionSupplier;

    public WaitUntilStabilizersOnPositionByEncoder(ClimberStabilizers climberStabilizers,
                                                   IntSupplier positionInEncoderUnitsSupplier) {
        this.climberStabilizers = climberStabilizers;
        this.positionSupplier = positionInEncoderUnitsSupplier;
    }

    @Override
    public boolean isFinished() {
        return climberStabilizers.isStabilizerMotorEncoderOnTarget(positionSupplier.getAsInt());
    }
}
