package models;

public class Teacher extends Person {

    private String subject;
    private String phone;

    public Teacher(String name, int id, String subject, String phone) {
        super(name, id);
        this.subject = subject;
        this.phone = phone;
    }

    public String getSubject() { 
        return subject; 
    }

    public void setSubject(String subject) { 
        this.subject = subject; 
    }

    public String getPhone() { 
        return phone; 
    }

    public void setPhone(String phone) { 
        this.phone = phone; 
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + id +
                           ", Name: " + name +
                           ", Subject: " + subject +
                           ", Phone: " + phone);
    }
}

