package codegym.vn.service;

import codegym.vn.entity.Song;

import java.util.List;

public interface SongService {
    Song findById(String id);
    List<Song> findAll();
    void create(Song song);
    void update(Song song);
    void delete(String id);
}
