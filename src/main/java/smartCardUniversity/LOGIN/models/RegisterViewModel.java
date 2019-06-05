package smartCardUniversity.LOGIN.models;

import java.util.List;

import javax.validation.Valid;

import smartCardUniversity.LOGIN.customValidator.annotation.ValidRegisterVM;
import smartCardUniversity.LOGIN.models.DTO.RegisterDTO;
import smartCardUniversity.SHARED.model.entity.College;

@ValidRegisterVM
public class RegisterViewModel {

	private RegisterDTO registerDTO;
	
	private List<College> listOfColleges;

	public RegisterViewModel() {
		super();
	}

	public RegisterViewModel(RegisterDTO registerDTO, List<College> listOfColleges) {
		super();
		this.registerDTO = registerDTO;
		this.listOfColleges = listOfColleges;
	}

	public RegisterDTO getRegisterDTO() {
		return registerDTO;
	}

	public void setRegisterDTO(RegisterDTO registerDTO) {
		this.registerDTO = registerDTO;
	}

	public List<College> getListOfColleges() {
		return listOfColleges;
	}

	public void setListOfColleges(List<College> listOfColleges) {
		this.listOfColleges = listOfColleges;
	}

	@Override
	public String toString() {
		return "RegisterViewModel [" + registerDTO + ", " + listOfColleges + "]";
	}
}
