package vn.codegym.validate_form_dang_ky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.validate_form_dang_ky.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
}
