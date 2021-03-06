package io.github.isandratskiy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import static java.lang.Integer.valueOf;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class UserModel {
	@Builder.Default
	@JsonProperty("firstName")
	private String firstName = "Micky";

	@Builder.Default
	@JsonProperty("lastName")
	private String lastName = "Mouse";

	@Builder.Default
	@JsonProperty("password")
	private String password = "admin".concat(randomAlphabetic(5));

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
	private String email = "testmick@mick.com";

	@Builder.Default
	@JsonProperty("username")
	private String username = "Micky";
}