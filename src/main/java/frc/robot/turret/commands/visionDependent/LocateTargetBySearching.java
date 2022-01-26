package frc.robot.turret.commands.visionDependent;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.turret.Turret;

public class LocateTargetBySearching extends ConditionalCommand {

    public LocateTargetBySearching(Turret turret, Vision vision) {
        super(new RotateByVision(turret, vision), new RotateToUnseenVision(turret), ()-> vision.hasTarget());
        addRequirements(turret, vision);
    }
}