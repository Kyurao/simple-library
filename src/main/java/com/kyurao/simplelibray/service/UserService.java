package com.kyurao.simplelibray.service;

import com.kyurao.simplelibray.domain.User;
import com.kyurao.simplelibray.domain.enums.ContactInfo;
import com.kyurao.simplelibray.dto.request.NewUserReq;
import com.kyurao.simplelibray.dto.request.UserReq;
import com.kyurao.simplelibray.dto.response.UserRes;
import com.kyurao.simplelibray.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserRes getUser(Long id) {
        return userToDto(findById(id));
    }

    public List<UserRes> getAllUsers() {
        return findAllUsers()
                .stream()
                .map(this::userToDto)
                .collect(Collectors.toList());
    }

    public void addNewUser(NewUserReq req) {
        if (!userRepository.existsByIdCard(req.getIdCard())) {
            User user = new User();
            user.setContactInfo(new ContactInfo());
            user.setIdCard(req.getIdCard());
            updateUserFromRequestDto(req, user);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User exist");
        }
    }

    public void editUser(Long id, UserReq req) {
        User user = findById(id);
        updateUserFromRequestDto(req, user);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private void updateUserFromRequestDto(UserReq req, User user) {
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setDateOfBirthday(req.getDateOfBirthday());
        user.getContactInfo().setEmail(req.getEmail());
        user.getContactInfo().setPhoneNumber(req.getPhoneNumber());
    }

    User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    private List<User> findAllUsers() {
        return userRepository.findAll();
    }

    private UserRes userToDto(User user) {
        UserRes res = new UserRes();
        res.setId(user.getId());
        res.setFirstName(user.getFirstName());
        res.setLastName(user.getLastName());
        res.setDateOfBirthday(user.getDateOfBirthday());
        res.setEmail(user.getContactInfo().getEmail());
        res.setPhoneNumber(user.getContactInfo().getPhoneNumber());

        return res;
    }
}
