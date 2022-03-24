package frc.robot.arms;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arms.commands.MoveArmsBySpeed;

public class ArmsShuffleBoard {

    private final Arms arms;
    private NetworkTableEntry setSpeed;
    private NetworkTableEntry setSpeedLeft;
    private NetworkTableEntry setSpeedRight;

    public ArmsShuffleBoard(Arms arms) {
        this.arms = arms;
        init();
    }

    public void init() {
        Shuffleboard.getTab("Climber").addNumber("leftEncoderUnits", arms::getArmsEncoderUnits);

        setSpeed = Shuffleboard.getTab("Climber").add("set arms speed", 0).getEntry();

        //Shuffleboard.getTab("Climber").add("openPiston", new OpenPistons(climber));
        //Shuffleboard.getTab("Climber").add("closePiston", new ClosePistons(climber));

        Shuffleboard.getTab("Climber").add("Move Arms by Speed", new MoveArmsBySpeed(arms,
                () -> setSpeedLeft.getDouble(0)));

    }
}
