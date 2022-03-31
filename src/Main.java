import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0882 023 336");

    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }


    private static void queryContact() {
        System.out.println("Enter contact name");
        String name = sc.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Cannot find contact with name " + name + " in contact list.");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + ", Phone number: " + existingContact.getPhoneNumber());
    }

    private static void removeContact() {
        System.out.println("Enter contact name");
        String name = sc.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact with name " + name + " was not found in the contact list. Please enter correct name.");
            return;
        }

        if (mobilePhone.removeContact(existingContact)) {
            System.out.println("Successfully removed contact with name " + name + " from contact list.");
        } else {
            System.out.println("Error on removing contact, please check your entries.");
        }
    }

    private static void updateContact() {
        System.out.println("Enter contact name which you want to update: ");
        String name = sc.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Enter new contact name");
        String newName = sc.nextLine();
        System.out.println("Enter new contact phone number");
        String newPhone = sc.nextLine();
        Contact newContact = Contact.createContact(newName, newPhone);
        if (mobilePhone.updateContact(existingContact, newContact)) {
            System.out.println("Successfully updated contact.");
        } else {
            System.out.println("Error in updating contact, please check your entries.");
        }
    }

    private static void addNewContact() {
        System.out.println("Enter contact name: ");
        String name = sc.nextLine();
        System.out.println("Enter phone number: ");
        String phone = sc.nextLine();
        Contact contact = Contact.createContact(name, phone);
        if (mobilePhone.addNewContact(contact)) {
            System.out.println("Contact with name " + name + " and phone number " + phone + " successfully added to contact list.");
        } else {
            System.out.println("Contact with name " + name + " already exist in contact list.");
        }
    }

    private static void startPhone() {
        System.out.println("Phone loading...");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("""
                0  - to shutdown
                1  - to print contacts
                2  - to add a new contact
                3  - to update an existing contact
                4  - to remove an existing contact
                5  - query if an existing contact exists
                6  - to print a list of available actions.""");
        System.out.println("Choose your action: ");
    }
}
