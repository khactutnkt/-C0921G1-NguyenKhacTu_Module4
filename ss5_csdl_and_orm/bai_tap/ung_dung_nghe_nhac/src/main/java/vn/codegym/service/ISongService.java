package vn.codegym.service;

import vn.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(Integer id);
    void remove(Integer id);
}
