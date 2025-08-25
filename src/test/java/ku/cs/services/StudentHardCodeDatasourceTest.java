package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    @DisplayName("เช็คสมาชิก")
    void testCheckForStudent(){
        StudentList list = new StudentHardCodeDatasource().readData();
        assertNotEquals(null, list.findStudentById("6710400001"));
        assertEquals("Third", list.findStudentById("6710400003").getName());
    }

}