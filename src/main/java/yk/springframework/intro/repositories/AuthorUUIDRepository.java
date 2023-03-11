package yk.springframework.intro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import yk.springframework.intro.domain.AuthorUuid;

import java.util.UUID;

public interface AuthorUUIDRepository extends JpaRepository<AuthorUuid, UUID> {
}
