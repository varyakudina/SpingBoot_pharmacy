package com.boots.repository;

import com.boots.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer>{

    Store findByStore_id(Integer store_id);
}
