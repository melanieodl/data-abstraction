package model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents the transcript of a student
 */
public class Transcript {

    private String studentName;
    private int studentId;

    private Map<String, Double> coursesWithGrades;
    ArrayList<String> courses;
    ArrayList<Double> grades;

    public Transcript(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        courses = new ArrayList<>();
        grades = new ArrayList<>();

    }

     /**
     * Adds a course and its corresponding grade to the student's transcript.
     * @param course name of the course
     * @param grade value in scale 0 to 4 points.
     */
    public void addGrade(String course, double grade){
        if(course == null || course.isEmpty())throw new IllegalArgumentException("course should not be null or empty");
        if (grade < 0 || grade > 4) throw new IllegalArgumentException("grade should be a number between 0 and 4.");

        int index = courses.indexOf(course);
        if(index != -1){
            grades.add(index, grade);
        } else {
            courses.add(course);
            grades.add(grade);
        }

    }

    /**
     * Returns the information of a course and its corresponding grade.
     * @param course the name of the course.
     * @return the course's name and its corresponding grade.
     * @throws NoSuchElementException when the <code>course</code> passed is not found in the transcript.
     */
    public String getCourseAndGrade(String course) throws NoSuchElementException{
        return String.format("%s: %.1f", course, getGradeByCourse(course));

    }

    /**
     * Prints the complete transcript
     */
    public void printTranscript(){
        System.out.printf("%s: ", this.getStudentName());
        courses.forEach(course -> System.out.printf("%s: %.1f, ", course, getGradeByCourse(course)));
        System.out.println();
        System.out.printf("GPA: %f", this.getGPA());
    }

    /**
     * Returns the GPA.
     * @return the grade the grade point average.
     */
    public double getGPA(){
        return getAverageOverSelectedCourses(this.courses);
    }

    /**
     * Returns the student's name.
     * @return student's name.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Returns the student's id.
     * @return student's id.
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Calculates the average of a list of grades.
     * @param selectedGrades list of grades
     * @return the average of <code>selectedGrades</code>
     */
    private double calculateAverage(List<Double> selectedGrades){
    return selectedGrades.stream().mapToDouble(n -> n).average()
            .orElseThrow(() -> new NoSuchElementException("no average could be calculated"));

    }

    /**
     * Returns the grade by the name of the course provided.
     * @param course the name of the course
     * @return the grade of the course.
     */
    private double getGradeByCourse(String course) throws NoSuchElementException{

        try {
            return grades.get(courses.indexOf(course));
        } catch (IndexOutOfBoundsException ex){
            throw new NoSuchElementException("The course you're looking for, doesn't exist in the transcript");
        }

    }

    /**
     * Returns the grade average of the selected list of courses.
     * @param selectedCourses the list of couse names to calculate the average.
     * @return the grade average of the couses.
     */
    private double getAverageOverSelectedCourses(List<String> selectedCourses)
            throws NoSuchElementException {
        return courses.size() > 0 ?
                calculateAverage(selectedCourses.stream()
                .map(this::getGradeByCourse)
                .collect(Collectors.toList()))
                : 0;
    }


}
