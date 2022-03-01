package frc.robot.arc.commands;

import frc.robot.arc.Arc;

import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;

public class CloseArc extends MoveArcToAngle{

    private Arc arc;

    public CloseArc(Arc arc){
        super(arc,()-> ARC_MIN_ANGLE);
        this.arc = arc;
    }

}
