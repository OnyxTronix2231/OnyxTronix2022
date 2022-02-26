package frc.robot.arc;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.commands.MoveArcBySpeed;
import frc.robot.arc.commands.MoveArcToAngle;

import static frc.robot.arc.ArcConstants.ArcCalculations.linearServoPosToAngle;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;

public class ArcShuffleBoard {

    private final NetworkTableEntry setAngle;
    private final NetworkTableEntry percentageOutput;

    public ArcShuffleBoard(Arc arc, ArcComponents arcComponents) {
        
        Shuffleboard.getTab("Arc").addNumber("Angle", () -> linearServoPosToAngle(arcComponents
                .getLinearServo().getPosition()));
        setAngle = Shuffleboard.getTab("Arc").add("setAngle", ARC_MIN_ANGLE).getEntry();
        percentageOutput = Shuffleboard.getTab("Arc").add("percentageOutput", 0).getEntry();
        Shuffleboard.getTab("Arc").add("MoveArcBySpeed", new MoveArcBySpeed(arc, this::getSpeed));
        Shuffleboard.getTab("Arc").add("MoveArcToAngle", new MoveArcToAngle(arc, this::getAngle));
    }

    public double getSpeed() {
        return percentageOutput.getDouble(0);
    }

    public double getAngle() {
        return setAngle.getDouble(ARC_MIN_ANGLE);
    }
}
