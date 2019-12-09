package facades;

import dtos.FlightDTO;
import dtos.SeriesDTO;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cko
 */
public class PandaFacadeTest {

    /**
     * Test of getAllSeries method, of class PandaFacade.
     */
    @Test
    public void testGetAllSeries() throws Exception {
        System.out.println("getAllSeries");
        PandaFacade facade = PandaFacade.getPandaFacade();
        SeriesDTO[] result = facade.getAllSeries();
        assertNotNull(result);
        assertNotEquals(result.length, 0);
    }

    /**
     * Test of getSingleSerie method, of class PandaFacade.
     */
    @Test
    public void testGetSingleSerie() throws Exception {
        System.out.println("getSingleSerie");
        PandaFacade facade = PandaFacade.getPandaFacade();
        SeriesDTO[] series = facade.getAllSeries();
        int id = series[0].id;
        SeriesDTO expResult = series[0];
        SeriesDTO result = facade.getSingleSerie(id);
        assertEquals(expResult.id, result.id);
    }

    /**
     * Test of getFlight method, of class PandaFacade.
     */
    @Test
    public void testGetFlight() throws Exception {
        System.out.println("getFlight");
        // TODO
    }
    
}
