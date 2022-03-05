package frc.robot.arc;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.commands.CalibrateArc;
import frc.robot.arc.commands.MoveArcBySpeed;
import frc.robot.arc.commands.MoveArcToAngle;

import static frc.robot.arc.ArcConstants.ArcCalculations.encoderUnitsToAngle;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;

public class ArcShuffleBoard {

    private final Arc arc;
    private final NetworkTableEntry setAngle;
    private final NetworkTableEntry percentageOutput;
//    private final NetworkTableEntry kP;
//    private final NetworkTableEntry kI;
//    private final NetworkTableEntry kD;
//    private final NetworkTableEntry kF;
//    private final NetworkTableEntry cruiseVel;
//    private final NetworkTableEntry acceleration;
//    private final NetworkTableEntry accSmoothing;

    public ArcShuffleBoard(Arc arc) {
        this.arc = arc;

//        Shuffleboard.getTab("Arc").addNumber("current encoderUnits pos",
//                () -> arc.getComponents().getCounter().getCount());

        Shuffleboard.getTab("Arc").addNumber("current angle",
                () -> encoderUnitsToAngle(arc.getComponents().getCounter().getCount()));

//        Shuffleboard.getTab("Arc").addNumber("Current velocity",
//                () -> arc.getComponents().getCounter().getRate());

//        Shuffleboard.getTab("Arc").addNumber("Current error enc",
//                () -> arc.getComponents().getController().getCurrentError());

        Shuffleboard.getTab("Arc").addNumber("Current error angle",
                () -> encoderUnitsToAngle(arc.getComponents().getController().getCurrentError()) - ARC_MIN_ANGLE);

        setAngle = Shuffleboard.getTab("Arc").add("setAngle", ARC_MIN_ANGLE).getEntry();
        percentageOutput = Shuffleboard.getTab("Arc").add("percentageOutput", 0).getEntry();

        Shuffleboard.getTab("Arc").add("MoveArcBySpeed", new MoveArcBySpeed(arc, () ->
                percentageOutput.getDouble(0)));
//        Shuffleboard.getTab("Arc").add("MoveTo30", new MoveArcToAngle(arc,
//                () -> 30));
//
        Shuffleboard.getTab("Arc").add("Calibrate", new CalibrateArc(arc, ()-> 0.2));
//        Shuffleboard.getTab("Arc").add("MoveTo45", new MoveArcToAngle(arc,
//                () -> 45));
//
//        Shuffleboard.getTab("Arc").add("MoveTo60", new MoveArcToAngle(arc,
//                () -> 60));

        Shuffleboard.getTab("Arc").add("MoveArcToAngle", new MoveArcToAngle(arc,
                () -> setAngle.getDouble(ARC_MIN_ANGLE)));

//        kP = Shuffleboard.getTab("Arc").add("set kP",
//                arc.getComponents().getController().getPIDFTerms().getKp()).getEntry();
//        kI = Shuffleboard.getTab("Arc").add("set kI",
//                arc.getComponents().getController().getPIDFTerms().getKi()).getEntry();
//        kD = Shuffleboard.getTab("Arc").add("set kD",
//                arc.getComponents().getController().getPIDFTerms().getKd()).getEntry();
//        kF = Shuffleboard.getTab("Arc").add("set kF",
//                arc.getComponents().getController().getPIDFTerms().getKf()).getEntry();
//        cruiseVel = Shuffleboard.getTab("Arc").add("set cruiseVel",
//                arc.getComponents().getController().getCruiseVelocity()).getEntry();
//        acceleration = Shuffleboard.getTab("Arc").add("set acceleration",
//                arc.getComponents().getController().getAcceleration()).getEntry();
//        accSmoothing = Shuffleboard.getTab("Arc").add("set accSmoothing",
//                arc.getComponents().getController().getAccelerationSmoothing()).getEntry();
    }

    public void update() {
//        arc.getComponents().getController().setPIDFTerms(
//                kP.getDouble(arc.getComponents().getController().getPIDFTerms().getKp()),
//                kI.getDouble(arc.getComponents().getController().getPIDFTerms().getKi()),
//                kD.getDouble(arc.getComponents().getController().getPIDFTerms().getKd()),
//                kF.getDouble(arc.getComponents().getController().getPIDFTerms().getKf()));
//        arc.getComponents().getController().setCruiseVelocity(
//                (int) cruiseVel.getDouble(ArcConstants.CRUISE_VELOCITY));
//        arc.getComponents().getController().setAcceleration(
//                (int) acceleration.getDouble(ArcConstants.MAX_ACC));
//        arc.getComponents().getController().setAccelerationSmoothing(
//                (int) accSmoothing.getDouble(ArcConstants.ACC_SMOOTHING));
    }
}
