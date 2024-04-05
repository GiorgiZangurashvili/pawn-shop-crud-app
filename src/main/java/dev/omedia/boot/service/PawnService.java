package dev.omedia.boot.service;

import dev.omedia.boot.domain.*;
import dev.omedia.boot.dto.PawnCarDTO;
import dev.omedia.boot.dto.PawnItemDTO;
import dev.omedia.boot.dto.PawnJeweleryDTO;
import dev.omedia.boot.dto.PawnTechnologyDTO;
import dev.omedia.boot.exception.EntityNotFoundException;
import dev.omedia.boot.exception.IllegalAmountException;
import dev.omedia.boot.exception.ItemIsConfiscatedException;
import dev.omedia.boot.exception.ItemIsTakenException;
import dev.omedia.boot.mapper.PawnCarMapper;
import dev.omedia.boot.mapper.PawnItemMapper;
import dev.omedia.boot.mapper.PawnJeweleryMapper;
import dev.omedia.boot.mapper.PawnTechnologyMapper;
import dev.omedia.boot.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PawnService {
    private final PawnItemRepository pawnItemRepository;
    private final PawnJeweleryRepository pawnJeweleryRepository;
    private final PawnCarRepository pawnCarRepository;
    private final PawnTechnologyRepository pawnTechnologyRepository;
    private final BranchRepository branchRepository;
    private final BrandEntityRepository brandRepository;
    private final GemEntityRepository gemRepository;
    private final TechnologyEntityRepository technologyRepository;
    private final FirmEntityRepository firmRepository;
    private final PawnItemMapper itemMapper;
    private final PawnCarMapper carMapper;
    private final PawnJeweleryMapper jeweleryMapper;
    private final PawnTechnologyMapper technologyMapper;

    public ArrayList<PawnItemDTO> findAll() {
        ArrayList<PawnItemDTO> items = new ArrayList<>();
        pawnItemRepository
                .findAll()
                .forEach(item -> {
                    if (item instanceof PawnCar) {
                        items.add(carMapper.map((PawnCar) item));
                    } else if (item instanceof PawnJewelery) {
                        items.add(jeweleryMapper.map((PawnJewelery) item));
                    } else if (item instanceof PawnTechnology) {
                        items.add(technologyMapper.map((PawnTechnology) item));
                    } else {
                        items.add(itemMapper.map(item));
                    }
                });
        return items;
    }

    public PawnItemDTO save(PawnItemDTO dto) {
        dto.setId(0);
        dto.setPawnDate(LocalDate.now());
        dto.setBranch(branchRepository.findById(dto.getBranchId())
                .orElseThrow(() -> new EntityNotFoundException("Branch", dto.getBranchId())));
        dto.setPaidAmount(0);
        dto.setTakenOut(false);
        dto.setConfiscated(false);
        if (dto instanceof PawnCarDTO) {
            var pawnCarDTO = (PawnCarDTO) dto;
            pawnCarDTO.setBrand(brandRepository.findById(pawnCarDTO.getBrandId())
                    .orElseThrow(() -> new EntityNotFoundException("Brand", pawnCarDTO.getBrandId())));
            PawnCar pawnCar = carMapper.map(pawnCarDTO);
            pawnCarRepository.save(pawnCar);
            return pawnCarDTO;
        } else if (dto instanceof PawnJeweleryDTO) {
            var pawnJeweleryDTO = (PawnJeweleryDTO) dto;
            Set<Long> gemIds = pawnJeweleryDTO.getUsedGemEntityIds();
            Set<GemEntity> gems = new HashSet<>();
            gemIds.forEach(id -> gems.add(gemRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Gem", id))));
            pawnJeweleryDTO.setUsedGemEntities(gems);
            PawnJewelery pawnJewelery = jeweleryMapper.map(pawnJeweleryDTO);
            pawnJeweleryRepository.save(pawnJewelery);
            return pawnJeweleryDTO;
        } else if (dto instanceof PawnTechnologyDTO) {
            var pawnTechnologyDTO = (PawnTechnologyDTO) dto;
            pawnTechnologyDTO.setTechnologyType(technologyRepository.findById(pawnTechnologyDTO.getTechnologyTypeId())
                    .orElseThrow(() -> new EntityNotFoundException("Technology Type", pawnTechnologyDTO.getTechnologyTypeId())));
            pawnTechnologyDTO.setFirmName(firmRepository.findById(pawnTechnologyDTO.getFirmId())
                    .orElseThrow(() -> new EntityNotFoundException("Firm", pawnTechnologyDTO.getFirmId())));
            if (!pawnTechnologyDTO.isDamaged()) {
                pawnTechnologyDTO.setDamageDescription("");
            }
            PawnTechnology pawnTechnology = technologyMapper.map(pawnTechnologyDTO);
            pawnTechnologyRepository.save(pawnTechnology);
            return pawnTechnologyDTO;
        }
        PawnItem pawnItem = itemMapper.map(dto);
        pawnItemRepository.save(pawnItem);

        return dto;
    }

    public PawnItemDTO pay(long id, int amount) {
        PawnItem item = pawnItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PawnItem", id));
        if (item.isTakenOut()) {
            throw new ItemIsTakenException();
        }
        if (item.isConfiscated()) {
            throw new ItemIsConfiscatedException();
        }
        if (amount <= 0) {
            throw new IllegalAmountException();
        }
        item.setId(id);
        item.setPaidAmount(item.getPaidAmount() + amount);
        if (item.getPaidAmount() >= item.getFullFee()) {
            item.setTakenOut(true);
        }
        pawnItemRepository.save(item);

        if (item instanceof PawnCar) {
            return carMapper.map((PawnCar) item);
        } else if (item instanceof PawnTechnology) {
            return technologyMapper.map((PawnTechnology) item);
        } else if (item instanceof PawnJewelery) {
            return jeweleryMapper.map((PawnJewelery) item);
        }
        return itemMapper.map(item);
    }
}
