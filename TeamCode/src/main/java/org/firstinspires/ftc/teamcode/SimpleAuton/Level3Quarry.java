package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "QuarryLv3", group = "Linear OpMode")
public class Level3Quarry extends LinearOpMode {
    public BP bp = new BP();

    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();
        //Lv3:
//Move forward x meters
        bp.encDriveFin(1, 54,this);
//Scan for skystone
        int dis = bp.scanforStone('+', this);
//Collect skystone with claw
        bp.Claw('+');
        bp.yClaw('+', 2, this);
// Drive back 5 inches for clearance
        bp.encDriveFin(1, -5, this);
// Drive x meters towards skybridge
        bp.encDriveSin(1, 72 - dis,this);
// Drive back to line
        bp.encDriveSin(1, -9,this);
//Park
    }
}