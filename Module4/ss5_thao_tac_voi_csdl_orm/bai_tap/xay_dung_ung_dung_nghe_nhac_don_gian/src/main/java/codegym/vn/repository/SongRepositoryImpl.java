package codegym.vn.repository;

import codegym.vn.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SongRepositoryImpl implements SongRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Song findById(String id) {
        return entityManager.find(Song.class,id);
    }

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("SELECT s from Song s").getResultList();
    }

    @Override
    public void create(Song song) {
        entityManager.persist(song);
    }

    @Override
    public void update(Song song) {
        entityManager.merge(song);
    }

    @Override
    public void delete(String id) {
        Song song = findById(id);
        entityManager.remove(song);
    }
}
