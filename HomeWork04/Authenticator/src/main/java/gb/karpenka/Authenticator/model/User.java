package gb.karpenka.Authenticator.model;

public class User {

    private String name;
    private Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
enum Status {
    ADMIN,
    REGULAR,
    PRIVILEGED
}