package gb.karpenka.authenticator.services;

import gb.karpenka.authenticator.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public void addProduct(User u) {
        users.add(u);
    }

    public List<User> findAll() {
        return users;
    }

}

