package smartCardUniversity.LOGIN.models.DTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import smartCardUniversity.LOGIN.customValidator.annotation.PasswordMatches;
import smartCardUniversity.LOGIN.customValidator.annotation.ValidEmail;

@PasswordMatches
public class RegisterDTO {

	@NotNull @NotEmpty @ValidEmail
	private String email;
	
	@NotNull @NotEmpty
	private String password;
	
	@NotNull @NotEmpty
	private String matchingPassword;
	
	@NotNull
	private Integer college;
	
	@NotNull
	private boolean checked;
	
	public RegisterDTO() {
		super();
	}	
	
	public RegisterDTO(@NotNull @NotEmpty String email, @NotNull @NotEmpty String password,
			@NotNull @NotEmpty String matchingPassword, @NotNull Integer college,
			@NotNull boolean checked) {
		super();
		this.email = email;
		this.password = password;
		this.matchingPassword = matchingPassword;
		this.college = college;
		this.checked = checked;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMatchingPassword() {
		return matchingPassword;
	}
	
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}
	
	public Integer getCollege() {
		return college;
	}
	
	public void setCollege(Integer college) {
		this.college = college;
	}
	
	public boolean isChecked() {
		return checked;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "RegisterDTO [" + email + ", " + password + ", " + matchingPassword
				+ ", " + college + ", " + checked + "]";
	}
}
