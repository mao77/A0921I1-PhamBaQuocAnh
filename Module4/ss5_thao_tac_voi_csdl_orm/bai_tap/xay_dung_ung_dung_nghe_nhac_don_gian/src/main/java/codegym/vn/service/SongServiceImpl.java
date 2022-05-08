package codegym.vn.service;

import codegym.vn.entity.Song;
import codegym.vn.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{
    private SongRepository songRepository;
    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song findById(String id) {
        return songRepository.findById(id);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void create(Song song) {
        songRepository.create(song);
    }

    @Override
    public void update(Song song) {
        songRepository.update(song);
    }

    @Override
    public void delete(String id) {
        songRepository.delete(id);
    }
}
