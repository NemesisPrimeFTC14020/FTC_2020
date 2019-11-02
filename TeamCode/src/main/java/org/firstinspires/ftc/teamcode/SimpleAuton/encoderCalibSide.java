package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "encCalibSide", group = "Linear OpMode")
public class encoderCalibSide extends LinearOpMode {
    public BP bp = new BP();
    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();
        bp.encDriveS(1,1000,this);
        telemetry.addData("encoderval", bp.HW.mA.getCurrentPosition());
    }
}
