package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.climber.Climber;

import java.util.function.DoubleSupplier;

public class ClimbUntilEncoderPosition extends ParallelDeadlineGroup {

    public ClimbUntilEncoderPosition(Climber climber, DoubleSupplier speedSupplier) {
        super(new WaitUntilEncoderPosition(climber), new ClimbBySpeed(climber, speedSupplier));
    }
}
