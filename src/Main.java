import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Faculty csf = new Faculty("Computer Science Faculty");
        Institute toizi = new Institute("Information Processing and Security", "Voronezh, Universitetskaya ploschad, 1");
        Lecturer lecturer = new Lecturer(1, "Ilia Gelemeev", "iliik@gmail.com", "Artificial Intelligence");
        Project ai_research = new Project("Artificial Intelligence Research", new Date(2025, 11, 1), new Date(2026, 5, 1));
        Participation participation = new Participation(50, ai_research, lecturer);
        Course ml = new Course("Machine Learning", 1, 144);
        csf.addInstitute(toizi);
        toizi.addResearchAssociate(lecturer);
        lecturer.addParticipation(participation);
        ai_research.addParticipation(participation);
        lecturer.addCourse(ml);
        ml.addLecturer(lecturer);

        System.out.println("Faculty: "
                + csf.getName()
        );
        System.out.println("Institute: "
                + Arrays.stream(csf.getInstitutes())
                .filter(Objects::nonNull)
                .map(Institute::getName)
                .collect(Collectors.joining(", "))
        );
        System.out.println("Employers: "
                + Arrays.stream(toizi.getResearchAssociates())
                .filter(Objects::nonNull)
                .map(ResearchAssociate::getName)
                .collect(Collectors.joining(", "))
        );
        System.out.println("Projects: "
                + Arrays.stream(lecturer.getParticipations())
                .filter(Objects::nonNull)
                .map(Participation::getProject)
                .map(Project::getName)
                .collect(Collectors.joining(", "))
        );
        System.out.println("Course: "
                + ml.getName()
        );
        System.out.println("INFO: \n"
                + "name: " + ml.getName()
                + "\ntime: " + ml.getHours()
                + "\nid course: " + ml.getId()
                + "\nteachers: " + Arrays.stream(ml.getLecturers())
                .filter(Objects::nonNull)
                .map(Lecturer::getName)
                .collect(Collectors.joining(", "))
        );
    }
}