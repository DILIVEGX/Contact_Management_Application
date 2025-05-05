public class Contact {
    private final int id;
    private String name;
    private String phone;
    private String email;
    private String type;

    public Contact(int id, String name, String phone, String email, String type) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nPhone: " + phone +
                "\nEmail: " + email + "\nType: " + type + "\n\n";
    }
}
