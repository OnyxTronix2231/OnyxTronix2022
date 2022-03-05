package frc.robot.climber.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.climber.Climber;

    public class WaitUntilClimbedByRightEncoder extends CommandBase {

        private final Climber climber;

        public WaitUntilClimbedByRightEncoder(Climber climber) {
            this.climber = climber;
        }

        @Override
        public boolean isFinished() {
            return climber.isRightEncoderOnTarget();
        }
}
