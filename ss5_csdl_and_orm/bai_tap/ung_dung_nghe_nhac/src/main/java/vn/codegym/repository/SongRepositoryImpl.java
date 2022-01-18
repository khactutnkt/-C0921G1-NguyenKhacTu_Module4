package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import vn.codegym.model.Song;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepositoryImpl implements ISongRepository {


    @Override
    public List<Song> findAll() {
        /* Dùng TypeQuery*/
        TypedQuery<Song> query = ConnectionUtil.entityManager
                .createQuery("select s from Song as s", Song.class);
        return query.getResultList();
    }

    @Override
    public void save(Song song) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (song.getId() == null){
                session.save(song);
            }else {
                Song song1 = findById(song.getId());
                song1.setId(song.getId());
                song1.setName(song.getName());
                song1.setSinger(song.getSinger());
                song1.setKindOfMusic(song.getKindOfMusic());
                session.saveOrUpdate(song1);
            }
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }   finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Song findById(Integer id) {
        TypedQuery<Song> query = ConnectionUtil.entityManager
                .createQuery("select s from Song as s where s.id = :id", Song.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void remove(Integer id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.createNativeQuery("delete from Song where id = ?").setParameter(1,id).executeUpdate();
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
    }
}
