package frc.robot.advancedClimber;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class AdvancedClimberShuffleBoard {

    public AdvancedClimberShuffleBoard(AdvancedClimber advancedClimber) {
        Shuffleboard.getTab("Climber").addNumber("current pitch", advancedClimber::getCurrentPitch);
//        Shuffleboard.getTab("Climber").addBoolean("is on desired angle and encoder position",
//                advancedClimber::hasReachedFourthBar);
    }
}
