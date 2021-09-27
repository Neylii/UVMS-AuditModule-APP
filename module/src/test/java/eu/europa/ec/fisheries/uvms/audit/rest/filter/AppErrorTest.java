package eu.europa.ec.fisheries.uvms.audit.rest.filter;

import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppErrorTest {

    private AppError appErrorEmpty, appError;

    @Before
    public void setUp() {
        this.appErrorEmpty = new AppError();
        this.appError = new AppError(123, "Description text");
    }

    @Test
    @OperateOnDeployment("audit")
    public void getCodeTest() {
        assertEquals(Integer.valueOf(Integer.MIN_VALUE), this.appErrorEmpty.getCode());
        assertEquals(Integer.valueOf(123), this.appError.getCode());
    }

    @Test
    @OperateOnDeployment("audit")
    public void getDescriptionTest() {
        assertEquals("", this.appErrorEmpty.getDescription());
        assertEquals("Description text", this.appError.getDescription());
    }
}
