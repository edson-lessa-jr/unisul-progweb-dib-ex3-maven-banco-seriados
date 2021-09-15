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
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.getReference(Seriado.class, seriado.getId()));
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Seriado seriado) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Seriado seriadoEncontrado = findById(seriado.getId());
        seriadoEncontrado.setNome(seriado.getNome());
        seriadoEncontrado.setDescricao(seriado.getDescricao());
        seriadoEncontrado.setDataLancamento(seriadoEncontrado.getDataLancamento());
        entityManager.merge(seriadoEncontrado);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Seriado> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager.createQuery("SELECT s FROM Seriado s", Seriado.class).getResultList();
    }

    @Override
    public Seriado findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        return entityManager.find(Seriado.class, id);
    }
}
