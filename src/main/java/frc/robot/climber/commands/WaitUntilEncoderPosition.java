package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.climber.Climber;

public class WaitUntilEncoderPosition extends ParallelCommandGroup {

    public WaitUntilEncoderPosition(Climber climber) {
        super(new WaitUntilLeftEncoderPosition(climber), new WaitUntilRightEncoderPosition(climber));
    }
}
