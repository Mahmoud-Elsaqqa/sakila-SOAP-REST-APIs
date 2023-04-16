package gov.iti.jets;

import gov.iti.jets.model.constant.FilmRating;
import gov.iti.jets.model.constant.Language;
import gov.iti.jets.model.dto.FullName;
import gov.iti.jets.model.dto.inventory.ActorModel;
import gov.iti.jets.model.dto.inventory.FilmModel;
import gov.iti.jets.model.entity.inventory.*;
import gov.iti.jets.model.mapping.mapper.ActorMapper;
import gov.iti.jets.model.mapping.mapper.FilmMapper;
import gov.iti.jets.util.EntityManagerHelper;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
//
//        LanguageEntity languageEntity = entityManager.getReference(LanguageEntity.class, Language.ENGLISH);
//
//
//        FilmModel filmModel = FilmModel.builder()
//                .description("Whatever")
//                .lastUpdate(LocalDateTime.now())
//                .rating(FilmRating.PG_13)
//                .releaseYear(LocalDate.now().getYear())
//                .title("FILM")
//                .rentalDuration(21)
//                .length(23)
//                .replacementCost(BigDecimal.TEN)
//                .rentalRate(BigDecimal.valueOf(23))
//                .build();
//        FilmEntity filmEntity = FilmMapper.INSTANCE.mapToEntity(filmModel);
//        filmEntity.setLanguageByLanguageId(languageEntity);
//        filmEntity.setLanguageByOriginalLanguageId(languageEntity);
//
//        languageEntity.getFilmsByLanguageId().add(filmEntity);
//        languageEntity.getFilmsByOriginalLanguageId().add(filmEntity);
//
//        ActorModel actorModel = ActorModel.builder()
//                .fullName(new FullName().builder()
//                        .firstName("Mahmoud")
//                        .lastName("Saqqa")
//                        .build())
//                .lastUpdate(LocalDateTime.now())
//                .build();
//        ActorEntity actorEntity = ActorMapper.INSTANCE.mapToEntity(actorModel);
//
//
//        FilmActorEntity filmActorEntity = FilmActorEntity.builder()
//                .filmByFilmId(filmEntity)
//                .actorByActorId(actorEntity)
//                .build();
//        System.out.println(filmActorEntity);
//        EntityManagerHelper.beginTransaction();
//        entityManager.persist(actorEntity);
//        entityManager.persist(filmEntity);

//        filmActorEntity.setActorByActorId(actorEntity);
//        filmActorEntity.setFilmByFilmId(filmEntity);
//        entityManager.persist(filmActorEntity);
//        actorEntity.addFilmActorsByActorId(filmActorEntity);
//        filmEntity.getFilmActorsByFilmId().add(filmActorEntity);

//
//        FilmActorEntityPK filmActorEntityPK = new FilmActorEntityPK(1,1);
//        FilmActorEntity filmActorEntity1 = entityManager.find(FilmActorEntity.class, filmActorEntityPK);
//        System.out.println(filmActorEntity1);

        ActorEntity queryActor = entityManager.getReference(ActorEntity.class, 32);
        Collection<FilmActorEntity> filmActorsByActorId = queryActor.getFilmActorsByActorId();
        filmActorsByActorId.forEach(filmActorEntity2 -> System.out.println(FilmMapper.INSTANCE.mapToDto(filmActorEntity2.getFilmByFilmId())));


//        EntityManagerHelper.commit();
    }
}
