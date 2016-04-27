package com.ga.common;
/**
 * The Enum ErrorCodes.
 * 
 * @author knilay
 */
public enum ClientErrorCodes {

    // Common general Response and error codes
    GA_SECURITY_POLICY_VIOLATION(5001, "Security policy violation"),
    GA_INTERNAL(5002, "Internal Error"),
    GA_MANDATORY_PARAMETER_NOT_FOUND(5003, "Mandatory parameter not found."),
    GA_SERVICE_UNAVAILABLE(5004, "Service auavailble.Please try again after sometime"),

    GA_FILE_UPLOAD_FAILED(4500, "File Upload Exception"),
    GA_DATA_NOT_FOUND(4294, "Requested data not found"),
    FILE_UPLOAD_TRANSCATON_SUCCSS(4295, "File upload operation successful.");
    // get new joblist for pm

    

    int errorCode;
    String description;

    /**
     * Instantiates a new error codes.
     * 
     * @param errorCode the error code
     * @param description the description
     */
    private ClientErrorCodes(int errorCode, String description) {
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
     * @param errorCode the new error code
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
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}