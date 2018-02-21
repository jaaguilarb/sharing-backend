package com.blackbox.sharing.domain;

public enum QAType {
	ONLY_ONE_OPTION(1, "Only one option"),
    MULTIPLE_CHOICE(2, "Multiple choice"),
    YES_NO(3, "Yes/No"),
    TRUE_FALSE(4, "True/False"),
    FILL_IN_THE_BLANK(5, "Fill in the blank"),
    MATCHING(6, "Matching"),
    ORDERING(7, "Ordering"),
    COMPUTATIONAL(8, "Computational");

	private Integer code;
	private String description;

	/**
	 * @param code
	 * @param description
	 */
	private QAType(Integer code, String description) {
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
	public static QAType toEnum(Integer code) {
		if (code == null)
			return null;
		for (QAType qa : QAType.values()) {
			if (code.equals(qa.getCode())) {
				return qa;
			}
		}
		throw new IllegalArgumentException("Invalid Id: " + code);
	}
}
