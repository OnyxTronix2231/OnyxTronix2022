package frc.robot.arc.commands;

import frc.robot.arc.Arc;

import java.util.function.DoubleSupplier;

public class CalibrateArc extends MoveArcBySpeed {

    private final Arc arc;

    public CalibrateArc(Arc arc, DoubleSupplier calibrateSpeedSupplier) {
        super(arc, calibrateSpeedSupplier);
        this.arc = arc;
        addRequirements(arc);
    }

    @Override
    public void initialize()
    {
        arc.enableSoftLimitSwitch(false);
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
        arc.enableSoftLimitSwitch(true);
        arc.stop();
    }
}
