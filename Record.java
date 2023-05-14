package Assessment3;

public class Record {
	private String name, birthday, phoneNumber, address;

	public Record(String name, String birthday, String phoneNumber, String address) {
		this.name = name;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

    public Record() {};

// getting and setting the variables here
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return name + "\n" + birthday + "\n" + phoneNumber + "\n" + address;
	}

}
