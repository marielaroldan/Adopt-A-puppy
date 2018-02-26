package se.tng.java4women.dataaccess;

import se.tng.java4women.domain.Puppy;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DataAccessPuppies {

    @PersistenceContext
    private EntityManager em;

    public List<Puppy> showAllpuppies() {
        Query q = em.createNativeQuery("select * from puppy");
        return q.getResultList();
    }

    public Puppy getPuppyById(long id) {
        Puppy p = em.find(Puppy.class, id);

        return p;
    }

    public void addPuppy(Puppy puppy) {
        em.persist(puppy);
    }

    public void delete(Puppy puppy) {
        em.remove(em.merge(puppy));
    }

    public void deleteById(long id) {
        em.remove(em.find(Puppy.class, id));
    }

    public void updatePuppies(Puppy puppy) {
        em.merge(puppy);
    }

}
