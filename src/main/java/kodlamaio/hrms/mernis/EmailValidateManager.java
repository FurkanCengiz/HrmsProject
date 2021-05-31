package kodlamaio.hrms.mernis;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
@Service
public class EmailValidateManager implements EmailValidateService {

	@Override
	public boolean isEmailCheckRegex(String email) {
		Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
		
	}

	@Override
	public boolean isEmailCheck(String email) {
		System.out.println("Email doğrulandı"+ email);
		return true;
	}

}
