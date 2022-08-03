package Testing_example;

import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;



import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehicleTest {


    @Test
    @DisplayName("Should demonstration a simple assertion")
    public void shouldShowSimpleAssertion(){
        assertEquals(1,1);
    }

    @Test
    @Disabled("Not implemented yet")
    public void shouldShowSimpleAssertionFailed(){
        assertEquals(1,2);
    }

    @Test
    public void shouldShowSimpleAssertion03(){
        fail("Not implemented");
    }

    @Test
    public void shouldShowSimpleAssertion04(){
        List<Integer> numbers = List.of(2, 3, 5, 7, 8);

        assertEquals(2, numbers.get(0));
        assertEquals(3, numbers.get(1));
        assertEquals(5, numbers.get(2));
        assertEquals(7, numbers.get(3));
        assertEquals(8, numbers.get(4));

    }

    @Test
    public void shouldShowSimpleAssertion04All(){
        List<Integer> numbers = List.of(2, 3, 5, 7, 8);

        Assertions.assertAll(
                () -> assertEquals(2, numbers.get(0)),
                () -> assertEquals(3, numbers.get(1)),
                () -> assertEquals(5, numbers.get(2)),
                () -> assertEquals(7, numbers.get(3)),
                () -> assertEquals(8, numbers.get(4)));

    }

    @Test
    public void shouldShowSimpleAssertion04AllFaild(){
        List<Integer> numbers = List.of(2, 3, 5, 7, 8);

        Assertions.assertAll(
                () -> assertEquals(2, numbers.get(0)),
                () -> assertEquals(3, numbers.get(1)),
                () -> assertEquals(5, numbers.get(2)),
                () -> assertEquals(6, numbers.get(3)),
                () -> assertEquals(8, numbers.get(4)));

    }

    @Test
    @DisplayName("Should only run the test if some criteria are met")
    public void ShouldOnlyRunTheTestIfSomeCriteriaAreMet(){
        Integer dd = 10;
        Assumptions.assumeTrue(dd > 5);

        assertEquals(2,2);
    }

    @ParameterizedTest
    @DisplayName("Should create vehicle with different numbers of sides")
    @ValueSource(ints = {3, 4, 5, 8, 14})
    void shouldCreateVehicleWithDifferentNumberOfSides(int expectedNumberOfSides) {
        Vehicle vehicle01 = new Vehicle(expectedNumberOfSides);
        assertEquals(expectedNumberOfSides, vehicle01.getNumberOfWheels());
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Should create vehicle with different numbers of sides with Name")
    @ValueSource(ints = {3, 4, 5, 8, 14})
    void shouldCreateVehicleWithDifferentNumberOfSidesName(int expectedNumberOfSides) {
        Vehicle vehicle01 = new Vehicle(expectedNumberOfSides);
        assertEquals(expectedNumberOfSides, vehicle01.getNumberOfWheels());
    }

    @ParameterizedTest(name = "{0}")
    @DisplayName("Should not create vehicle with different numbers of sides with Name")
    @ValueSource(ints = {3, 4, 5, 8, 14, 40, 50})
    public void shouldNotCreateVehicleWithInvalidNumberOfSides(int expectedNumberOfSides) {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(expectedNumberOfSides));
    }

    @Nested
    @DisplayName("When a vehicle has been created")
    class WhenVehicleExists {

        private final Vehicle vehicle = new Vehicle(4);

        @Nested
        @DisplayName("Should allow")
        class ShouldAllow {

            @Test
            @DisplayName("seeing the number of wheels")
            public void seeingTheNumberOfWheels(){
                assertEquals(4, vehicle.getNumberOfWheels());
            }


        }

    }

}