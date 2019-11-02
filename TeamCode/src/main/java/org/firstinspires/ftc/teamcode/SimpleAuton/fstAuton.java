package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "fstAtn", group = "Linear OpMode")
public class fstAuton extends LinearOpMode {
    public BP bp = new BP();
    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();


// calculate measurements (add parameter to the claw)
// Move forward x meters
        bp.encDriveFin(1, 54,this);
// Drive x metersleft towards skybridge
        bp.encDriveSin(1, 54,this);
//Park



//Lv2:
//Move forward x meters
        bp.encDriveFin(1, 54,this);
//Collect stone with claw
        bp.yClaw('+');
        bp.xClaw('+');
        bp.yClaw('-');
        bp.Claw('+');
//Drive x meters left towards skybridge
        bp.yClaw('+');
        bp.xClaw('-');
        bp.yClaw('-');
        bp.encDriveSin(1, 54,this);
//Park


//Lv3:
//Move forward x meters
        bp.encDriveFin(1, 54,this);
//Scan for skystone

//Collect skystone with claw
//Drive x meters left towards skybridge
//Park
//
//Lv4:
//Move forward x meters
//Collect skystone with claw
//Drive x meters left towards skybridge
//Place on Foundation
//Go back
//Park



    }
}
