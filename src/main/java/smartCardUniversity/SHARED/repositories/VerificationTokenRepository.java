package smartCardUniversity.SHARED.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import smartCardUniversity.SHARED.model.entity.VerificationToken;

@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken, Integer>{

	VerificationToken findByToken(String token);

}
