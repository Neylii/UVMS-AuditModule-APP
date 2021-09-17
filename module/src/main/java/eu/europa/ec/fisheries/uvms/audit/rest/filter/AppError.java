package eu.europa.ec.fisheries.uvms.audit.rest.filter;

public class AppError {

    private Integer code;
    private String  description;

    public AppError() {
        this.code = Integer.MIN_VALUE;
        this.description = "";
    }

    public AppError(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
