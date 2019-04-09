package HomeWork;

import java.util.Objects;

public class Student {
	
	private int id;
	private String firstName, lastName;
	private boolean paidFees;
	
	public Student(int id, String firstName, String lastName, boolean paidFees) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.paidFees = paidFees;
	}
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public boolean hasPaidFees() {
		return paidFees;
	}
	public String toString() {
		return firstName + " " + lastName + " (ID: " + id + ")" + ( paidFees ? "" : " (Fees Owed)");
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj instanceof Student){
			Student otherStudent = (Student) obj;
			if (this.id == otherStudent.id && this.firstName.equalsIgnoreCase(otherStudent.firstName)
				&& this.lastName.equalsIgnoreCase(otherStudent.lastName) && this.paidFees == otherStudent.paidFees){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,firstName.toLowerCase(),lastName.toLowerCase(),paidFees);
	}


}
