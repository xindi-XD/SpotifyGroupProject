import data_access.APIDataAccessObject;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class APITest {
    @Test
    public void testGetMe() {
        APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
        assertEquals(apiDataAccessObject.getMe(), "Une");
    }
}
