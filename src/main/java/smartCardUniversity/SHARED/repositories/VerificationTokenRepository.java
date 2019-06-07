package smartCardUniversity.SHARED.repositories;

import org.springframework.data.repository.CrudRepository;

import smartCardUniversity.SHARED.model.entity.VerificationToken;

public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Integer>{

}
