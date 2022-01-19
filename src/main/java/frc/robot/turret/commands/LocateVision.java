package frc.robot.turret.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.turret.Turret;

import java.util.function.BooleanSupplier;

public class LocateVision extends ConditionalCommand {

    public LocateVision(Turret turret, Vision viosion, BooleanSupplier hasTarget) {
        super(new RotateByVision(turret, vision), new RotateToUnseenVision(turret), ()-> vision.hasTarget());
    }

}
