package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;

import java.util.function.DoubleSupplier;

public class IntakeByDriveTrain extends ConditionalCommand {
    public IntakeByDriveTrain(Intake intakeForward, Intake intakeBack, DoubleSupplier speedSupplier, DriveTrain driveTrain) {
        super(new WaitUntilCommand(()->intakeForward.getJoyStickValue() < -0.1)
                        .deadlineWith(new OpenAndIntake(intakeBack, speedSupplier)),
                new WaitUntilCommand(()->intakeBack.getJoyStickValue() > 0.1)
                        .deadlineWith(new OpenAndIntake(intakeForward, speedSupplier)),
                ()->intakeBack.getJoyStickValue()>0.1);
    }
}
