package eu.europa.ec.fisheries.uvms.audit.rest.filter;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.MDC;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuditRestExceptionMapper implements ExceptionMapper<Exception> {

    public AuditRestExceptionMapper() {
        super();
    }

    @Override
    public Response toResponse(Exception exception) {

        AppError error = new AppError(500, ExceptionUtils.getRootCauseMessage(exception));
        return Response.ok(error).header("MDC", MDC.get("requestId")).build();

    }
}
