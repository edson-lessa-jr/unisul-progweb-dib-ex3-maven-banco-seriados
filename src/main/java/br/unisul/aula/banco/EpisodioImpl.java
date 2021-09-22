package br.unisul.aula.banco;

import br.unisul.aula.entidades.Episodio;

import javax.persistence.EntityManager;
import java.util.List;

public class EpisodioImpl implements CrudDoBanco<Episodio>{
    @Override
    public void insert(Episodio episodio) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(episodio);
        entityManager.getTransaction().commit();

    }

    @Override
    public void remove(Episodio episodio) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.getReference(Episodio.class, episodio.getId()));
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Episodio episodio) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Episodio episodioEncontrado = findById(episodio.getId());
        episodioEncontrado.setNumero(episodio.getNumero());
        episodioEncontrado.setResumo(episodio.getResumo());
        episodioEncontrado.setNome(episodio.getNome());
        episodioEncontrado.setTemporada(episodio.getTemporada());
        entityManager.merge(episodioEncontrado);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Episodio> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager.createQuery("SELECT t FROM Episodio t", Episodio.class).getResultList();
    }

    @Override
    public Episodio findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager.find(Episodio.class, id);
    }
}
