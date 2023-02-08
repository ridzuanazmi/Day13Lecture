package ibf2022.ssf.day13.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {

    // fields
    @NotEmpty(message = "Mandatory field")
    @Size(min = 2, max = 150, message = "Between 2 to 150 characters")
    private String firstName;

    @NotEmpty(message = "Mandatory field")
    @Size(min = 2, max = 150, message = "Between 2 to 150 characters")
    private String lastName;

    @Email(message = "Invalid email format")
    @Size(max = 120)
    @Pattern(regexp = ".+@.+\\..+", message = "Wrong email format")
    @NotBlank(message = "Emaill is a mandatory field")
    private String email;

    @Pattern(regexp = "(\\8|9)[0-9]{7}", message = "Invalid phone number")
    private String phoneNo;

    @Min(value = 1500, message = "Min salary starts from $1500")
    @Max(value = 400000, message = "Max salary $400,000")
    private Integer salary;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthday;

    private String address;

    @Digits(fraction = 0, integer = 6, message = "Postal code format = (123456)")
    private Integer postalCode;


    // constructors
    public Employee() {
    }

    public Employee(String firstName, String lastName, String address, String email, String phoneNo, Integer salary,
            Date birthday, Integer postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
        this.salary = salary;
        this.birthday = birthday;
        this.postalCode = postalCode;
    }

    // getters/setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", email="
                + email + ", phoneNo=" + phoneNo + ", salary=" + salary + ", birthday=" + birthday + ", postalCode="
                + postalCode + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phoneNo == null) ? 0 : phoneNo.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Employee other = (Employee) obj;

        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;

        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;

        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;

        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;

        if (phoneNo == null) {
            if (other.phoneNo != null)
                return false;
        } else if (!phoneNo.equals(other.phoneNo))
            return false;

        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;

        if (birthday == null) {
            if (other.birthday != null)
                return false;
        } else if (!birthday.equals(other.birthday))
            return false;

        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;

        return true;
    }
    
}
