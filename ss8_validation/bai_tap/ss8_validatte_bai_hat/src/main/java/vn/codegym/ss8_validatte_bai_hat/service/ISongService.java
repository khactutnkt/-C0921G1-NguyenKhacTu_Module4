package vn.codegym.ss8_validatte_bai_hat.service;

import vn.codegym.ss8_validatte_bai_hat.model.Song;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Optional<Song> findById(Long id);
}
