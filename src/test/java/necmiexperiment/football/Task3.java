package necmiexperiment.football;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Static Modifier
 */
public class Task3 {

    //@Test
    public void task3() {
                /* For Logging; do not make any changes in the following three lines */
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Program compiled at " + dateFormat.format(date));

		/*CODE FOR THE EXPERIMENT*/

		/*Create football Clubs*/
        Club barcelona = new Club("Barcelona", new President("Josep Maria Bartomeu"), "Nike", "Steve");
        Club realMadrid = new Club("Real Madrid", new President("Real Madrid President"), "Adidas", "Michael");

		/*Some player talks to the press*/
        realMadrid.getTeam().getPlayerList().get(2).getPlayerCondition().getPrivateLife().talkToPress();

        /* President checks salaries */
        barcelona.getPresident().controlSalaries(barcelona.team.playerList);

		/*President of barcelona raises the salary of player 0*/
        barcelona.getPresident().raisePlayerSalary(0,barcelona,1000);
        barcelona.getPresident().raisePlayerSalary(2,barcelona,20000);
        barcelona.getPresident().raisePlayerSalary(6,barcelona,20000);

        //check salaries again
        barcelona.getPresident().controlSalaries(barcelona.team.playerList);

		/*President of real Madrid raises the salary of player 3*/
        realMadrid.getPresident().raisePlayerSalary(3,barcelona,1000);

		/*Player 5 (real madrid) is sent to speed training*/
        realMadrid.getTeam().getManager().getTrainer().trainPlayer("speed"	,barcelona.team,	0,	barcelona.trainingGround	);

		/*Some player goes partying*/
        realMadrid.getTeam().getPlayerList().get(4).getPlayerCondition().getPrivateLife().goPartying();

        barcelona.playGameAgainst(realMadrid);

        barcelona.getPresident().controlSalaries(barcelona.team.playerList);
        realMadrid.getPresident().controlSalaries(realMadrid.team.playerList);

		/*END OF EXPERIMENT CODE*/

		/* For Logging; do not make any changes in the next line */
        System.out.println("Success... " + dateFormat.format(date));
    }
}
