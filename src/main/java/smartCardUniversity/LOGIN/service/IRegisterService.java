package smartCardUniversity.LOGIN.service;

import smartCardUniversity.LOGIN.exception.UserAlreadyExistException;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;
import smartCardUniversity.SHARED.model.entity.AppUser;
import smartCardUniversity.SHARED.model.entity.VerificationToken;

public interface IRegisterService {

	AppUser getUserAppFromDTO(RegisterDTO registerDTO);
	
	AppUser registerNewUserAccount(RegisterDTO accountDTO)     
		      throws UserAlreadyExistException;

	void createVerificationTokenForUser(AppUser user, String token);

	VerificationToken getVerificationToken(String token);
	
	void saveRegisteredUser(AppUser user);
}
