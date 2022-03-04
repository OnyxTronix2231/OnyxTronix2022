package frc.robot.turret;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.turret.commands.RotateByAngleOnce;
import frc.robot.turret.commands.RotateByVision;
import frc.robot.vision.Vision;

import static frc.robot.turret.TurretConstants.Calculation.*;

public class TurretShuffleBoard {

    private final TurretComponents components;
    private final NetworkTableEntry kP;
    private final NetworkTableEntry kI;
    private final NetworkTableEntry kD;
    private final NetworkTableEntry kF;
    private final NetworkTableEntry cruiseVel;
    private final NetworkTableEntry acceleration;
    private final NetworkTableEntry accSmoothing;

    public TurretShuffleBoard(Turret turret, TurretComponents components) {
        this.components = components;

            kP = Shuffleboard.getTab("Turret").add("set kP",
                    components.getController().getPIDFTerms().getKp()).getEntry();
            kI = Shuffleboard.getTab("Turret").add("set kI",
                    components.getController().getPIDFTerms().getKi()).getEntry();
            kD = Shuffleboard.getTab("Turret").add("set kD",
                    components.getController().getPIDFTerms().getKd()).getEntry();
            kF = Shuffleboard.getTab("Turret").add("set kF",
                    components.getController().getPIDFTerms().getKf()).getEntry();
            cruiseVel = Shuffleboard.getTab("Turret").add("set cruiseVel",
                    components.getController().getCruiseVelocity()).getEntry();
            acceleration = Shuffleboard.getTab("Turret").add("set acceleration",
                    components.getController().getAcceleration()).getEntry();
            accSmoothing = Shuffleboard.getTab("Turret").add("set accSmoothing",
                    components.getController().getAccelerationSmoothing()).getEntry();

            Shuffleboard.getTab("Turret").addNumber("AngleRTR DEG", turret::getCurrentAngleRTR);
            Shuffleboard.getTab("Turret").addNumber("AngleRTR ENC", () -> components.getMotor().getSelectedSensorPosition());
            Shuffleboard.getTab("Turret").addNumber("DesiredRTR DEG", () ->
                    absoluteEncoderUnitsToDegrees(components.getController().getSetpoint()));
            Shuffleboard.getTab("Turret").addNumber("Motor Speed", ()-> components.getEncoder().getRate());
            Shuffleboard.getTab("Turret").addNumber("DesiredRTR ENC", () ->
                    components.getController().getSetpoint());

            Shuffleboard.getTab("Turret").addNumber("error ENC", () -> (components.getController().getSetpoint() - components.getController().getCurrentError()));
            Shuffleboard.getTab("Turret").addNumber("error DEG", () -> (encoderUnitsToDegrees(components.getController().getCurrentError())));

            Shuffleboard.getTab("Turret").add("move 10", new RotateByAngleOnce(turret, () -> 10 ));
            Shuffleboard.getTab("Turret").add("move 50", new RotateByAngleOnce(turret, () -> 50 ));
            Shuffleboard.getTab("Turret").add("move 90", new RotateByAngleOnce(turret, () -> 90 ));
            Shuffleboard.getTab("Turret").add("move 180", new RotateByAngleOnce(turret, () -> 180 ));
        }

        public void update() {
            components.getController().setPIDFTerms(
                    kP.getDouble(components.getController().getPIDFTerms().getKp()),
                    kI.getDouble(components.getController().getPIDFTerms().getKi()),
                    kD.getDouble(components.getController().getPIDFTerms().getKd()),
                    kF.getDouble(components.getController().getPIDFTerms().getKf()));
            components.getController().setCruiseVelocity(
                    (int) cruiseVel.getDouble(components.getController().getCruiseVelocity()));
            components.getController().setAcceleration(
                    (int) acceleration.getDouble(components.getController().getAcceleration()));
            components.getController().setAccelerationSmoothing(
                    (int) accSmoothing.getDouble(components.getController().getAccelerationSmoothing()));
        }
    }
