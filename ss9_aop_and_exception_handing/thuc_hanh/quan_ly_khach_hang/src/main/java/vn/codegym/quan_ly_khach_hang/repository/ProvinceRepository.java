package vn.codegym.quan_ly_khach_hang.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.codegym.quan_ly_khach_hang.model.Province;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}

