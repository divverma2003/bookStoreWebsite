package psu.edu.BookStoreWebpage.Model;

public class CustomerMessage {
    private String name;
    private String email;
    private String subject;
    private String body;

    public CustomerMessage(String name, String email, String subject, String body){
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.body = body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }


}
