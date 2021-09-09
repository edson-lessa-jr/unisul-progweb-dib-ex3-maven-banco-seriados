package br.unisul.aula.banco;

import br.unisul.aula.entidades.Seriado;

import javax.persistence.EntityManager;
import java.util.List;

public class SeriadoImpl implements CrudDoBanco<Seriado>{
    @Override
    public void insert(Seriado seriado) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(seriado);
        entityManager.getTransaction().commit();

    }

    @Override
    public void remove(Seriado seriado) {

    }

    @Override
    public void update(Seriado seriado) {

    }

    @Override
    public List<Seriado> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager.createQuery("SELECT s FROM Seriado s", Seriado.class).getResultList();
    }

    @Override
    public Seriado findById(Long id) {
        return null;
    }
}
