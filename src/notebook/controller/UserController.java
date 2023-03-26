package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }
    public void saveUser(User user) {
        repository.create(user);
    }

    public User readUser(Long userId) throws Exception {
        List<User> users = repository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }

        throw new RuntimeException("User not found");
    }

    public void updateUser(long userId, User update) {
        update.setId(Long.parseLong(String.valueOf(userId)));
        repository.update(Long.parseLong(String.valueOf(userId)), update);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
    public void deleteUser (long userID) {
        try {
            repository.deleteUserById(userID);
            System.out.println("user has been deleted");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


    }


}
