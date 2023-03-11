package yk.springframework.intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yk.springframework.intro.domain.BookUuid;

import java.util.UUID;

public interface BookUUIDRepository extends JpaRepository <BookUuid, UUID> {
}
