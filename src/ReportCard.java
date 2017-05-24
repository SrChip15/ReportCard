import java.util.ArrayList;

class ReportCard {

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
    ReportCard(String studentName, String studentGrade, ArrayList<String> studentCourses) {

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
    }

    public static void main(String[] args) {
        System.out.println("\t\t\t\t\t" + ReportCard.SCHOOL_NAME);
        System.out.println("\t\t\t\t\t\t" + ReportCard.ACADEMIC_YEAR);
        ArrayList<String> studentCourses = new ArrayList<>();
        studentCourses.add("Science");
        studentCourses.add("Mathematics");
        /*studentCourses.add("Computer Science");
        studentCourses.add("English");
        studentCourses.add("Social Sciences");
        studentCourses.add("Economics");*/
        ReportCard test = new ReportCard("", "7", studentCourses);
        System.out.println("Student Name: " + test.getName());
        System.out.println();
        test.getCourses();
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
            String copy = String.copyValueOf(s.replaceAll("\\s+", "").toCharArray());
            for (int i = 0; i < copy.length(); i++) {
                char c = copy.charAt(i);
                if (!Character.isLetter(c)) {
                    // Contains non alphabet character, break from loop
                    i = copy.length();
                    result = false;
                }
            }
        } else {
            // s is null String object
            result = false;
        }
        return result;
    }
}
