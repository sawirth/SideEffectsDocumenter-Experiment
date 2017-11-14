package necmiexperiment.football;

import junit.framework.TestCase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestsFootball { //extends TestCase{
    public void test01() {
        		/* For Logging; do not make any changes in the following three lines */
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Program compiled at " + dateFormat.format(date));

		/*CODE FOR THE EXPERIMENT*/


		/*Create football Clubs*/
        Club barcelona = new Club("Barcelona", new President("Josep Maria Bartomeu"), "Nike", "Steve");
        Club realMadrid = new Club("Real Madrid", new President("Real Madrid President"), "Adidas", "Michael");


		/*Some player goes partying*/
        barcelona.getTeam().getPlayerList().get(0).getPlayerCondition().getPrivateLife().goPartying();

		/*Player 0 (barcelona) is sent to speed training*/
        barcelona.getTeam().getManager().getTrainer().trainPlayer("speed",	barcelona.team,	0,	barcelona.trainingGround	);

		/*President of barcelona raises the salary of player 0*/
        barcelona.getPresident().raisePlayerSalary(0,barcelona,1000);

		/*President of Barcelona raises the training ground*/
        barcelona.getPresident().upgradeTrainingGround(barcelona,2);

		/*Player 0 (barcelona) is sent to power training*/
        barcelona.getTeam().getManager().getTrainer().trainPlayer("power",	barcelona.team,	0,	barcelona.trainingGround	);

		/*President of realdMadrid raises the salary of player 3*/
        realMadrid.getPresident().raisePlayerSalary(3,barcelona,1000);

        /* Janitor mows grass */
        barcelona.getJanitor().mowPitch(barcelona.getTrainingGround().getPitch());

		/*Player 5 (real madrid) is sent to speed training*/
        realMadrid.getTeam().getManager().getTrainer().trainPlayer("speed"	,barcelona.team,	0,	barcelona.trainingGround	);

		/*Some player goes partying*/
        realMadrid.getTeam().getPlayerList().get(4).getPlayerCondition().getPrivateLife().goPartying();

		/*Player 0 ( Barcelona )  takes a penalty against RealMadrid*/
        barcelona.getTeam().getPlayerList().get(0).takePenalty(realMadrid.team.playerList.get(9));

        /* Real Madrid needs a better pitch */
        realMadrid.getPresident().upgradeTrainingGround(realMadrid, 2);

		/*END OF EXPERIMENT CODE*/

		/* For Logging; do not make any changes in the next line */
        System.out.println("Success... " + dateFormat.format(date));
    }
}
