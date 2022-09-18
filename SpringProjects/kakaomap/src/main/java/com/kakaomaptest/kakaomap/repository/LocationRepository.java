package com.kakaomaptest.kakaomap.repository;

import com.kakaomaptest.kakaomap.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,String> {
}
