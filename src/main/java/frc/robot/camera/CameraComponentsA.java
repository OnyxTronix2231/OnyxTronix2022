package frc.robot.camera;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;

import static frc.robot.camera.CameraConstants.*;

public class CameraComponentsA implements CameraComponents {

    private final UsbCamera camera1;
    private final UsbCamera camera2;

    public CameraComponentsA(){
        camera1 = CameraServer.startAutomaticCapture(0);
        camera2 = CameraServer.startAutomaticCapture(1);

        setCameraConfiguration(camera1);
        setCameraConfiguration(camera2);
    }

    public static void setCameraConfiguration(UsbCamera camera){
        camera.setResolution(WIDTH,HEIGHT);
        camera.setFPS(FPS);
        camera.setExposureManual(EXPOSURE);
    }

    @Override
    public UsbCamera getFirstCamera() {
        return camera1;
    }

    @Override
    public UsbCamera getSecondCamera() {
        return camera2;
    }
}
