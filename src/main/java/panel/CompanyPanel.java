package panel;

import model.Company;
import model.dao.CompanyDao;

import java.util.Scanner;

public class CompanyPanel {

    CompanyDao companyDao = new CompanyDao();

    public void iniCompanyPanel() {

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadź 1, aby zobaczyć bazę firm, 2 aby dodać firmę, 3 aby zaktualizować dane firmy " +
                "oraz 4 aby usunąć firmę");
        int inputNumber = scanner2.nextInt();

        switch (inputNumber) {
            case 1: {
                companyDao.getCompanies();
                break;
            }
            case 2: {
                System.out.println("Wprowadź nazwę firmy, ulicę, numer domu i numer mieszkania");
                Scanner scanner = new Scanner(System.in);
                Company company = new Company();
                String name = scanner.nextLine();
                company.setName(name);
                String street = scanner.nextLine();
                company.setStreet(street);
                String home_number = scanner.nextLine();
                company.setHome_number(home_number);
                String flat_number = scanner.nextLine();
                company.setFlat_number(flat_number);

                companyDao.addCompany(company);
                break;
            }
            case 3: {
                System.out.println("Podaj id firmy ");
                Scanner scanner = new Scanner(System.in);
                int companyId = scanner.nextInt();
                System.out.println("Podaj nazwę, ulicę, numer domu i NIP firmy");
                String name = scanner.nextLine();
                String street = scanner.nextLine();
                String number = scanner.nextLine();
                String nip = scanner.nextLine();

                companyDao.updateCompany(companyId, name, street, number, nip);
                break;
            }
            case 4: {
                System.out.println("Podaj id firmy ");
                Scanner scanner = new Scanner(System.in);
                int companyId = scanner.nextInt();

                companyDao.deleteCompany(companyId);
                break;
            }
            default: {
                System.out.println("Błędne dane");
                break;
            }
        }
    }
}
