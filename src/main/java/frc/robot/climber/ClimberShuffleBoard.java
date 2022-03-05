package frc.robot.climber;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.climber.commands.ClimbBySpeed;
import frc.robot.climber.commands.ClosePistons;
import frc.robot.climber.commands.OpenPistons;

import static frc.robot.climber.ClimberConstants.CLOSE_CLIMBER_SPEED;
import static frc.robot.climber.ClimberConstants.OPEN_CLIMBER_SPEED;

public class ClimberShuffleBoard {

    private NetworkTableEntry setSpeed;

    public ClimberShuffleBoard(Climber climber) {
        Shuffleboard.getTab("Climber").addNumber("leftEncoderUnits", climber::getLeftEncoderUnits);
        Shuffleboard.getTab("Climber").addNumber("rightEncoderUnits", climber::getRightEncoderUnits);
        Shuffleboard.getTab("Climber").addBoolean("climber reached fourth bar",
                () -> (climber.isLeftEncoderOnTarget() && climber.isRightEncoderOnTarget()));

        setSpeed = Shuffleboard.getTab("Climber").add("setSpeed", 0).getEntry();

        Shuffleboard.getTab("Climber").add("openPiston", new OpenPistons(climber));
        Shuffleboard.getTab("Climber").add("closePiston", new ClosePistons(climber));
        Shuffleboard.getTab("Climber").add("ClimbBySpeed",
                new ClimbBySpeed(climber, () -> setSpeed.getDouble(0)));
        Shuffleboard.getTab("Climber").add("openClimberArms",
                new ClimbBySpeed(climber, () -> OPEN_CLIMBER_SPEED));
        Shuffleboard.getTab("Climber").add("closeClimberArms",
                new ClimbBySpeed(climber, () -> CLOSE_CLIMBER_SPEED));

    }
}
