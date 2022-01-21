package vn.codegym.validate_form_dang_ky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.validate_form_dang_ky.model.User;
import vn.codegym.validate_form_dang_ky.repository.IUserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
