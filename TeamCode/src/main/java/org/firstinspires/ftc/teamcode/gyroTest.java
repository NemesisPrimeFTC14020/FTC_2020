package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "telOp", group = "Linear OpMode")
public class gyroTest extends LinearOpMode {
    public BP bp = new BP();
    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);

        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("angle", bp.HW.imu.getAngularOrientation().firstAngle);
            telemetry.update();
        }
    }
}