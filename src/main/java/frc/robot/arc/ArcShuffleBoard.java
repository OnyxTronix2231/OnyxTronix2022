package frc.robot.arc;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.commands.MoveArcBySpeed;
import frc.robot.arc.commands.MoveArcToAngle;

import static frc.robot.arc.ArcConstants.ArcCalculations.linearServoPosToAngle;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;

public class ArcShuffleBoard {

    private final Arc arc;
    private final ArcComponents arcComponents;
    private final NetworkTableEntry setAngle;
    private final NetworkTableEntry percentageOutput;

    public ArcShuffleBoard(Arc arc, ArcComponents arcComponents) {
        this.arc = arc;
        this.arcComponents = arcComponents;

        Shuffleboard.getTab("Arc").addNumber("Angle", () -> linearServoPosToAngle(arcComponents
                .getLinearServo().getPosition()));
        setAngle = Shuffleboard.getTab("Arc").add("setAngle", ARC_MIN_ANGLE).getEntry();
        percentageOutput = Shuffleboard.getTab("Arc").add("precentageOutput", 0).getEntry();
        Shuffleboard.getTab("Arc").add("Move Arc By Speed", new MoveArcBySpeed(arc, ()-> getSpeed()));
        Shuffleboard.getTab("Arc").add("Move Arc To Angle", new MoveArcToAngle(arc, ()-> getAngle()));
    }

    public double getSpeed() {
        return percentageOutput.getDouble(0);
    }

    public double getAngle() {
        return setAngle.getDouble(ARC_MIN_ANGLE);
    }
}
