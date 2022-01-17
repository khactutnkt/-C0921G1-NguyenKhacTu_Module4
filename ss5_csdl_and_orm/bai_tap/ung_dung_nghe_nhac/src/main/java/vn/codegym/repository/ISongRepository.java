package vn.codegym.repository;

import vn.codegym.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    void save(Song song);
    Song findById(Integer id);
    void remove(Integer id);
}
