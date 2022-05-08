package codegym.vn.repository;

import codegym.vn.entity.Song;

import java.util.List;

public interface SongRepository {
    Song findById(String id);
    List<Song> findAll();
    void create(Song song);
    void update(Song song);
    void delete(String id);
}