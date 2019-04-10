package smartCardUniversity.SHARED.security.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import smartCardUniversity.SHARED.model.entity.AppUser;
import smartCardUniversity.SHARED.model.entity.Role;
import smartCardUniversity.SHARED.repositories.AppUserRepository;
import smartCardUniversity.SHARED.utils.EncryptedPasswordUtils;

@Service
public class UserDetailsServiceImplement implements UserDetailsService 
{

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AppUserRepository appUserRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		AppUser appUser = getUserByEmail(email);

		if(appUser == null)
		{
			LOGGER.error("Email not found! " + email);
			throw new UsernameNotFoundException("Email " + email + " was not found");
		}
		LOGGER.info("Found email: " + appUser.getEmail().toString());
		
		Role role = this.getUserRole(appUser);
		LOGGER.info("User Role is " + role);
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		//List<Role> roles = new ArrayList<>();
		
		GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole().toString());
		grantList.add(authority);
		
		UserDetails userDetails = (UserDetails) new User(appUser.getEmail(), EncryptedPasswordUtils.encrytePassword(appUser.getPassword()),grantList);
			
		return userDetails;
	}

	private AppUser getUserByEmail(String email) 
	{
		Iterable<AppUser> appUserList = appUserRepo.findAll();
		for(AppUser appUser : appUserList)
		{
			LOGGER.info(appUser.getEmail() + " " +email);
			if(appUser.getEmail().equals(email))
				return appUser;
		}
		return null;
	}
	private Role getUserRole(AppUser appUser)
	{
		if(appUser != null)
		{
			return appUser.getUserRole();
		}
		return null;
	}

}
