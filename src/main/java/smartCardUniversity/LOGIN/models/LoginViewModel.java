package smartCardUniversity.LOGIN.models;
import smartCardUniversity.LOGIN.models.DTO.AppUserDTO;

public class LoginViewModel
{
	private AppUserDTO userDTO;
	
	public LoginViewModel()
	{
		super();
	}
	public LoginViewModel(AppUserDTO userDTO) {
		super();
		this.userDTO = userDTO;
	}
	public AppUserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(AppUserDTO userDTO) {
		this.userDTO = userDTO;
	}
	@Override
	public String toString() {
		return "LoginViewModel [userDTO=" + userDTO + "]";
	}
}
