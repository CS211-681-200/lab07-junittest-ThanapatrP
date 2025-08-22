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