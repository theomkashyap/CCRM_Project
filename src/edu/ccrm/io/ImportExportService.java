package edu.ccrm.io;

// --- ADD THESE IMPORTS ---
import edu.ccrm.config.AppConfig;
import edu.ccrm.config.CourseBuilder;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.School;
import edu.ccrm.domain.Semester;
import edu.ccrm.domain.Student;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.IStudentService;
import edu.ccrm.util.ConsoleColors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
// --- END OF IMPORTS ---

public class ImportExportService {
    private final IStudentService studentService;
    private final CourseService courseService;
    private final Path exportDir = Paths.get(AppConfig.getInstance().getDataDirectory());
    private final AtomicInteger studentIdCounter = new AtomicInteger(100);

    public ImportExportService(IStudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    public void exportDataToCsv() throws IOException {
        List<String> studentLines = studentService.getAllStudents().stream()
                .map(s -> s.getRegNo() + "," + s.getFullName() + "," + s.getEmail() + "," + s.getDateOfBirth())
                .collect(Collectors.toList());
        Files.write(exportDir.resolve("students_export.csv"), studentLines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        List<String> courseLines = courseService.getAllCourses().stream()
                .map(c -> c.getCode() + "," + c.getTitle() + "," + c.getCredits() + "," + c.getSchool() + "," + c.getSemester())
                .collect(Collectors.toList());
        Files.write(exportDir.resolve("courses_export.csv"), courseLines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        System.out.println(ConsoleColors.GREEN + "Data exported successfully to " + exportDir + ConsoleColors.RESET);
    }

    public void importDataFromCsv(String studentFilePath, String courseFilePath) {
        try (Stream<String> lines = Files.lines(Paths.get(studentFilePath))) {
            lines.skip(1)
                 .map(line -> line.split(","))
                 .forEach(parts -> {
                     Student student = new Student(
                         studentIdCounter.getAndIncrement(),
                         parts[1],
                         parts[2],
                         LocalDate.parse(parts[3]),
                         parts[0]
                     );
                     studentService.addStudent(student);
                 });
            System.out.println(ConsoleColors.GREEN + "Students imported successfully." + ConsoleColors.RESET);
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED + "Error importing students: " + e.getMessage() + ConsoleColors.RESET);
        }

        try (Stream<String> lines = Files.lines(Paths.get(courseFilePath))) {
            lines.skip(1)
                 .map(line -> line.split(","))
                 .forEach(parts -> {
                     Course course = new CourseBuilder()
                         .withCode(parts[0])
                         .withTitle(parts[1])
                         .withCredits(Integer.parseInt(parts[2]))
                         .withSchool(School.valueOf(parts[3].toUpperCase()))
                         .withSemester(Semester.valueOf(parts[4].toUpperCase()))
                         .build();
                     courseService.addCourse(course);
                 });
            System.out.println(ConsoleColors.GREEN + "Courses imported successfully." + ConsoleColors.RESET);
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED + "Error importing courses: " + e.getMessage() + ConsoleColors.RESET);
        }
    }
}