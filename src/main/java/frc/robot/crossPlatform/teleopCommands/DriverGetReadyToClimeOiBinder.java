package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arc.Arc;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;
import frc.robot.stabilizers.Stabilizer;
import frc.robot.turret.Turret;

import java.util.function.IntSupplier;

public class DriverGetReadyToClimeOiBinder {

    public DriverGetReadyToClimeOiBinder(AdvancedClimber advancedClimber, Turret turret, Arc arc, Intake intakeForward,
                                         Trigger getReady) {
        getReady.whenActive(new GetReadyToClime(advancedClimber, turret, arc, intakeForward));
    }
}
