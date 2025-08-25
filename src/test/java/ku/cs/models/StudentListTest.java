package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList sl;

    @BeforeEach
    void init(){
        sl = new StudentList();
        sl.addNewStudent("67xxxxxxx1", "Mark");
        sl.addNewStudent("67xxxxxxx2", "John", 15.0);
        sl.addNewStudent("67xxxxxxx3", "David");
        sl.addNewStudent("67xxxxxxx4", "Denji", 50.0);
        sl.addNewStudent("67xxxxxxx5", "George");
    }

    @Test
    @DisplayName("ดูเกรด")
    void testViewGradeById(){
        assertEquals("F", sl.viewGradeOfId("67xxxxxxx1"));

        sl.giveScoreToId("67xxxxxxx1", 70.0);

        assertEquals("B", sl.viewGradeOfId("67xxxxxxx1"));
        assertEquals(null, sl.viewGradeOfId("67xxxxxxx6"));
    }

    @Test
    @DisplayName("เพิ่มคะแนนด้วย ID")
    void testGiveScoreToId(){
        sl.giveScoreToId("67xxxxxxx2", 35.0);
        assertEquals(50.0 ,sl.findStudentById("67xxxxxxx2").getScore());
        assertEquals(0.0 ,sl.findStudentById("67xxxxxxx1").getScore());

        sl.giveScoreToId("67xxxxxxx1", -30.0);
        assertEquals(0.0 ,sl.findStudentById("67xxxxxxx1").getScore());
    }

    @Test
    @DisplayName("กรองนักเรียนจากชื่อ")
    void testFilterByName(){
        assertEquals(2, sl.filterByName("d").getStudents().size());
        assertEquals(2, sl.filterByName("i").getStudents().size());
        assertEquals(0, sl.filterByName(" ").getStudents().size());

        assertEquals(false, sl.filterByName("denji").getStudents().isEmpty());
    }

    @Test
    @DisplayName("หานักเรียนจาก ID")
    void testFindById(){
        sl.giveScoreToId("67xxxxxxx3", 60.0);

        assertNotEquals(null, sl.findStudentById("67xxxxxxx1").getName());
        assertEquals("John", sl.findStudentById("67xxxxxxx2").getName());
        assertEquals(60.0 , sl.findStudentById("67xxxxxxx3").getScore());
    }

    @Test
    @DisplayName("เพิ่มนักเรียน")
    void testAddStudent(){
        sl.addNewStudent("67xxxxxxx6", "Test1");
        assertEquals(6, sl.getStudents().size());
        sl.addNewStudent("67xxxxxxx7", "Test2", 50.0);
        sl.addNewStudent("67xxxxxxx8", "Test3");
        assertEquals(8, sl.getStudents().size());
        sl.addNewStudent("67xxxxxxx1", "Test4");
        assertEquals(8, sl.getStudents().size());
    }

}