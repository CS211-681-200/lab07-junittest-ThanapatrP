package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Test ทุก method
class StudentTest {
    Student s;

//    @BeforeAll
    @BeforeEach
    void init(){
        s = new Student("67xxxxxxxx", "test");
    }

    @Test
    @DisplayName("Contructor")
    void testConstructor(){
        s = new Student("67xxxxxxx1", "Test1");
        assertEquals("67xxxxxxx1", s.getId());
        assertEquals(0.0, s.getScore());

        s = new Student("67xxxxxxx2", "Test2", 50.0);
        assertEquals("67xxxxxxx2", s.getId());
        assertEquals(50.0, s.getScore());
    }

    @Test
    @DisplayName("เปลี่ยนชื่อ")
    void testChangeName(){
        s.changeName("John");
        assertEquals("John", s.getName());

        s.changeName("  George   ");
        assertEquals("George", s.getName());
    }

    @Test
    @DisplayName("เช็คตัวอักษรในชื่อ")
    void testNameContains(){
        assertEquals(true, s.isNameContains("T"));
        assertEquals(false, s.isNameContains("a"));
        assertEquals(false, s.isNameContains(" "));
        s.changeName("  John Eastwood  ");
        assertEquals(true, s.isNameContains(" "));
    }

    @Test
    @DisplayName("เพิ่มคะแนนนิสิต")
    void testAddScore(){
        s.addScore(60);
        assertEquals(60, s.getScore()); // ไม่ต้องดู code
        s.addScore(1);
        assertEquals(61, s.getScore()); // ไม่ต้องดู code
    }

    @Test
    @DisplayName("คำนวณเกรด")
    void testCalculateGrade(){
        Student s = new Student("67xxxxxxxx", "test");
        s.addScore(60);
        assertEquals("C", s.grade()); // ไม่ต้องดู code
    }

}