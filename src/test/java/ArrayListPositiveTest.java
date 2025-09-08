import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import homework._2025_09_08__exceptions.ArrayListPositive;
import homework._2025_09_08__exceptions.NotPositiveArgumentException;

import java.util.*;

class ArrayListPositiveTest {

    ArrayListPositive<Object> arrayListPositive;
    ArrayListPositive<Object> arrayListPositiveSpy;

    @BeforeEach
    void setup() {
        arrayListPositive = new ArrayListPositive<Object>(10);
        arrayListPositiveSpy = Mockito.spy(arrayListPositive);
    }

    /**
     * Nur Integer-Referenzen können in einer `ArrayListPositive` gespeichert werden.
     */
    @Test
    void acceptInteger() {
        assertDoesNotThrow(() -> arrayListPositive.checkType(12));
    }

    /**
     * Nur Integer-Referenzen können in einer `ArrayListPositive` gespeichert werden.
     */
    @Test
    void notAcceptOthers() {
        Exception e;
        e = assertThrowsExactly(IllegalArgumentException.class, () -> arrayListPositive.checkType("some string"));
        assertEquals("Only Integer type is allowed. Arg is: java.lang.String", e.getMessage());

        e = assertThrowsExactly(IllegalArgumentException.class, () -> arrayListPositive.checkType(false));
        assertEquals("Only Integer type is allowed. Arg is: java.lang.Boolean", e.getMessage());

        e = assertThrowsExactly(IllegalArgumentException.class, () -> arrayListPositive.checkType(49.5));
        assertEquals("Only Integer type is allowed. Arg is: java.lang.Double", e.getMessage());

        e = assertThrowsExactly(IllegalArgumentException.class, () -> arrayListPositive.checkType(12f));
        assertEquals("Only Integer type is allowed. Arg is: java.lang.Float", e.getMessage());

        e = assertThrowsExactly(IllegalArgumentException.class, () -> arrayListPositive.checkType(100L));
        assertEquals("Only Integer type is allowed. Arg is: java.lang.Long", e.getMessage());

        e = assertThrowsExactly(IllegalArgumentException.class, () -> arrayListPositive.checkType(new Object()));
        assertEquals("Only Integer type is allowed. Arg is: java.lang.Object", e.getMessage());

    }

    /**
     * Keine null-Werte können in einer `ArrayListPositive` gespeichert werden.
     * Beim Versuch wird `NullArgumentException` geworfen.
     */
    @Test
    void checkNullRef() {
        assertThrowsExactly(NullPointerException.class, () -> arrayListPositive.checkType(null));
    }

    /**
     * Keine 0-Werte können in einer `ArrayListPositive` gespeichert werden.
     * Beim Versuch wird `NotPostivieArgumentException` geworfen.
     */
    @Test
    void checkNot0Value() {
        assertThrowsExactly(NotPositiveArgumentException.class, () -> arrayListPositive.checkType(0));
    }

    /**
     * Keine negativen Werte können in einer `ArrayListPositive` gespeichert werden.
     * Beim Versuch wird `NotPostivieArgumentException` geworfen.
     */
    @Test
    void checkNotNegative() {
        assertThrowsExactly(NotPositiveArgumentException.class, () -> arrayListPositive.checkType(-10));
    }

    @Test
    void addCallsCheckMethodWithoutSpy() {
        arrayListPositive.add(42);
        assertEquals(1, arrayListPositive.size());
        assertEquals(42, arrayListPositive.get(0));
    }

    //    @Test
    void addCallsCheckMethod() {
        arrayListPositiveSpy.add(42);
        verify(arrayListPositiveSpy).checkType(42);
        assertEquals(1, arrayListPositiveSpy.size());
        assertEquals(42, arrayListPositiveSpy.get(0));
    }

    @Test
    void addWithIndexCallsCheckMethodWithoutSpy() {
        arrayListPositive.add(0, 44);
        assertEquals(1, arrayListPositive.size());
        assertEquals(44, arrayListPositive.get(0));
    }

    //    @Test
    void addWithIndexCallsCheckMethod() {
        arrayListPositiveSpy.add(0, 44);
        verify(arrayListPositiveSpy).checkType(44);
        assertEquals(1, arrayListPositiveSpy.size());
        assertEquals(44, arrayListPositiveSpy.get(0));
    }

//    @Test
    void addAllCallsCheckMethod() {
        int[] arr = {1, 2, 3};
        arrayListPositiveSpy.addAll(Arrays.asList(arr));
        verify(arrayListPositiveSpy).checkType(1);
        verify(arrayListPositiveSpy).checkType(2);
        verify(arrayListPositiveSpy).checkType(3);

        assertEquals(3, arrayListPositiveSpy.size());
        assertEquals(1, arrayListPositiveSpy.get(0));
        assertEquals(2, arrayListPositiveSpy.get(1));
        assertEquals(3, arrayListPositiveSpy.get(2));
    }
//    @Test
    void addAllWithIndexCallsCheckMethod() {
        int[] arr = {1, 2, 3};
        arrayListPositiveSpy.addAll(0, Arrays.asList(arr));
        verify(arrayListPositiveSpy).checkType(1);
        verify(arrayListPositiveSpy).checkType(2);
        verify(arrayListPositiveSpy).checkType(3);

        assertEquals(3, arrayListPositiveSpy.size());
        assertEquals(1, arrayListPositiveSpy.get(0));
        assertEquals(2, arrayListPositiveSpy.get(1));
        assertEquals(3, arrayListPositiveSpy.get(2));
    }
}
