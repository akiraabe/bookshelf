package org.work.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.work.domain.model.User;
import org.work.domain.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by akiraabe on 2017/06/17.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

   public List<User> findAllSortedBy(String... fields) {
        return userRepository.findAll(new Sort(fields));
    }

    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    public void register(User user) {
        userRepository.save(user);
    }

    public void edit(User user) {
        this.register(user);
    }

    public void remove(Long id) {
        userRepository.delete(id);
    }
}
