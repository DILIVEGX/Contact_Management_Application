import java.util.*;

public class ContactDirectory {
    private final List<Contact> contacts;
    private final Set<String> contactTypes;
    private final Map<String, Contact> contactMap;
    private int nextId = 1; // Auto-increment ID

    public ContactDirectory() {
        contacts = new ArrayList<>();
        contactTypes = new LinkedHashSet<>(); // Ordered set for consistent numbering
        contactMap = new HashMap<>();
    }

    // Add a new contact with auto-increment ID
    public void addContact(String name, String phone, String email, String type) {
        Contact contact = new Contact(nextId++, name, phone, email, type);
        contacts.add(contact);
        contactTypes.add(type);
        contactMap.put(name, contact);
    }

    public void updateContact(String oldName, String newName, String newPhone, String newEmail, String newType) {
        Contact contact = contactMap.get(oldName);
        if (contact != null) {
            contact.setName(newName);
            contact.setPhone(newPhone);
            contact.setEmail(newEmail);
            contact.setType(newType);
            contactTypes.add(newType);

            if (!oldName.equals(newName)) {
                contactMap.remove(oldName);
                contactMap.put(newName, contact);
            }
        } else {
            System.out.println("Contact not found: " + oldName);
        }
    }

    public Contact searchContact(String name) {
        return contactMap.get(name);
    }

    public void addContactType(String type) {
        if (contactTypes.add(type)) {
            System.out.println("New contact type added: " + type);
        } else {
            System.out.println("Contact type already exists: " + type);
        }
    }

    public void displayContactTypes() {
        System.out.println("Unique Contact Types:");
        int index = 1;
        for (String type : contactTypes) {
            System.out.println(index++ + ". " + type);
        }
    }

    public List<String> getContactTypeList() {
        return new ArrayList<>(contactTypes);
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        System.out.println("All Contacts:");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public void sortAndDisplayContactsByName() {
        contacts.sort(Comparator.comparing(Contact::getName));
        System.out.println("Contacts sorted by name:");
        displayAllContacts();
    }
}
