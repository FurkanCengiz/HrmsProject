package kodlamaio.hrms.core.utilities.adapters;

import java.sql.Date;

public interface MernisService {
	boolean userCheck(String nationaltyId ,String firstName,String lastName,String birthDate);
}
