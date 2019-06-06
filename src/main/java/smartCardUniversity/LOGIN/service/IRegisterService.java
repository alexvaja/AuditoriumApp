package smartCardUniversity.LOGIN.service;

import smartCardUniversity.LOGIN.exception.UserAlreadyExistException;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;
import smartCardUniversity.SHARED.model.entity.Register;

public interface IUserService {

	Register getUserAppFromDTO(RegisterDTO registerDTO);
	
	Register registerNewUserAccount(RegisterDTO accountDTO)     
		      throws UserAlreadyExistException;
}
