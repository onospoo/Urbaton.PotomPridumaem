package green.belka.backend;


import green.belka.backend.model.Achievement;
import green.belka.backend.model.ResponseData;
import green.belka.backend.model.ResultCode;
import green.belka.backend.model.User;
import green.belka.backend.repository.AchievementRepository;
import green.belka.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    AchievementRepository achievementRepository;

    @Autowired
    UserRepository userRepository;

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
    public ResponseData<Long> addAchievement(Achievement achievement) {
        Long id = achievementRepository.save(achievement).getId();
        return new ResponseData<>(id, ResultCode.OK);
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

}
