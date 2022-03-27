package frc.robot.advancedClimber;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.advancedClimber.commands.AutoClimb;
import frc.robot.arms.Arms;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class AdvancedClimberShuffleBoard {

    public AdvancedClimberShuffleBoard(AdvancedClimber advancedClimber, Arms arms) {
        Shuffleboard.getTab("Climber").addNumber("current pitch", advancedClimber::getCurrentPitch);
        Shuffleboard.getTab("Climber").addNumber("current yaw", advancedClimber::getCurrentYaw);
        Shuffleboard.getTab("Climber").addNumber("current roll", advancedClimber::getCurrentRoll);
        Shuffleboard.getTab("Climber").addNumber("Current stabilizers encoder units", advancedClimber::getEncoderUnits);
        Shuffleboard.getTab("Climber").addNumber("leftEncoderUnits", arms::getArmsEncoderUnits);
        //Shuffleboard.getTab("Climber").add(new AutoClimb(advancedClimber,arms, vision, desiredPitchAngle, desiredPitchAngle));
//        Shuffleboard.getTab("Climber").addBoolean("is on desired angle and encoder position",
//                advancedClimber::hasReachedFourthBar);
    }
}
