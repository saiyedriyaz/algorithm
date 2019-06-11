package net.company;

import net.company.PinCodeValidator;
import net.exception.ValidationException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Riyaz Saiyed
 */
public class ServiceTest {

    private static PinCodeValidator CACHE_SERVICE = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        CACHE_SERVICE = PinCodeValidator.getInstance();
    }

    @Test
    public void testSuccessDefault() throws ValidationException {
        List<String> data = CACHE_SERVICE.getPINCodeBatch();
        assertNotNull("Invalid output", data);
        assertEquals("Invalid output size", 1000, data.size());
    }

    @Test
    public void testParam() throws ValidationException {
        List<String> data = CACHE_SERVICE.getPINCodeBatch(9150, 500);
        assertNotNull("Null data", data);
        assertEquals("Invalid output size", 500, data.size());
    }

    @Test
    public void testSuccessParam() throws ValidationException {
        List<String> data = CACHE_SERVICE.getPINCodeBatch(9000, 1000);
        assertNotNull("Null data", data);
        assertEquals("Invalid output size", 1000, data.size());
    }

    @Test
    public void testExceptio() throws ValidationException {
		/*
		Throwable exception = assertThrows(ValidationException.class, () -> {
			CACHE_SERVICE.getPINCodeBatch(99, 1000);
		});
		assertEquals("Invalid Input", exception.getMessage());
		*/
    }
}
