package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.turret.Turret;

public class LocateVision extends ConditionalCommand {

    public LocateVision(Turret turret, Vision vision) {
        super(new RotateByVision(turret, vision), new RotateToUnseenVision(turret), ()-> vision.hasTarget());
    }
}
