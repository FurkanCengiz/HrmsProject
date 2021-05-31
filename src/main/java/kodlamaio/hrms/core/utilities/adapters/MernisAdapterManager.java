package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

@Service
public class MernisAdapterManager implements MernisService{

	@Override
	public boolean userCheck(String nationaltyId, String firstName, String lastName, String birtDate) {
		if(nationaltyId.length() !=11 && firstName.length()<2 && lastName.length()<2 && birtDate.length()!=4) {
			System.out.println("Mernis doğrulanamadı.");
			return false;
		}else {
			return true;
		}
	
	}

}
