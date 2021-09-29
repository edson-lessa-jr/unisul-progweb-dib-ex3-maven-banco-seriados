package br.unisul.aula.banco;

import br.unisul.aula.entidades.Temporada;
import br.unisul.aula.entidades.Temporada;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class TemporadaImpl implements CrudDoBanco<Temporada>{
    @Override
    public void insert(Temporada temporada) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(temporada);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Temporada temporada = this.findById(id);
        entityManager.remove(entityManager.contains(temporada)? temporada:entityManager.merge(temporada));
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Temporada temporada) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(temporada);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Temporada> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();

        return entityManager
                .createQuery("SELECT t FROM Temporada t", Temporada.class)
                .getResultList();
    }

    @Override
    public Temporada findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<Temporada> query = entityManager
                .createQuery("SELECT t FROM Temporada t where t.id=:id",
                        Temporada.class);
        Temporada temporada = query.setParameter("id", id).getSingleResult();
        System.out.println(temporada);
        return temporada;
    }

    public Temporada buscaPorNumeroESeriado(Integer numero, Long idSeriado){
        EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<Temporada> query = entityManager
                .createQuery("SELECT t FROM Temporada t where t.numero=:numero and t.seriado.id=:seriado",
                        Temporada.class);
        Temporada temporada = query.setParameter("numero", numero)
                .setParameter("seriado", idSeriado).getSingleResult();
        return temporada;
    }

    public Temporada buscaPorNumeroESeriado(Integer numero, String nome){
        EntityManager entityManager = JPAUtil.getEntityManager();
        TypedQuery<Temporada> query = entityManager
                .createQuery("SELECT t FROM Temporada t where t.numero=:numero and t.seriado.nome=:nome"
                        , Temporada.class);
        Temporada temporada = query
                .setParameter("numero", numero)
                .setParameter("nome", nome)
                .getSingleResult();
        return temporada;

    }

}
