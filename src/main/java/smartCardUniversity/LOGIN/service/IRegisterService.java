package smartCardUniversity.LOGIN.service;

import smartCardUniversity.LOGIN.exception.UserAlreadyExistException;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;
import smartCardUniversity.SHARED.model.entity.AppUser;

public interface IRegisterService {

	AppUser getUserAppFromDTO(RegisterDTO registerDTO);
	
	AppUser registerNewUserAccount(RegisterDTO accountDTO)     
		      throws UserAlreadyExistException;
}
