package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.*;

public class BallTriggerShuffleboard {

    private NetworkTableEntry ballInPlaceValueEntry;
    private NetworkTableEntry identifiedBallValueEntry;
    private NetworkTableEntry ballInPlaceValueEntryV2;
    private NetworkTableEntry identifiedBallValueEntryV2;
    private NetworkTableEntry isRedEntry;
    private NetworkTableEntry isBlueEntry;

    private final BallTrigger ballTrigger;
    private SendableChooser<String> isOurBall;

    public BallTriggerShuffleboard(BallTrigger ballTrigger) {
        this.ballTrigger = ballTrigger;
        isOurBall = new SendableChooser<>();
    }

    public void init() {
        //    ballInPlaceValueEntry = Shuffleboard.getTab("BallTrigger").add("InPlaceValue",
        //            INPLACE_DISTANCE_MM).getEntry();
        //    identifiedBallValueEntry = Shuffleboard.getTab("BallTrigger").add("IdentifiedValue",
        //            IDENTIFIED_DISTANCE_MM).getEntry();

        ballInPlaceValueEntryV2 = Shuffleboard.getTab("BallTrigger").add("InPlaceValueV2",
                INPLACE_DISTANCE_COLOR).getEntry();
        identifiedBallValueEntryV2 = Shuffleboard.getTab("BallTrigger").add("IdentifiedValueV2",
                IDENTIFIED_DISTANCE_ANALOG).getEntry();

        isRedEntry = Shuffleboard.getTab("BallTrigger").add("isRedValue",
                THRESHOLD_REDNESS).getEntry();
        isBlueEntry = Shuffleboard.getTab("BallTrigger").add("isBlueValue",
                THRESHOLD_BLUENESS).getEntry();

        NetworkTableEntry ballTriggerSpeed = Shuffleboard.getTab("BallTrigger").add("BallTriggerSpeed",
                BALLTRIGGER_SPEED).getEntry();
        Shuffleboard.getTab("BallTrigger").add(new MoveBallTriggerBySpeed(ballTrigger,
                () -> ballTriggerSpeed.getDouble(BALLTRIGGER_SPEED)));


        //Shuffleboard.getTab("BallTrigger").addNumber("DistanceDigital", ballTrigger::getDistance);
        //Shuffleboard.getTab("BallTrigger").addBoolean("IsBallIdentify", ballTrigger::isBallIdentified);
        //Shuffleboard.getTab("BallTrigger").addBoolean("IsBallInPlace", ballTrigger::isBallInPlace);
        Shuffleboard.getTab("BallTrigger").addNumber("getRed", ballTrigger::getRed);
        Shuffleboard.getTab("BallTrigger").addNumber("getBlue", ballTrigger::getBlue);

        Shuffleboard.getTab("BallTrigger").addBoolean("isRed", ballTrigger::isRed);
        Shuffleboard.getTab("BallTrigger").addBoolean("isBlue", ballTrigger::isBlue);


        Shuffleboard.getTab("BallTrigger").addNumber("DistanceAnalog", ballTrigger::getAnalogDistance);
        Shuffleboard.getTab("BallTrigger").addNumber("DistanceColor", ballTrigger::getColorDistance);

        Shuffleboard.getTab("BallTrigger").addBoolean("IsBallInPlaceV2", ballTrigger::isBallIdentifiedV2);

            Shuffleboard.getTab("BallTrigger").add(isOurBall);
        }

        public double getBallInPlaceValueEntry () {
            return ballInPlaceValueEntry != null ?
                    ballInPlaceValueEntry.getDouble(INPLACE_DISTANCE_MM) : INPLACE_DISTANCE_MM;
        }

        public double getIdentifiedBallValueEntry () {
            return identifiedBallValueEntry != null ?
                    identifiedBallValueEntry.getDouble(IDENTIFIED_DISTANCE_MM) : IDENTIFIED_DISTANCE_MM;
        }

        public double getBallInPlaceValueEntryV2 () {
            return ballInPlaceValueEntryV2 != null ?
                    ballInPlaceValueEntryV2.getDouble(INPLACE_DISTANCE_COLOR) : INPLACE_DISTANCE_COLOR;
        }
        public double getIdentifiedBallValueEntryV2 () {
            return identifiedBallValueEntryV2 != null ?
                    identifiedBallValueEntryV2.getDouble(IDENTIFIED_DISTANCE_ANALOG) : IDENTIFIED_DISTANCE_ANALOG;
        }

        public double getIsRedEntry () {
            return isRedEntry != null ?
                    isRedEntry.getDouble(THRESHOLD_REDNESS) : THRESHOLD_REDNESS;
        }

        public double getIsBlueEntry () {
            return isBlueEntry != null ?
                    isBlueEntry.getDouble(THRESHOLD_BLUENESS) : THRESHOLD_BLUENESS;
        }
    }
