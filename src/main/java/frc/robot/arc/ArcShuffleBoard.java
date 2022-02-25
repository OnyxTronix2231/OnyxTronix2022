package frc.robot.arc;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.commands.MoveArcBySpeed;
import frc.robot.arc.commands.MoveArcToAngle;

import java.util.function.DoubleSupplier;

import static frc.robot.arc.ArcConstants.ArcCalculations.linearServoPosToAngle;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;

public class ArcShuffleBoard {

    private final Arc arc;
    private NetworkTableEntry setAngle;
    private NetworkTableEntry percentageOutput;
    private DoubleSupplier speed;
    private DoubleSupplier angle;

    public ArcShuffleBoard(Arc arc) {
        this.arc = arc;
    }

    public void init() {
        Shuffleboard.getTab("Arc").addNumber("Angle", () -> linearServoPosToAngle(arc.getCurrentPos()));
        setAngle = Shuffleboard.getTab("Arc").add("setAngle", ARC_MIN_ANGLE).getEntry();
        angle = ()->setAngle.getDouble(ARC_MIN_ANGLE);
        percentageOutput = Shuffleboard.getTab("Arc").add("percentageOutput", 0).getEntry();
        speed = ()->percentageOutput.getDouble(0);
        Shuffleboard.getTab("Arc").add("MoveArcBySpeed", new MoveArcBySpeed(arc, speed));
        Shuffleboard.getTab("Arc").add("MoveArcToAngle", new MoveArcToAngle(arc, angle));
    }

}
