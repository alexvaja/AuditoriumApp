package smartCardUniversity.LOGIN.service;

import java.util.ArrayList;
import java.util.List;

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
@Transactional
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

	@Override
	public AppUser registerNewUserAccount(RegisterDTO accountDTO) throws UserAlreadyExistException {

		if (emailExists(accountDTO.getEmail())) {
			throw new UserAlreadyExistException(
					"There is an account with that email address: " + accountDTO.getEmail());
		}

		AppUser registerUser = new AppUser();
		registerUser.setEmail(accountDTO.getEmail());
		registerUser.setPassword(accountDTO.getPassword());
		registerUser.setUserCollege(getCollegeById(accountDTO.getCollege()));
		registerUser.setUserRole(getEmailRole(accountDTO.getEmail()));
		System.out.println("AM TERMINAT DE CREAT USER-ul: " + registerUser);
		return appUserRepository.save(registerUser);
	}

	private boolean emailExists(String email) {

		AppUser user = appUserRepository.findByEmail(email);

		if (user != null) {
			return true;
		}

		return false;
	}
	
	private College getCollegeById(Integer id) {
		System.out.println("COLEGII:");
		List<College> cc = getColleagues();
		for (College college : cc) {
			if (college.getId() == id) {
				System.out.println(college);
				return college;
			}
		}
		 
		return null; 
	}
	
	
	private Role getEmailRole(String email) {
		//TODO
		return roleRepository.findById(1).get();
	}

	@Override
	public void createVerificationTokenForUser(AppUser user, String token) {
		System.out.println("Salvare token");
		VerificationToken newToken = new VerificationToken(token, user);
		System.out.println("TOKENUL FORMAT: " + newToken);
		tokenRepository.save(newToken);
	}

	@Override
	public VerificationToken getVerificationToken(String token) {
		return tokenRepository.findByToken(token);
	}

	public void saveRegisteredUser(AppUser user) {
		appUserRepository.save(user);
	}

	@Override
	public List<College> getColleagues() {
		Iterable<College> c = collegeRepository.findAll();
		List<College> listOfColleaguesFromDB = new ArrayList<>();
		
		for (College college : c) {
			listOfColleaguesFromDB.add(college);
		}
		
		return listOfColleaguesFromDB;
	}
}
