package green.belka.backend;


import green.belka.backend.model.*;
import green.belka.backend.repository.AchievementRepository;
import green.belka.backend.repository.AchievementStatusRepository;
import green.belka.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    AchievementRepository achievementRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AchievementStatusRepository achievementStatusRepository;

    @Override
    public ResponseData<Achievement> getAchievement(Long id) {
        Achievement achievement = achievementRepository.findById(id).get();
        return new ResponseData<>(achievement, ResultCode.OK);
    }

    @Override
    public ResponseData<List<Achievement>> getAchievements() {
        List<Achievement> achievements = achievementRepository.findAll();
        return new ResponseData<>(achievements, ResultCode.OK);
    }

    @Override
    public ResponseData<Long> addAchievement(Achievement achievement)  {
        achievement.setStatus(Status.NONE);
        Long id = achievementRepository.save(achievement).getId();

        return new ResponseData<>(id, ResultCode.OK);
    }

    @Override
    public ResponseData<Long> addAchievementToUser(Achievement achievement, Long userId) {
        User user = userRepository.findById(userId).get();

        if(achievement.getId() != null) {
            achievement = achievementRepository.findById(achievement.getId()).get();
        }

        if(user.getScore() == null) {
            user.setScore(0l);
        }
        user.setScore(user.getScore() + achievement.getCost());
        achievement.setStatus(Status.STARTED);
        user.getAchievements().add(achievement);
        user = userRepository.save(user);
        AchievementStatus achievementStatus = new AchievementStatus();
        achievementStatus.setAchievement_id(achievement.getId());
        achievementStatus.setUser_id(user.getId());
        achievementStatus.setStatus(Status.STARTED);
        achievementStatusRepository.save(achievementStatus);
        achievement = user.getAchievements().get(user.getAchievements().size()-1);
        return new ResponseData<>(achievement.getId(), ResultCode.OK);
    }

    @Override
    public ResponseData<Long> updateAchievement(Achievement achievement) {
        Long id = achievementRepository.save(achievement).getId();
        return new ResponseData<>(id, ResultCode.OK);
    }

    @Override
    public ResponseData<Long> deleteAchievement(Long id) {
        achievementRepository.deleteById(id);
        return new ResponseData<>(id, ResultCode.OK);
    }

    @Override
    public ResponseData<User> getUser(Long id) {
        User user = userRepository.findById(id).get();
        return new ResponseData<>(user, ResultCode.OK);
    }

    @Override
    public ResponseData<List<User>> getUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseData<>(users, ResultCode.OK);
    }

    @Override
    public ResponseData<Long> addUser(User user) {
        Long id = userRepository.save(user).getId();
        return new ResponseData<Long>(id, ResultCode.OK);
    }

    @Override
    public ResponseData<Long> updateUser(User user) {
        Long id = userRepository.save(user).getId();
        return new ResponseData<Long>(id, ResultCode.OK);
    }

    @Override
    public ResponseData<Long> deleteUser(Long id) {
        userRepository.deleteById(id);
        return new ResponseData<Long>(id, ResultCode.OK);
    }

    @Override
    public ResponseData<List<Achievement>> getAchievementsByUserId(Long id) {
        List<Achievement> achievements = achievementRepository.findAllByAuthorId(id);
        return new ResponseData<>(achievements, ResultCode.OK);
    }

    @Override
    public void setStatusToWaiting(Long user, Long Achievement) {
        if(achievementStatusRepository.findById(user).get() != null){
            achievementStatusRepository.findById(user).get().setStatus(Status.WAITING);
        }
    }

    @Override
    public void setStatusToApproved(Long user, Long Achievement) {
        if(achievementStatusRepository.findById(user).get() != null){
            achievementStatusRepository.findById(user).get().setStatus(Status.APPROVED);
        }
    }

    @Override
    public void setStatusToStarted(Long user, Long Achievement) {
        if(achievementStatusRepository.findById(user).get() != null){
            achievementStatusRepository.findById(user).get().setStatus(Status.STARTED);
        }
    }

    @Override
    public ResponseData<List<UUID>> getKeys(long id) {
        List<UUID> keys = achievementRepository.findById(id).get().getKeys();
        return new ResponseData<List<UUID>>(keys, ResultCode.OK);
    }

}
