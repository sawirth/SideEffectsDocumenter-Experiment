package necmiexperiment.football;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//Dynamic Effects
public class Task4 {
//    @Test
    public void task4_1() {
        /* For Logging; do not make any changes in the following three lines */
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Program compiled at " + dateFormat.format(date));

		/*CODE FOR THE EXPERIMENT*/
        /*Create football Clubs*/
        Club realMadrid = createRealMadrid();
        Club barcelona = createBarcelona();

        //Training
        doTrainingSession(realMadrid, 1);
        doTrainingSession(realMadrid, 2);

        doTrainingSession(barcelona, 1);
        doTrainingSession(barcelona, 2);




		/*END OF EXPERIMENT CODE*/

		/* For Logging; do not make any changes in the next line */
        System.out.println("Success... " + dateFormat.format(date));
    }

    @Test
    public void task4_2() {
        /* For Logging; do not make any changes in the following three lines */
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Program compiled at " + dateFormat.format(date));

		/*CODE FOR THE EXPERIMENT*/



		/*END OF EXPERIMENT CODE*/

		/* For Logging; do not make any changes in the next line */
        System.out.println("Success... " + dateFormat.format(date));
    }

    private Club createRealMadrid() {
        return new Club("Real Madrid", new President("Real Madrid President"), "Adidas", "Michael");
    }

    private Club createBarcelona() {
        return new Club("Barcelona", new President("Josep Maria Bartomeu"), "Nike", "Steve");
    }

    private void doTrainingSession(Club club, int playerIndex) {
        club.team.getManager().getTrainer().trainPlayer("speed", club.team, playerIndex, club.trainingGround);
    }
}
