package vn.codegym.ung_dung_muon_sach.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.ung_dung_muon_sach.model.Book;
import vn.codegym.ung_dung_muon_sach.repository.IBookRepository;


@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookRepository repository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
