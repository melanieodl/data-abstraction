package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TranscriptTest {
    private Transcript testTranscript;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {

        testTranscript = new Transcript("Jane Doe", 1000);
    }

    @Test
    //right
    void transcript_returns_name_and_id() {
        assertEquals("Jane Doe", testTranscript.getStudentName());
        assertEquals(1000, testTranscript.getStudentId());
    }

    @Test
    //ritght
    void transcript_returns_course_and_grade() {
        testTranscript.addGrade("CPSC-210", 3.5);
        assertEquals("CPSC-210: 3.5", testTranscript.getCourseAndGrade("CPSC-210"));
    }

    @Test
    //right
    void transcript_throws_NoSuchElementException_when_trying_to_get_a_course_not_found() {
        assertThrows(NoSuchElementException.class, () -> testTranscript.getCourseAndGrade("CPSC-210"));
    }

    @Test
    //right
    void transcript_returns_gpa() {
        testTranscript.addGrade("CPSC-210", 3.4);
        testTranscript.addGrade("CPSC-310", 3.8);
        assertEquals((3.4+3.8)/2, testTranscript.getGPA());

    }

    @Test
    //right
    void transcript_returns_0_gpa_when_empty() {
        assertEquals(0, testTranscript.getGPA());
    }


    @Test
    //right
    void transcript_prints() {

        System.setOut(new PrintStream(outputStreamCaptor)); // This output stream is where the values will now be printed.

        testTranscript.addGrade("CPSC-210", 3.5);
        testTranscript.addGrade("ENGL-201", 4.0);
        testTranscript.addGrade("CPSC-110", 3.1);

        testTranscript.printTranscript();
        assertEquals("Jane Doe: CPSC-210: 3.5, ENGL-201: 4.0, CPSC-110: 3.1, \n" +
                "GPA: 3.533333", outputStreamCaptor.toString());

        System.setOut(standardOut); //Restore it to its original state when out test terminates.

    }


    @Test
    void transcript_throws_exception_when_adding_an_empty_couse_name() {
        assertThrows(IllegalArgumentException.class, () -> testTranscript.addGrade("", 2.5));
        assertThrows(IllegalArgumentException.class, () -> testTranscript.addGrade(null, 2.5));
    }


    //TODO Infinite values for gpa
    void infiniteValues(){
    }

    @Test
    void transcript_throws_exception_when_grades_out_of_range(){
        assertThrows(IllegalArgumentException.class, () -> testTranscript.addGrade("first", -0.9));
        assertThrows(IllegalArgumentException.class, () -> testTranscript.addGrade("second", -4.1));
    }

    @Test
    void transcript_rewrites_grade_when_duplicated_value(){
        testTranscript.addGrade("ENGL-101", 3.0);
        assertEquals("ENGL-101: 3.0", testTranscript.getCourseAndGrade("ENGL-101"));
        testTranscript.addGrade("ENGL-101", 3.5);
        assertEquals("ENGL-101: 3.5", testTranscript.getCourseAndGrade("ENGL-101"));
    }

}