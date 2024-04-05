package dev.omedia.boot.datainitializer;

import dev.omedia.boot.domain.*;
import dev.omedia.boot.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BranchRepository branchRepository;
    private final BrandEntityRepository brandRepository;
    private final FirmEntityRepository firmRepository;
    private final GemEntityRepository gemRepository;
    private final TechnologyEntityRepository technologyRepository;

    @Override
    public void run(String... args) throws Exception {
        if (branchRepository.count() == 0) {
            saveBranches();
        }
        if (brandRepository.count() == 0) {
            saveBrands();
        }
        if (firmRepository.count() == 0) {
            saveFirms();
        }
        if (gemRepository.count() == 0) {
            saveGems();
        }
        if (technologyRepository.count() == 0) {
            saveTechnologyTypes();
        }
    }

    private void saveBranches() {
        saveBranch("Tbilisi Mall");
        saveBranch("East Point");
        saveBranch("Tbilisi Central");
    }

    private void saveBranch(String branchName) {
        Branch branch = new Branch();
        branch.setName(branchName);
        branchRepository.save(branch);
    }

    private void saveBrands() {
        saveBrand("Audi");
        saveBrand("BMW");
        saveBrand("Mercedes");

    }

    private void saveBrand(String brandName) {
        BrandEntity brand = new BrandEntity();
        brand.setName(brandName);
        brandRepository.save(brand);
    }

    private void saveFirms() {
        saveFirm("Toshiba");
        saveFirm("Panasonic");
        saveFirm("Asus");
    }

    private void saveFirm(String firmName) {
        FirmEntity firm = new FirmEntity();
        firm.setFirmName(firmName);
        firmRepository.save(firm);
    }

    private void saveGems() {
        saveGem("GOLD");
        saveGem("SILVER");
        saveGem("BRONZE");
    }

    private void saveGem(String gemType) {
        GemEntity gem = new GemEntity();
        gem.setGemType(gemType);
        gemRepository.save(gem);
    }

    private void saveTechnologyTypes() {
        saveTechnologyType("Dishwasher");
        saveTechnologyType("Computer");
        saveTechnologyType("Laptop");
    }

    private void saveTechnologyType(String technologyType) {
        TechnologyEntity technology = new TechnologyEntity();
        technology.setTechnologyType(technologyType);
        technologyRepository.save(technology);
    }
}
