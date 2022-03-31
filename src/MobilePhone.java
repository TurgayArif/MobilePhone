import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts = new ArrayList<>();


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact with name " + contact.getName() + " already exist.");
            return false;
        }

        this.myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact.getName()) < 0) {
            System.out.println("Contact with name " + oldContact.getName() + " not found in contact list.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exist. Update not successful.");
            return false;
        }

        this.myContacts.set(findContact(oldContact.getName()), newContact);
        System.out.println(oldContact.getName() + " successfully replaced with " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact.getName()) < 0) {
            System.out.println("Contact with name " + contact.getName() + " was not found in contact list.");
            return false;
        }

        this.myContacts.remove(findContact(contact.getName()));
        System.out.println("Contact with name " + contact.getName() + " was removed from contact list.");
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String contact) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact1 = this.myContacts.get(i);
            if (contact1.getName().equals(contact)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contact) {
        if (findContact(contact) >= 0) {
            return this.myContacts.get(findContact(contact));
        }

        return null;
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
        }

    }
}

