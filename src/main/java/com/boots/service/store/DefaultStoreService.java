package com.boots.service.store;

import com.boots.dto.StoreDTO;
import com.boots.entity.Store;
import com.boots.exception.ValidationException;
import com.boots.repository.StoreRepository;
import com.boots.converter.StoreConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class DefaultStoreService implements StoreService {

    private final StoreRepository storeRepository;
    private final StoreConverter storeConverter;


    @Override
    public StoreDTO saveStore(StoreDTO storeDTO) throws ValidationException {
        validateStoreDto(storeDTO);
        Store savedProduct = storeRepository.save(storeConverter.fromStoreDTOToStore(storeDTO));
        return storeConverter.fromStoreToStoreDTO(savedProduct);
    }

    private void validateStoreDto(StoreDTO storeDTO) throws ValidationException {
        if (isNull(storeDTO)) {
            throw new ValidationException("Object store is null");
        }
        if (isNull(storeDTO.getId())) {
            throw new ValidationException("Store_id is empty");
        }
    }

    @Override
    public void deleteStore(Integer Id) {
        storeRepository.deleteById(Id);
    }

    @Override
    public StoreDTO findById(Integer Id) {
        Store store = storeRepository.findByStore_id(Id);
        if (store != null) {
            return storeConverter.fromStoreToStoreDTO(store);
        }
        return null;
    }

    @Override
    public List<StoreDTO> findAll() {
        return storeRepository.findAll()
                .stream()
                .map(storeConverter::fromStoreToStoreDTO)
                .collect(Collectors.toList());
    }
}

