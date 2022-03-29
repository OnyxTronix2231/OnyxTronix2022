package frc.robot.advancedClimber.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.stabilizers.commands.MoveStabilizerUntilOnPosition;

import java.util.function.IntSupplier;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_STABILIZER_SPEED_STAGE_THREE;
import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_STABILIZER_SPEED_STAGE_ZERO;

public class StartClimb extends SequentialCommandGroup {

    public StartClimb(AdvancedClimber advancedClimber, IntSupplier startLoadPosition,
                      IntSupplier startReleasePosition) {
        super(
                new MoveStabilizerUntilOnPosition(advancedClimber, () -> DESIRED_STABILIZER_SPEED_STAGE_THREE, startLoadPosition).withTimeout(0.5),
                new MoveStabilizerUntilOnPosition(advancedClimber, () -> DESIRED_STABILIZER_SPEED_STAGE_ZERO, startReleasePosition)
        );
    }
}
