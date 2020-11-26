package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel findByUsername(String username);
    Boolean matchPass(UserModel user, String passLama);
    Boolean updatePass(UserModel user, String passBaru, String passKonfirmasi);
}
