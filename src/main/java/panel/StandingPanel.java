package panel;

import model.Standing;
import model.dao.StandingDao;

import java.util.Scanner;

public class StandingPanel {


    public void iniStandingPanel() {

        StandingDao standingDao = new StandingDao();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadź 1, aby zobaczyć listę stanowisk, 2 aby dodać stanowisko lub 3 aby usunąć stanowisko");
        int inputNumber = scanner2.nextInt();

        switch (inputNumber) {
            case 1: {
                standingDao.getStandings();
                break;
            }
            case 2: {
                System.out.println("Wprowadź nazwę stanowiska");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();

                Standing newStanding = new Standing();
                newStanding.setName(name);
                standingDao.addStanding(newStanding);
                break;
            }
            case 3: {
                System.out.println("Podaj id stanowiska ");
                Scanner scanner = new Scanner(System.in);
                int standingId = scanner.nextInt();

                standingDao.deleteStanding(standingId);
                break;
            }
            default: {
                System.out.println("Błędne dane");
                break;
            }
        }
    }
}
