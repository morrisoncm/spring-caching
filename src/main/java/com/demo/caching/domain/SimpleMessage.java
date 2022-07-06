package com.demo.caching.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleMessage {

	private String category;
	private String text;

}
