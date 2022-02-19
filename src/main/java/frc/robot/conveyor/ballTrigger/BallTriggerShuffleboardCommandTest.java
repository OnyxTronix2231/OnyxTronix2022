package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;
import frc.robot.intake.Intake;
import frc.robot.intake.commands.ClosePiston;
import frc.robot.intake.commands.IntakeBySpeed;
import frc.robot.intake.commands.OpenPiston;

public class BallTriggerShuffleboardCommandTest {

    public BallTriggerShuffleboardCommandTest(BallTrigger ballTrigger) {

        var ballTriggerSpeed  = Shuffleboard.getTab("ballTrigger").add("ballTrigger-speed",
                0.0).getEntry();
        Shuffleboard.getTab("ballTrigger").add(new MoveBallTriggerBySpeed(ballTrigger,
                ()->ballTriggerSpeed.getDouble(0)));
    }
}
