package org.firstinspires.ftc.teamcode.TestOpModes;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.BP;

@TeleOp(name = "gyroTest", group = "Linear OpMode")
public class gyroTest extends LinearOpMode {
    public BP bp = new BP();
    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);

        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("angle", bp.getHeading(this));
            telemetry.update();
        }
    }
}