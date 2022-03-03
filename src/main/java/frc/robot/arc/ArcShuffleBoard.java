package frc.robot.arc;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.commands.MoveArcBySpeed;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.arc.commands.MoveArcLowerLimitSwitch;

import static frc.robot.arc.ArcConstants.ArcCalculations.encoderUnitsToAngle;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;

public class ArcShuffleBoard {

    private final Arc arc;
    private final NetworkTableEntry setAngle;
    private final NetworkTableEntry percentageOutput;
    private final NetworkTableEntry kP;
    private final NetworkTableEntry kI;
    private final NetworkTableEntry kD;
    private final NetworkTableEntry kF;
    private final NetworkTableEntry cruiseVel;
    private final NetworkTableEntry acceleration;
    private final NetworkTableEntry accSmoothing;
    private final NetworkTableEntry calibrateSpeed;

    public ArcShuffleBoard(Arc arc) {
        this.arc = arc;

        Shuffleboard.getTab("Arc").addNumber("current encoderUnits pos",
                () -> arc.getComponents().getCounter().getCount());
        Shuffleboard.getTab("Arc").addNumber("current angle",
                () -> encoderUnitsToAngle(arc.getComponents().getCounter().getCount()));
        Shuffleboard.getTab("Arc").addNumber("Current velocity",
                () -> arc.getComponents().getCounter().getRate());

        setAngle = Shuffleboard.getTab("Arc").add("setAngle", ARC_MIN_ANGLE).getEntry();
        percentageOutput = Shuffleboard.getTab("Arc").add("percentageOutput", 0).getEntry();
        calibrateSpeed = Shuffleboard.getTab("Arc").add("calibrateSpeed", 0).getEntry();

        Shuffleboard.getTab("Arc").add("MoveArcBySpeed", new MoveArcBySpeed(arc, () ->
                percentageOutput.getDouble(0)));
        Shuffleboard.getTab("Arc").add("MoveArcToAngle", new MoveArcToAngle(arc,
                () -> setAngle.getDouble(ARC_MIN_ANGLE)));
        Shuffleboard.getTab("Arc").add("MoveArcUntilLimitSwitch", new MoveArcLowerLimitSwitch(arc, () ->
                calibrateSpeed.getDouble(0)));

        kP = Shuffleboard.getTab("Turret").add("set kP",
                arc.getComponents().getController().getPIDFTerms().getKp()).getEntry();
        kI = Shuffleboard.getTab("Turret").add("set kI",
                arc.getComponents().getController().getPIDFTerms().getKi()).getEntry();
        kD = Shuffleboard.getTab("Turret").add("set kD",
                arc.getComponents().getController().getPIDFTerms().getKd()).getEntry();
        kF = Shuffleboard.getTab("Turret").add("set kF",
                arc.getComponents().getController().getPIDFTerms().getKf()).getEntry();
        cruiseVel = Shuffleboard.getTab("Turret").add("set cruiseVel",
                arc.getComponents().getController().getCruiseVelocity()).getEntry();
        acceleration = Shuffleboard.getTab("Turret").add("set acceleration",
                arc.getComponents().getController().getAcceleration()).getEntry();
        accSmoothing = Shuffleboard.getTab("Turret").add("set accSmoothing",
                arc.getComponents().getController().getAccelerationSmoothing()).getEntry();
    }

    public void update() {
        arc.getComponents().getController().setPIDFTerms(
                kP.getDouble(arc.getComponents().getController().getPIDFTerms().getKp()),
                kI.getDouble(arc.getComponents().getController().getPIDFTerms().getKi()),
                kD.getDouble(arc.getComponents().getController().getPIDFTerms().getKd()),
                kF.getDouble(arc.getComponents().getController().getPIDFTerms().getKf()));
        arc.getComponents().getController().setCruiseVelocity(
                (int) cruiseVel.getDouble(ArcConstants.CRUISE_VELOCITY));
        arc.getComponents().getController().setAcceleration(
                (int) acceleration.getDouble(ArcConstants.MAX_ACC));
        arc.getComponents().getController().setAccelerationSmoothing(
                (int) accSmoothing.getDouble(ArcConstants.ACC_SMOOTHING));
    }
}
