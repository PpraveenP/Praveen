package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerete {
	
	@Test()
	void fakedataGenerat()
	{
		Faker fk=new Faker();
		 String fullname=fk.name().fullName();
		 System.out.println("fullname is==>  "+fullname);
		 String name=fk.name().firstName();
		 System.out.println("name is==> "+name);
		 String address=fk.address().cityName();
		 System.out.println("adress is==> "+address);
	}
}
