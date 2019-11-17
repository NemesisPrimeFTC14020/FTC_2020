package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "QuarryLv3", group = "Linear OpMode")
public class Level3QuarryBlue extends LinearOpMode {
    public BP bp = new BP();

    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this, true);
        waitForStart();
        //Lv3:
//Curve claw forward
        bp.curveClaw(0);
//Extend claw
        bp.Claw('-');
//Move forward x meters
        bp.encDriveFin(1, 54,this);
//Scan for Skystone
        int dis = bp.scanforStone('+', this);
//Claw Skystone
        bp.Claw('+');
//Lift claw 0.4 with servo
        bp.curveClaw(0.4);
//Drive back 5 inches for clearance
        bp.encDriveFin(1, -5, this);
//Drive x inches towards skybridge
        bp.encDriveSin(1, 72 - dis,this);
//Extend claw
        bp.Claw('-');
//Curve claw forward
        bp.curveClaw(0);
//Drive back to line
        bp.encDriveSin(1, -9,this);

    }
}