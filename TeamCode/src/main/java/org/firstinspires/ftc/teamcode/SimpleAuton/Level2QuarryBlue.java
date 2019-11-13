package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "QuarryLv2", group = "Linear OpMode")
public class Level2QuarryBlue extends LinearOpMode {
    public BP bp = new BP();

    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();
        //Lv2:
// Open claw
        bp.Claw('-');
//Move forward x meters
        bp.encDriveFin(1, 54,this);
//Collect stone with claw
        bp.Claw('+');
// Drive back 5 inches for clearance
        bp.encDriveFin(1, -5, this);
// Drive x meters towards skybridge
        bp.encDriveSin(1, 72,this);
// Drive back to line
        bp.encDriveSin(1, -9,this);

    }
}