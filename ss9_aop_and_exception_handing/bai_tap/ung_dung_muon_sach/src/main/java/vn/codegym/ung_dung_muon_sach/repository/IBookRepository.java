package vn.codegym.ung_dung_muon_sach.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.ung_dung_muon_sach.model.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAll(Pageable pageable);
}
