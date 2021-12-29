import model.Transcript;

public class Main {
    public static void main(String[] args){
        Transcript t1 = new Transcript("Jane Doe", 7830);
        Transcript t2 = new Transcript("Ada Lovelace", 8853);
        Transcript t3 = new Transcript("Melanie Orellana", 9045);

        t1.addGrade("CPSC-210", 3.5);
        t1.addGrade("ENGL-201", 4.0);
        t1.addGrade("CPSC-110", 3.1);

        t2.addGrade("CPSC-210", 3.3);
        t2.addGrade("ENGL-201", 8.9);
        t2.addGrade("CPSC-110", 3.5);

        t3.addGrade("CPSC-210", 3.4);
        t3.addGrade("ENGL-201", 3.2);
        t3.addGrade("CPSC-110", 3.1);

        System.out.print(t1.getStudentName() + ": ");
        t1.printTranscript();

        System.out.println(t1.getGPA());

    }
}
