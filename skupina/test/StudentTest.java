import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void setUp() {
        this.student = new Student("Ferko", "Mrkvicka", "123");
    }

    @Test
    void getMeno() {
        assertEquals("Ferko", this.student.getMeno());
    }

    @Test
    void getPriezvisko() {
        assertEquals("Mrkvicka", this.student.getPriezvisko());
    }

    @Test
    void getOsobneCislo() {
        assertEquals("123", this.student.getOsobneCislo());
    }
}