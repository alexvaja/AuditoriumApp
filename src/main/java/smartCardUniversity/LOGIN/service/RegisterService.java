package smartCardUniversity.LOGIN.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartCardUniversity.LOGIN.exception.UserAlreadyExistException;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;
import smartCardUniversity.SHARED.model.entity.AppUser;
import smartCardUniversity.SHARED.model.entity.College;
import smartCardUniversity.SHARED.model.entity.Role;
import smartCardUniversity.SHARED.model.entity.VerificationToken;
import smartCardUniversity.SHARED.repositories.AppUserRepository;
import smartCardUniversity.SHARED.repositories.CollegeRepository;
import smartCardUniversity.SHARED.repositories.RoleRepository;
import smartCardUniversity.SHARED.repositories.VerificationTokenRepository;

@Service
public class RegisterService implements IRegisterService {

	@Autowired
	private AppUserRepository appUserRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	private CollegeRepository collegeRepository;
	
	@Autowired
	private VerificationTokenRepository tokenRepository;

	@Override
	public AppUser getUserAppFromDTO(RegisterDTO registerDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public AppUser registerNewUserAccount(RegisterDTO accountDTO) throws UserAlreadyExistException {

		if (!emailExists(accountDTO.getEmail())) {
			throw new UserAlreadyExistException(
					"There is an account with that email address: " + accountDTO.getEmail());
		}

		AppUser registerUser = new AppUser();
		registerUser.setEmail(accountDTO.getEmail());
		registerUser.setPassword(accountDTO.getPassword());
		registerUser.setUserCollege(getCollegeById(accountDTO.getCollege()));
		registerUser.setUserRole(getEmailRole(accountDTO.getEmail()));
		
		return appUserRepository.save(registerUser);
	}

	private boolean emailExists(String email) {

//		AppUser user = appUserRepository.findByEmail(email);
//
//		if (user != null) {
//			return true;
//		}

		return false;
	}
	
	private College getCollegeById(Integer id) {
		System.out.println("COLEGII:");
		
		Iterable<College> c = collegeRepository.findAll();
		
		for (College college : c) {
			System.out.println(college);
		}
		
		return collegeRepository.findById(id).get();
	}
	
	private Role getEmailRole(String email) {
		//TODO
		return roleRepository.findById(1).get();
	}

	@Override
	public void createVerificationTokenForUser(AppUser user, String token) {
		VerificationToken newToken = new VerificationToken(token, user);
		tokenRepository.save(newToken);
	}

	@Override
	public VerificationToken getVerificationToken(String token) {
		// TODO Auto-generated method stub
		return tokenRepository.findByToken(token);
	}

	public void saveRegisteredUser(AppUser user) {
		appUserRepository.save(user);
	}
}
