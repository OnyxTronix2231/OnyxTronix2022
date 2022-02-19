package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrain extends ConditionalCommand {
    public IntakeByDriveTrain(Intake intakeForward, Intake intakeBack, DoubleSupplier speedSupplier,
                              DriveTrain driveTrain) {
        super(new OpenAndIntake(intakeForward, speedSupplier)
                        .deadlineWith(new WaitUntilCommand(driveTrain.getDrivingDirection() == reversed)),
                new OpenAndIntake(intakeForward, speedSupplier)
                        .deadlineWith(new WaitUntilCommand(driveTrain.getDrivingDirection() == forward)),
                driveTrain.getDrivingDirection() == forward);
    }
}
