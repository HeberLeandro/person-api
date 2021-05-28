package com.github.heberleandro.personapi.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(access = AccessLevel.PUBLIC)
public class MessageResponseDTO {
	
	private String message;
}
