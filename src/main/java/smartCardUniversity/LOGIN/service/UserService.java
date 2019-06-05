package smartCardUniversity.LOGIN.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartCardUniversity.LOGIN.exception.UserAlreadyExistException;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;
import smartCardUniversity.SHARED.model.entity.College;
import smartCardUniversity.SHARED.model.entity.Register;
import smartCardUniversity.SHARED.model.entity.Role;
import smartCardUniversity.SHARED.repositories.AppUserRepository;
import smartCardUniversity.SHARED.repositories.RegisterRepository;
import smartCardUniversity.SHARED.repositories.RoleRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	@Autowired
	private RegisterRepository registerRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Register getUserAppFromDTO(RegisterDTO registerDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public Register registerNewUserAccount(RegisterDTO accountDTO) throws UserAlreadyExistException {
		System.out.println("AM INTRAT IN SALVARE");
		Register registerUser = new Register();
		System.out.println("1");
		registerUser.setEmail(accountDTO.getEmail());
		System.out.println("2");
		registerUser.setRegisterCollege(new College());
		System.out.println("3");
		registerUser.setRegisterRole(new Role());
		System.out.println("4");
		registerUser.setPassword(accountDTO.getPassword());
		System.out.println("5");
		registerUser.setChecked(false);
		System.out.println("6");
		return registerRepository.save(registerUser);
	}
	
	private boolean emailExists(String email) {
		
		return false;
	}

}
