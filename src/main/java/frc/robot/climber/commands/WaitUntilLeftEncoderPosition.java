package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import static frc.robot.climber.commands.ClimberCommandConstants.*;
public class WaitUntilLeftEncoderPosition extends CommandBase {
    private final Climber climber;

    public WaitUntilLeftEncoderPosition(Climber climber) {
        this.climber = climber;
    }

    @Override
    public boolean isFinished() {
        return climber.getLeftEncoderUnits() == DESIRED_ENCODER_UNITS;
    }
}
