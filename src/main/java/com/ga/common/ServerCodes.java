package com.ga.common;

/**
 * The Enum ErrorCodes.
 * 
 * @author knilay
 */
public enum ServerCodes {
	// Response code for success response
	GA_TRANSACTION_OK(0, "Transaction sucessful"),

	// Response code for general errors [start Range: 1000]
	GA_INTERNAL(1001, "Internal error occure. Please contact administrator."), GA_SERVICE_UNAVAILABLE(
			1002, "Requested service unavailable"), GA_SERVICE_NOT_FOUND(1003,
			"Requested service not found"), GA_REQUEST_TIMEOUT(1004,
			"Request timeout"), GA_REQUEST_NOT_AUTHORIZE(1005,
			"Requested service not authorize"), GA_ACTION_UNSUPPORTED(1006,
			"Action or method Unsupported"), GA_FILE_UPLOAD(1007,
			"File Upload failed"),

	// Response code for database errors [start Range: 2000]
	GA_DATABASE_GENERAL(2001, "General exception for common Database error"), GA_CONNECTION_DOWN(
			2002, "Database connection not available at the momnent"), GA_DB_CONSTRAINT_VIOLATION_EXCEPTION(
			2003, " Database CONSTRAINT violation Exception"),

	// Response errors for user [start Range: 4000]
	GA_AUTH_FAILED(4001, "Authentication failed"), GA_PARAMETERS_WRONG(4002,
			"Wrong parameters requested"), GA_MAXIMUM_ATTEMPT_REACHED(4003,
			"Maximumm number of request attempt reached"), GA_MANDATORY_PARAMETERS_NOT_SET(
			4004, "Mandatory Parameters missing"), GA_USER_LOCKED(4005,
			"User is locked"), GA_DATA_NOT_FOUND(4006,
			"Requested data not found"), GA_SIZE_VIOLATION(4007,
			"Size constrain violation"),

	// in the case when any logical cases failed to satisfy the use case then
	// this error is been used
	GA_POLICY_VIOLATION(4008, "Logical policy violation"),

	// Response errors for security and policy violation [start Range: 5000]
	GA_SECURITY_POLICY_VIOLATION(5001, "Security policy violation"),

	GA_CHANGE_STATUS_FAILED(6000, "Change job status failed");

	int errorCode;
	String description;

	/**
	 * Instantiates a new error codes.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param description
	 *            the description
	 */
	private ServerCodes(int errorCode, String description) {
		this.errorCode = errorCode;
		this.description = description;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Sets the error code.
	 * 
	 * @param errorCode
	 *            the new error code
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
