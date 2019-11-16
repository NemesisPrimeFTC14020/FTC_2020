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
//Curve claw forward
        bp.curveClaw(.2);
        sleep(2000);
// Open claw
        bp.Claw('-');
        sleep(2000);
//Move forward x meters
        bp.encDriveFin(1, 32,this);
//Collect stone with claw
        bp.Claw('+');
        sleep(2000);
//Lift claw 0.3 with servo
        bp.curveClaw(0.25);
        sleep(2000);
// Drive back 5 inches for clearance
        bp.encDriveFin(1, -20, this);
// Drive x meters towards skybridge
        bp.encDriveSin(1, -60,this);
//Extend claw
        bp.Claw('-');
        sleep(2000);
//Curve claw forward
        bp.curveClaw(0);
        sleep(2000);
// Drive back to line
        bp.encDriveSin(1, 18,this);

    }
}