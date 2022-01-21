package vn.codegym.validate_form_dang_ky.service;

import vn.codegym.validate_form_dang_ky.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void save(User user);
}
