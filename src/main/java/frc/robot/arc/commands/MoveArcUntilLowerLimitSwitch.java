package frc.robot.arc.commands;

import frc.robot.arc.Arc;

import static frc.robot.arc.ArcConstants.CALIBRATION_SPEED;

public class MoveArcUntilLowerLimitSwitch extends MoveArcBySpeed {

    private Arc arc;

    public MoveArcUntilLowerLimitSwitch(Arc arc){
        super(arc,()-> CALIBRATION_SPEED);
        this.arc = arc;
    }

    @Override
    public boolean isFinished() {
        return arc.hasHitReverseLimitSwitch();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        if(!interrupted){
            arc.resetEncoderByAbsoluteValue();
        }
    }
}
