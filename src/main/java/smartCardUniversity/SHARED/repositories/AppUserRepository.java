package smartCardUniversity.SHARED.repositories;

import org.springframework.data.repository.CrudRepository;

import smartCardUniversity.SHARED.model.entity.AppUser;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    AppUser findByEmail(String email);

    @Override
    void delete(AppUser user);
}
