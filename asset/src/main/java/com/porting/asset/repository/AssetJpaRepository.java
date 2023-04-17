package com.porting.asset.repository;

import com.porting.asset.domain.Asset;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Repository
public class AssetJpaRepository {

    @PersistenceContext // Entity Manager 를 bean 으로 주입할 때
    private EntityManager em;

    public Asset save(Asset asset) {
        em.persist(asset);
        return asset;
    }

    public Asset find(UUID id) {
        return em.find(Asset.class, id);
    }

}
