package vn.codegym.ss8_validatte_bai_hat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.codegym.ss8_validatte_bai_hat.model.Song;
import vn.codegym.ss8_validatte_bai_hat.repository.ISongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService{
    @Autowired
    private ISongRepository repository;

    @Override
    public List<Song> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return repository.findById(id);
    }
}
