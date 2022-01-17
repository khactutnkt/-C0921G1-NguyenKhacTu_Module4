package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Song;
import vn.codegym.repository.ISongRepository;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public void remove(Integer id) {
        songRepository.remove(id);
    }
}
