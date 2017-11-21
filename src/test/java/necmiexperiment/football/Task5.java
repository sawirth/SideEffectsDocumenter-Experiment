package necmiexperiment.football;

import org.junit.Test;

public class Task5 {
//    @Test
    public void task5() {
        /*Create football Clubs*/
        Club barcelona = new Club("Barcelona", new President("Josep Maria Bartomeu"), "Nike", "Steve");
        ClubReport clubReport = barcelona.team.manager.createClubReport(barcelona);

    }
}
