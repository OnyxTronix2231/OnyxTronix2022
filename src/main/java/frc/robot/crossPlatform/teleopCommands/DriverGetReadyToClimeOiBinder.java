package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.intake.Intake;
import frc.robot.turret.Turret;

public class DriverGetReadyToClimeOiBinder {

    public DriverGetReadyToClimeOiBinder(Turret turret, Arc arc, Intake intakeForward, Trigger getReady){
        getReady.whenActive(new GetReadyToClime(turret, arc, intakeForward));
    }
}
