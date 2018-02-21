package com.blackbox.sharing.domain;

public enum ResourceType {
    VIDEO(1, "Video"),
    DOCUMENT(2, "Document"),
    FILE(3, "File");

	private Integer code;
	private String description;

	/**
	 * @param code
	 * @param description
	 */
	private ResourceType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Get enum type from code
	 */
	public static ResourceType toEnum(Integer code) {
		if (code == null)
			return null;
		for (ResourceType qa : ResourceType.values()) {
			if (code.equals(qa.getCode())) {
				return qa;
			}
		}
		throw new IllegalArgumentException("Invalid Id: " + code);
	}
}
