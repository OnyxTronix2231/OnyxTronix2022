package frc.robot.arms;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arms.commands.MoveArmsBySpeed;

public class ArmsShuffleBoard {

    private final Arms climber;
    private NetworkTableEntry setSpeed;
    private NetworkTableEntry setSpeedLeft;
    private NetworkTableEntry setSpeedRight;

    public ArmsShuffleBoard(Arms climber) {
        this.climber = climber;
    }

    public void init() {
        /*Shuffleboard.getTab("Climber").addNumber("leftEncoderUnits", climber::getLeftEncoderUnits);
        Shuffleboard.getTab("Climber").addNumber("rightEncoderUnits", climber::getRightEncoderUnits);
        Shuffleboard.getTab("Climber").addBoolean("climber reached fourth bar",
                () -> (climber.isLeftEncoderOnTarget() && climber.isRightEncoderOnTarget()));*/

        setSpeed = Shuffleboard.getTab("Climber").add("setSpeed", 0).getEntry();
        setSpeedLeft = Shuffleboard.getTab("Climber").add("setSpeedLeft", 0).getEntry();
        setSpeedRight = Shuffleboard.getTab("Climber").add("setSpeedRight", 0).getEntry();

        //Shuffleboard.getTab("Climber").add("openPiston", new OpenPistons(climber));
        //Shuffleboard.getTab("Climber").add("closePiston", new ClosePistons(climber));


        Shuffleboard.getTab("Climber").add("Move Arms by Speed", new MoveArmsBySpeed(climber,
                () -> setSpeedLeft.getDouble(0)));

    }
}
