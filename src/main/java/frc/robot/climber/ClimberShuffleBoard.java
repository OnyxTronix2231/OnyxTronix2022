package frc.robot.climber;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.climber.commands.*;

import static frc.robot.climber.ClimberConstants.CLOSE_CLIMBER_SPEED;
import static frc.robot.climber.ClimberConstants.OPEN_CLIMBER_SPEED;

public class ClimberShuffleBoard {

    private final Climber climber;
    private NetworkTableEntry setSpeed;
    private NetworkTableEntry setSpeedLeft;
    private NetworkTableEntry setSpeedRight;

    public ClimberShuffleBoard(Climber climber) {
        this.climber = climber;
    }

    public void init(){
        /*Shuffleboard.getTab("Climber").addNumber("leftEncoderUnits", climber::getLeftEncoderUnits);
        Shuffleboard.getTab("Climber").addNumber("rightEncoderUnits", climber::getRightEncoderUnits);
        Shuffleboard.getTab("Climber").addBoolean("climber reached fourth bar",
                () -> (climber.isLeftEncoderOnTarget() && climber.isRightEncoderOnTarget()));*/

        setSpeed = Shuffleboard.getTab("Climber").add("setSpeed", 0).getEntry();
        setSpeedLeft = Shuffleboard.getTab("Climber").add("setSpeedLeft", 0).getEntry();
        setSpeedRight = Shuffleboard.getTab("Climber").add("setSpeedRight", 0).getEntry();

        //Shuffleboard.getTab("Climber").add("openPiston", new OpenPistons(climber));
        //Shuffleboard.getTab("Climber").add("closePiston", new ClosePistons(climber));

        Shuffleboard.getTab("Climber").add("ClimbBySpeed",
                new ClimbBySpeed(climber, () -> setSpeed.getDouble(0)));

        //Shuffleboard.getTab("Climber").add("openClimberArms",
        //   new ClimbBySpeed(climber, () -> OPEN_CLIMBER_SPEED));
        //Shuffleboard.getTab("Climber").add("closeClimberArms",
        //  new ClimbBySpeed(climber, () -> CLOSE_CLIMBER_SPEED));

        Shuffleboard.getTab("Climber").add("Move Arm Left by Speed", new MoveLeftArmBySpeed(climber,
                () -> setSpeedLeft.getDouble(0)));
        Shuffleboard.getTab("Climber").add("Move Arm Right by Speed", new MoveRightArmBySpeed(climber,
                () -> setSpeedRight.getDouble(0)));

    }
}
