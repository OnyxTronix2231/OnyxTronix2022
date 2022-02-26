package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

import static frc.robot.climber.commands.ClimberCommandConstants.DESIRED_ENCODER_UNITS;

    public class WaitUntilRightEncoderPosition extends CommandBase {
        private final Climber climber;

        public WaitUntilRightEncoderPosition(Climber climber) {
            this.climber = climber;
        }

        @Override
        public boolean isFinished() {
            return climber.getRightEncoderUnits() == DESIRED_ENCODER_UNITS;
        }
}
