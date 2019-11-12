package io.github.isandratskiy.rest.api.petstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Generated;

import static java.lang.Integer.*;
import static org.apache.commons.lang3.RandomStringUtils.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Generated("com.robohorse.robopojogenerator")
public class UserModel {
	@Builder.Default
	@JsonProperty("firstName")
	private String firstName = "Ivan";

	@Builder.Default
	@JsonProperty("lastName")
	private String lastName = "Ivanovich";

	@Builder.Default
	@JsonProperty("password")
	private String password = "45322";

	@Builder.Default
	@JsonProperty("userStatus")
	private int userStatus = 0;

	@Builder.Default
	@JsonProperty("phone")
	private String phone = "097965544333";

	@Builder.Default
	@JsonProperty("id")
	private int id = valueOf(random(3, "1234567890"));

	@Builder.Default
	@JsonProperty("email")
	private String email = "testingloh@gmail.com";

	@Builder.Default
	@JsonProperty("username")
	private String username = "notloh";
}