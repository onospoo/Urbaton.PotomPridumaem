package green.belka.backend;


import green.belka.backend.model.Achievement;
import green.belka.backend.model.ResponseData;
import green.belka.backend.model.User;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface MainService {
    ResponseData<Achievement> getAchievement(Long id);

    ResponseData<List<Achievement>> getAchievements();

    ResponseData<Long> addAchievement(Achievement achievement);

    ResponseData<Long> addAchievementToUser(Achievement achievement, Long userId);

    ResponseData<Long> updateAchievement(Achievement achievement);

    ResponseData<Long> deleteAchievement(Long id);

    ResponseData<User> getUser(Long id);

    ResponseData<List<User>> getUsers();

    ResponseData<Long> addUser(User user);

    ResponseData<Long> updateUser(User user);

    ResponseData<Long> deleteUser(Long id);

    ResponseData<List<Achievement>> getAchievementsByUserId(Long id);

    void setStatusToWaiting(Long user, Long achievement);

    void setStatusToApproved(Long user, Long achievement);

    void setStatusToStarted(Long user, Long achievement);

    ResponseData<Set<UUID>> getKeys(Long id);

    ResponseData<List<User>> getAuthorsAndAchievement();

    ResponseData<Long> approveKey(UUID key, Long id);

//    ResponseData<List<Achievement>> getUserProcessingAchievementById(Long id);
}
