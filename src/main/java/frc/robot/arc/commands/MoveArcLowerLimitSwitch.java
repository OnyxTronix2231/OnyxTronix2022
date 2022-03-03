package frc.robot.arc.commands;

import frc.robot.arc.Arc;

import java.util.function.DoubleSupplier;

import static frc.robot.arc.ArcConstants.CALIBRATION_SPEED;

public class MoveArcLowerLimitSwitch extends MoveArcBySpeed {

    private final Arc arc;

    public MoveArcLowerLimitSwitch(Arc arc, DoubleSupplier calibrateSpeedSupplier) {
        super(arc, calibrateSpeedSupplier);
        this.arc = arc;
        addRequirements(arc);
    }

    @Override
    public boolean isFinished() {
        return arc.hasHitReverseMicroSwitch();
    }

    @Override
    public void end(boolean interrupted) {
        if (!interrupted) {
            arc.resetEncoderByAbsoluteValue();
        }
        arc.stop();
    }
}
