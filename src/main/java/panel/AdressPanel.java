package panel;

import model.Address;
import model.dao.AddressDao;

import java.util.Scanner;

public class AdressPanel {

    AddressDao adressDao = new AddressDao();

    public void iniAdressPanel() {

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Wprowadź 1, aby zobaczyć bazę adresów, 2 aby dodać adres oraz 3 aby usunąć adres");
        int inputNumber = scanner2.nextInt();

        switch (inputNumber) {
            case 1: {
                adressDao.getAdresses();
                break;
            }
            case 2: {
                System.out.println("Wprowadź miasto, ulicę, nr domu i nr mieszkania");
                Scanner scanner = new Scanner(System.in);
                Address address = new Address();

                String city = scanner.nextLine();
                address.setCity(city);
                String street = scanner.nextLine();
                address.setStreet(street);
                String homeNumber = scanner.nextLine();
                address.setHomeNumber(homeNumber);
                String flatNumber= scanner.nextLine();
                address.setFlatNumber(flatNumber);

                adressDao.addAdress(address);
                break;
            }
            case 3: {
                System.out.println("Id adresu");
                Scanner scanner = new Scanner(System.in);
                int adresId = scanner.nextInt();

                adressDao.deleteAdress(adresId);
                break;
            }
            default: {
                System.out.println("Błędne dane");
                break;
            }
        }
    }
}
