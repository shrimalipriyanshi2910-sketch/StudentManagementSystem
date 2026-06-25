import java.io.*;

public class StudentOperations {

    private static final String FILE_NAME = "students.txt";

    // ADD STUDENT
    public void addStudent(Student s) {
        try {
            try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
                fw.write(s.toString());
                fw.write("\n");
            }

            System.out.println("Student added successfully!"); 

        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }

    // DISPLAY WITH TABLE FORMAT
    public void displayStudents() throws Exception {

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                
                System.out.println("\n==============================================================");
                System.out.println("                      STUDENT RECORDS                         ");
                System.out.println("==============================================================");
                
                // HEADER (TABLE)
                System.out.printf("%-8s %-15s %-5s %-12s %-8s %-8s\n",
                        "Roll", "Name", "Age", "Course", "Marks", "Grade");
                
                System.out.println("--------------------------------------------------------------");
                
                while ((line = br.readLine()) != null) {

    String[] data = line.split(",");

    Student s = new Student(
            Integer.parseInt(data[0]),
            data[1],
            Integer.parseInt(data[2]),
            data[3],
            Double.parseDouble(data[4])
    );

    String grade = s.calculateGrade();

    System.out.printf("%-8s %-15s %-5s %-12s %-8s %-8s\n",
            s.getRollNo(),
            s.getName(),
            s.getAgeSafe(),
            s.getCourse(),
            s.getMarks(),
            grade
    );
}
            }

            System.out.println("==============================================================");

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    // SEARCH
    @SuppressWarnings("ConvertToTryWithResources")
    public void searchStudent(int roll) {
        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == roll) {
                    System.out.println("Student Found:");
                    System.out.printf("%-8s %-15s %-5s %-12s %-8s\n",
                            data[0], data[1], data[2], data[3], data[4]);

                    found = true;
                    break;
                }
            }

            br.close();

            if (!found) {
                System.out.println("Student not found");
            }

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    // DELETE
    @SuppressWarnings("ConvertToTryWithResources")
    public void deleteStudent(int roll) {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) != roll) {
                    bw.write(line);
                    bw.newLine();
                }
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            System.out.println("Deleted successfully!");

        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    // UPDATE
    @SuppressWarnings("ConvertToTryWithResources")
    public void updateStudent(int roll, Student newStudent) {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == roll) {
                    bw.write(newStudent.toString());
                } else {
                    bw.write(line);
                }

                bw.newLine();
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            System.out.println("Updated successfully!");

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}