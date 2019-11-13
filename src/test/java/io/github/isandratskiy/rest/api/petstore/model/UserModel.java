package io.github.isandratskiy.rest.api.petstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import static java.lang.Integer.*;
import static org.apache.commons.lang3.RandomStringUtils.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserModel {
	@Builder.Default
	@JsonProperty("firstName")
	private String firstName = "Micky";

	@Builder.Default
	@JsonProperty("lastName")
	private String lastName = "Mouse";

	@Builder.Default
	@JsonProperty("password")
	private String password = "admin".concat(randomAlphabetic(5).toLowerCase());

	@Builder.Default
	@JsonProperty("userStatus")
	private int userStatus = 0;

	@Builder.Default
	@JsonProperty("phone")
	private String phone = "097965544333";

	@Builder.Default
	@JsonProperty("id")
	private int id = valueOf(randomNumeric(3));

	@Builder.Default
	@JsonProperty("email")
	private String email = "testingloh@gmail.com";

	@Builder.Default
	@JsonProperty("username")
	private String username = "micky".concat(randomAlphabetic(5).toLowerCase());
}