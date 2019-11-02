package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "QuarryLv1", group = "Linear OpMode")
public class Level1Quarry extends LinearOpMode {
    public BP bp = new BP();

    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();
        // Lv1:
// Move forward x meters
        bp.encDriveFin(1, 54, this);
// Drive x meters towards skybridge
        bp.encDriveSin(1, 72, this);
// Drive back to line
        bp.encDriveSin(1, -9, this);
//Park
    }
}