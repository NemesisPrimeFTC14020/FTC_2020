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


// Move forward x meters
        bp.encDriveFin(1, 54,this);
// Drive x meters towards skybridge
        bp.encDriveSin(1, 72,this);
// Drive back to line
        bp.encDriveSin(1, -9,this);
//Park



//Lv2:
// Open claw
        bp.Claw('-');
//Move forward x meters
        bp.encDriveFin(1, 54,this);
//Collect stone with claw
        bp.Claw('+');
        bp.yClaw('+', 2, this);
// Drive back 5 inches for clearance
        bp.encDriveFin(1, -5, this);
// Drive x meters towards skybridge
        bp.encDriveSin(1, 72,this);
// Drive back to line
        bp.encDriveSin(1, -9,this);
//Park


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



//Lv4:
//Move forward x meters
//Collect skystone with claw
//Drive x meters left towards skybridge
//Place on Foundation
//Go back
//Park



    }
}
