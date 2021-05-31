package kodlamaio.hrms.mernis;

public interface EmailValidateService {
	boolean isEmailCheckRegex(String email);
	boolean isEmailCheck(String email);
}
