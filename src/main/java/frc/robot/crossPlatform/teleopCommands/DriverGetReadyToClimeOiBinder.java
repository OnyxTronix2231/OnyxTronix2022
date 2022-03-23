package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.intake.Intake;
import frc.robot.stabilizers.Stabilizer;
import frc.robot.turret.Turret;

public class DriverGetReadyToClimeOiBinder {

    public DriverGetReadyToClimeOiBinder(Stabilizer stabilizer, Turret turret, Arc arc, Intake intakeForward, Trigger getReady){
        getReady.whenActive(new GetReadyToClime(stabilizer, turret, arc, intakeForward));
    }
}
