package pl.javastart.equipy.components.inventory.asset;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/assets")
public class AssetResource {

    private AssetService assetService;

    @GetMapping("")
    public List<AssetDto> findAll(@RequestParam(required = false) String text) {
        if(text != null)
            return assetService.findAllAssetsByNameOrSerialNumber(text);
        else
            return assetService.findAll();
    }
}
