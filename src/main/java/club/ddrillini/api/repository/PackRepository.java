package club.ddrillini.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import club.ddrillini.api.model.Pack;

public interface PackRepository extends CrudRepository<Pack, Long> {
    List<Pack> findAll();
}
