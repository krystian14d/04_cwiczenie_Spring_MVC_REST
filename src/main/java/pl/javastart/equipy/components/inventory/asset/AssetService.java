package pl.javastart.equipy.components.inventory.asset;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AssetService {
    private AssetRepository assetRepository;
    private AssetMapper assetMapper;

    List<AssetDto> findAllAssets() {
        return assetRepository.findAll()
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }

    List<AssetDto> findAllAssetsByNameOrSerialNumber(String text) {
        return assetRepository.findAllByNameOrSerialNumber(text)
                .stream()
                .map(assetMapper::toDto)
                .collect(Collectors.toList());
    }

    AssetDto saveAsset(AssetDto asset) {
        Optional<Asset> assetBySerialNumber = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetBySerialNumber.ifPresent(a -> {
            throw new DuplicateSerialNumberException();
        });
        return saveAndMapAsset(asset);
    }

    Optional<AssetDto> findAssetById(Long id) {
        return assetRepository.findById(id)
                .map(assetMapper::toDto);
    }

    AssetDto updateAsset(AssetDto asset) {
        Optional<Asset> assetBySerialNumber = assetRepository.findBySerialNumber(asset.getSerialNumber());
        assetBySerialNumber.ifPresent(a -> {
            throw new DuplicateSerialNumberException();
        });
        return saveAndMapAsset(asset);
    }

    private AssetDto saveAndMapAsset(AssetDto asset) {
        Asset assetEntity = assetMapper.toEntity(asset);
        Asset savedAsset = assetRepository.save(assetEntity);
        return assetMapper.toDto(savedAsset);
    }

    List<AssetAssigmentDto> getAssetAssignments(Long id){
        return assetRepository.findById(id)
                .map(Asset::getAssigments)
                .orElseThrow(AssetNotFoundException::new)
                .stream()
                .map(AssetAssigmentMapper::toDto)
                .collect(Collectors.toList());
    }
}
