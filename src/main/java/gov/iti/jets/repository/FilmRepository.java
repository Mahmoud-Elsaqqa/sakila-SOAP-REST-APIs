package gov.iti.jets.repository;

import gov.iti.jets.model.constant.Category;
import gov.iti.jets.model.entity.inventory.FilmEntity;
import gov.iti.jets.util.EntityManagerHelper;

import java.util.List;

public class FilmRepository extends CrudRepositoryImpl<FilmEntity, Integer> {

    public FilmRepository(Class<FilmEntity> entityClass) {
        super(entityClass);
    }

    public List<FilmEntity> findAllFilmsByActorId(Integer actorId) {
        return
                EntityManagerHelper.getEntityManager()
                        .createQuery("SELECT filmByFilmId FROM film_actor where actorId = :id", FilmEntity.class)
                        .setParameter("id", actorId)
                        .getResultList();
    }

//    private static List<ActorFilmDetailModel> briefFilmDetailsForActor(Integer actorId) {
//        return
//                EntityManagerHelper.getEntityManager()
//                        .createQuery("SELECT NEW gov.iti.jets.model.dto.response.ActorFilmDetailModel" +
//                                "(fa.filmByFilmId.id, fa.filmByFilmId.title, fa.filmByFilmId.description," +
//                                " fa.filmByFilmId.length, fa.filmByFilmId.rating)" +
//                                "FROM film_actor fa WHERE fa.actorId=:id", ActorFilmDetailModel.class)
//                        .setParameter("id", actorId)
//                        .getResultList();
//    }

    public List<FilmEntity> getFilmsByCategory(Category cat) {
        return
                EntityManagerHelper.getEntityManager()
                        .createQuery("SELECT fc.filmByFilmId FROM film_category fc WHERE fc.categoryId =:cat"
                                , FilmEntity.class)
                        .setParameter("cat", cat)
                        .getResultList();
    }
}
