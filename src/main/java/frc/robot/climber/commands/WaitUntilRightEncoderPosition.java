package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

    public class WaitUntilRightEncoderPosition extends CommandBase {

        private final Climber climber;

        public WaitUntilRightEncoderPosition(Climber climber) {
            this.climber = climber;
        }

        @Override
        public boolean isFinished() {
            return climber.isRightEncoderOnTarget();
        }
}
