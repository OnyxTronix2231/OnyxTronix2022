package frc.robot.advancedClimber;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class AdvancedClimberShuffleBoard {

    public AdvancedClimberShuffleBoard(AdvancedClimber advancedClimber) {
        Shuffleboard.getTab("Climber").addNumber("current pitch", advancedClimber::getCurrentPitch);
        Shuffleboard.getTab("Climber").addNumber("current yaw", advancedClimber::getCurrentYaw);
        Shuffleboard.getTab("Climber").addNumber("current roll", advancedClimber::getCurrentRoll);
        Shuffleboard.getTab("Climber").addNumber("Current stabilizers encoder units", advancedClimber::getEncoderUnits);
//        Shuffleboard.getTab("Climber").addBoolean("is on desired angle and encoder position",
//                advancedClimber::hasReachedFourthBar);
    }
}
