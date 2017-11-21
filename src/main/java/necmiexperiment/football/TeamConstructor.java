package necmiexperiment.football;

import java.util.ArrayList;
import java.util.List;

public class TeamConstructor {

    public Team createTeamBarcelona() {
        /*create manager*/
        Manager manager = new Manager("Someone", 5000000, 7);
        /*create players*/
        Player p1 = new Player("Messi", 95, 90, 1000000, 9);
        Player p2 = new Player("Luis Suarez", 85, 95, 1000000, 6);
        Player p3 = new Player("Gerard Pique", 85, 95, 1000000, 9);
        Player p4 = new Player("Andres Iniesta", 85, 95, 1000000, 10);
        Player p5 = new Player("Andre Gomes", 85, 95, 1000000, 4);
        Player p6 = new Player("Rafinha", 85, 95, 1000000, 5);
        Player p7 = new Player("Javier Mascherano", 85, 95, 1000000, 8);
        Player p8 = new Player("Ivan Rakitic", 85, 95, 1000000, 6);
        Player p9 = new Player("Samuel Umtit", 85, 95, 1000000, 1);
        Player p10 = new Player("Alex Vidal", 85, 95, 1000000, 2);
        Player p11 = new Player("Marc-Andre ter Stegen", 85, 95, 1000000, 8);
        /*add players to an arrayList*/
        List<Player> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);
        l.add(p5);
        l.add(p6);
        l.add(p7);
        l.add(p8);
        l.add(p9);
        l.add(p10);
        l.add(p11);
        /*create team*/
        Team t = new Team("Barcelona", l, manager);
        return t;
    }

    public Team createTeamRealMadrid() {
        /*create manager*/
        Manager manager = new Manager("Someone", 5000000, 7);
        Player p1 = new Player("Cristiano Ronaldo", 95, 90, 1000000, 9);
        Player p2 = new Player("James Rodriguez", 95, 90, 1000000, 9);
        Player p3 = new Player("Gareth Bale", 95, 90, 1000000, 9);
        Player p4 = new Player("Karim Benzema", 95, 90, 1000000, 9);
        Player p5 = new Player("Sergio Ramos", 95, 90, 1000000, 9);
        Player p6 = new Player("Pepe", 95, 90, 1000000, 9);
        Player p7 = new Player("Alvaro Morata", 95, 90, 1000000, 9);
        Player p8 = new Player("Isco", 95, 90, 1000000, 9);
        Player p9 = new Player("Dani Carvajal", 95, 90, 1000000, 9);
        Player p10 = new Player("Toni Kroos", 95, 90, 1000000, 9);
        Player p11 = new Player("Navas", 95, 90, 1000000, 9);
        /*add everyone to the list*/
        List<Player> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);
        l.add(p5);
        l.add(p6);
        l.add(p7);
        l.add(p8);
        l.add(p9);
        l.add(p10);
        l.add(p11);
        /*create the team*/
        Team t = new Team("Real Madrid", l, manager);
        return t;
    }
}
