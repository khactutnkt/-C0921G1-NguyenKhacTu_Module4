package vn.codegym.validate_form_dang_ky.dto;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.*;

public class UserDto {

    @NotBlank(message = "First name cannot be blank")
    @Size(min = 5, max = 45, message = "First name with 5 to 45 characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 5, max = 45, message = "Last name with 5 to 45 characters")
    private String lastName;

    @NotNull(message = "Age cannot be blank")
    @Min(value = 18, message = "age must be greater than or equal to 18")
    private Integer age;

    private String gender;

    @Pattern(regexp = "^(0|\\(84\\)\\+)\\d{10}$", message = "Enter the correct phone number format, 0xxxxxxxxxx or (84)+xxxxxxxxx")
    private String phone;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter the correct email format")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, Integer age, String gender, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
