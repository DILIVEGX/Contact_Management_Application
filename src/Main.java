import java.util.*;

public class Main {
    public static void main(String[] args) {
        ContactDirectory directory = new ContactDirectory();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Add new contact");
            System.out.println("2. Register a contact type");
            System.out.println("3. Display unique contact types");
            System.out.println("4. Search contact by name");
            System.out.println("5. Update contact information");
            System.out.println("6. Sort and display contacts by name");
            System.out.println("7. Exit");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    if (directory.getContactTypeList().isEmpty()) {
                        System.out.println("Register at least one contact type first.");
                        break;
                    }

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    List<String> types = directory.getContactTypeList();
                    System.out.println("Contact Type:");
                    for (int i = 0; i < types.size(); i++) {
                        System.out.println((i + 1) + ". " + types.get(i));
                    }

                    int typeChoice;
                    do {
                        System.out.print("Type number: ");
                        typeChoice = scanner.nextInt();
                    } while (typeChoice < 1 || typeChoice > types.size());
                    scanner.nextLine();

                    String selectedType = types.get(typeChoice - 1);
                    directory.addContact(name, phone, email, selectedType);
                    System.out.println("Contact added successfully.");
                    break;

                case 2:
                    System.out.print("New contact type: ");
                    String newType = scanner.nextLine();
                    directory.addContactType(newType);
                    break;

                case 3:
                    directory.displayContactTypes();
                    break;

                case 4:
                    System.out.print("Name to search: ");
                    String searchName = scanner.nextLine();
                    Contact found = directory.searchContact(searchName);
                    if (found != null) {
                        System.out.println("Contact found: " + found);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5:
                    System.out.print("Current name of the contact to update: ");
                    String currentName = scanner.nextLine();

                    System.out.print("New name: ");
                    String newName = scanner.nextLine();

                    System.out.print("New phone: ");
                    String newPhone = scanner.nextLine();

                    System.out.print("New email: ");
                    String newEmail = scanner.nextLine();

                    if (directory.getContactTypeList().isEmpty()) {
                        System.out.println("No contact types registered.");
                        break;
                    }

                    System.out.println("New contact type:");
                    List<String> availableTypes = directory.getContactTypeList();
                    for (int i = 0; i < availableTypes.size(); i++) {
                        System.out.println((i + 1) + ". " + availableTypes.get(i));
                    }

                    int newTypeIndex;
                    do {
                        System.out.print("Enter type number: ");
                        newTypeIndex = scanner.nextInt();
                    } while (newTypeIndex < 1 || newTypeIndex > availableTypes.size());
                    scanner.nextLine();

                    String updatedType = availableTypes.get(newTypeIndex - 1);
                    directory.updateContact(currentName, newName, newPhone, newEmail, updatedType);
                    break;

                case 6:
                    directory.sortAndDisplayContactsByName();
                    break;

                case 7:
                    System.out.println("Exiting Contact Manager.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 7);

        scanner.close();
    }
}
