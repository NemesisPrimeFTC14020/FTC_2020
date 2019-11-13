package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "FoundationLv2", group = "Linear OpMode")
public class Level2Foundation extends LinearOpMode {
    public BP bp = new BP();

    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();
        //Lv2:
//Bring extrusions up x inches to be above the Foundation
        bp.yClaw('+', 1, this);
//Move x inches forward
        bp.encDriveFin(1, 1, this);
//Drop extrusions x inches
        bp.yClaw('-', 0, this);
//Pull 40.5 inches in (40 to maximize clearance + 0.5 in more for good measure)
        bp.encDriveFin(1, -40.5, this);
//Bring extrusions up x inches to be above the Foundation
        bp.yClaw('+', 0, this);
//Drive 20 inches towards skybridge
        bp.encDriveSin(1, -20, this);
//Drop down elevator
        bp.yClaw('-', 1, this);
//Drive x inches towards skybridge
        bp.encDriveSin(1, -2, this);
    }
}