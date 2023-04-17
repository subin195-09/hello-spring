package com.porting.asset;

import com.porting.asset.domain.Asset;
import com.porting.asset.repository.AssetJpaRepository;
import com.porting.asset.repository.AssetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.*;

import javax.transaction.Transactional;

@SpringBootTest
@Rollback(false)
public class AssetJpaRepositoryTest {

    @Autowired
    AssetJpaRepository assetJpaRepository;

    @Autowired
    AssetRepository assetRepository;

    @Test
    @Transactional
    public void testAsset() throws Exception{
        Asset asset = new Asset();
        asset.setTenant("sbkim");
        asset.setKey("test.jpg");
        asset.setInfo("{type: img-presigned-url}");
        asset.setDataset("test_dataset");

        Asset saveAsset = assetJpaRepository.save(asset);

        Asset findAsset = assetJpaRepository.find(saveAsset.getId());

        assertThat(findAsset.getId()).isEqualTo(asset.getId());
        assertThat(findAsset.getTenant()).isEqualTo(asset.getTenant());
        assertThat(findAsset.getKey()).isEqualTo(asset.getKey());
        assertThat(findAsset.getInfo()).isEqualTo(asset.getInfo());
        assertThat(findAsset.getDataset()).isEqualTo(asset.getDataset());
    }


    @Test
    @Transactional
    public void testAssetJpaRepo() throws Exception{
        Asset asset = new Asset();
        asset.setTenant("sbkim2");
        asset.setKey("test2.jpg");
        asset.setInfo("{type: img-presigned-url}");
        asset.setDataset("test_dataset");

        Asset saveAsset = assetRepository.save(asset);

        Asset findAsset = assetRepository.findById(saveAsset.getId()).get();

        assertThat(findAsset.getId()).isEqualTo(asset.getId());
        assertThat(findAsset.getTenant()).isEqualTo(asset.getTenant());
        assertThat(findAsset.getKey()).isEqualTo(asset.getKey());
        assertThat(findAsset.getInfo()).isEqualTo(asset.getInfo());
        assertThat(findAsset.getDataset()).isEqualTo(asset.getDataset());
    }
}
