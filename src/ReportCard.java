import java.util.ArrayList;

class ReportCard {

    /* Class level relevant constants */
    static final String SCHOOL_NAME = "TRUE KNOWLEDGE QUEST";
    static final String ACADEMIC_YEAR = "2016 - 2017";
    static final String ACADEMIC_SCALE = "A = 90 - 100 \nB = 80 - 89 \nC = 70 - 79 \nD = 65 - 69 \nF = Below 65";
    /* Store the student's name */
    private String name;
    /* Store the student grade */
    private String grade;
    /* Store the student's enrolled courses as an ArrayList */
    private ArrayList<String> courses;
    /* Store the scores scored on each subject in an ordered list where the order corresponds to the courses list */
    private ArrayList<ArrayList<Float>> scores;

    /**
     * Create a ReportCard object
     *
     * @param studentName    a String for the student's name
     * @param studentGrade   a String for the student's grade
     * @param studentCourses a String list that contains student enrolled courses
     */
    ReportCard(String studentName, String studentGrade, ArrayList<String> studentCourses, ArrayList<ArrayList<Float>> studentCourseScores) {

        /* Check for valid name entry. Ideally, this should be handled at the student class level */
        if (containsOnlyAlphabets(studentName)) {
            this.name = studentName;
        } else {
            System.out.println("Illegal value for student's name");
        }
        // Store student grade information
        this.grade = studentGrade;

        // Store student enrolled courses list
        this.courses = studentCourses;

        // Store student individual course scores over 4 quarters
        // Test whether number of scores entered by a course teacher matches the number of quarters in an academic year
        // Ideally, the below validation must be handled at the student class level
        for (ArrayList<Float> aList : studentCourseScores) {
            int numberOfScores = aList.size();
            if (numberOfScores != 4) {
                System.out.println("The number of scores does not match the number of quarters in an academic year!" +
                        " The last score has been ignored.");
            } else {
                this.scores = studentCourseScores;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("\t\t\t\t\t" + ReportCard.SCHOOL_NAME);
        System.out.println("\t\t\t\t\t\t" + ReportCard.ACADEMIC_YEAR);
        ArrayList<String> studentCourses = new ArrayList<>();
        studentCourses.add("Science");
        studentCourses.add("Mathematics");
        studentCourses.add("Computer Science");

        ArrayList<ArrayList<Float>> studentCourseScores = new ArrayList<ArrayList<Float>>();

        ArrayList<Float> science = new ArrayList<Float>();
        science.add(95.5f);
        science.add(100f);
        science.add(98.5f);
        science.add(99f);
        studentCourseScores.add(science);

        ArrayList<Float> math = new ArrayList<Float>();
        math.add(100f);
        math.add(98f);
        math.add(100f);
        math.add(100f);
        studentCourseScores.add(math);

        ArrayList<Float> cs = new ArrayList<Float>();
        cs.add(100f);
        cs.add(100f);
        cs.add(100f);
        cs.add(100f);
        studentCourseScores.add(cs);

        ReportCard test = new ReportCard("Lee", "7", studentCourses, studentCourseScores);
        System.out.println("Student Name: " + test.getName());
        System.out.println();
        System.out.println();

        test.display();
        System.out.println();

        System.out.println(ReportCard.ACADEMIC_SCALE);

    }

    /**
     * Get the student's name
     *
     * @return a String for the name
     */
    String getName() {
        return name;
    }

    /**
     * Get the student's grade
     *
     * @return a String for the grade
     */
    String getGrade() {
        return grade;
    }

    /**
     * Display the list of enrolled courses in line-separated format
     */
    void getCourses() {
        System.out.println();
        for (String s : courses) {
            System.out.println(s);
        }
    }

    /**
     * Maps the student's individual course score to the corresponding course per course title
     *
     * @param courseTitle the title of the course to map scores for
     * @return a float number array containing the scores for all quarters of the academic year
     */
    float[] mappedScores(String courseTitle) {
        int getPosition = courses.indexOf(courseTitle);
        float[] result = new float[4];
        ArrayList<Float> target = scores.get(getPosition);
        for (int i = 0; i < result.length; i++) {
            // Traverse result array in place of object's scores field
            // Prevents throwing an OutOfBoundsException when number of scores within the inner ArrayList exceeds
            // the number of quarters in an academic year
            result[i] = target.get(i);
        }
        return result;
    }

    int courseAverage(float[] courseScores) {
        float sum = 0f;
        for (float f : courseScores) {
            sum += f;
        }
        return Math.round(sum / courseScores.length);
    }

    void display() {
        for (int i = 0; i < courses.size(); i++) {
            String courseTitle = courses.get(i);
            float[] courseScores = mappedScores(courseTitle);
            System.out.printf("%20s:", courseTitle);
            for (float f : courseScores) {
                System.out.printf(" %6.2f", f);
            }
            System.out.print("\t" + courseAverage(courseScores));
            System.out.println();
        }

    }

    /**
     * Tests if a String contains alphabets only
     *
     * @param s the String to be tested
     * @return true if the character sequence represented by the argument contains only alphabets; false otherwise.
     * Note that false is returned even when an empty string is passed as argument
     */
    boolean containsOnlyAlphabets(String s) {
        boolean result = true;
        if (!s.isEmpty()) {
            // When s is not null String object
            // Remove all whitespace and make copy of String argument
            String copy = String.copyValueOf(s.replaceAll("\\s+", "").toCharArray());
            // Traverse over copied string object
            for (int i = 0; i < copy.length(); i++) {
                // Get char at current position
                char c = copy.charAt(i);
                // Check whether the char is a alphabetic letter
                if (!Character.isLetter(c)) {
                    // Contains non alphabet character
                    // Terminate traversing over the copied string object
                    i = copy.length();
                    // Set return value to false due to non-alphabet character detection
                    result = false;
                }
            }
        } else {
            // s is a null String object
            result = false;
        }
        return result;
    }
}
