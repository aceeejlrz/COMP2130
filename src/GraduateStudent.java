import java.util.StringJoiner;

public class GraduateStudent extends Student{
    public GraduateStudent(int studentID, String stdFirstName, String stdLastName, double[] stdMarks, Address stdAddress, String subject, int yearOfEntry, String thesisTopic) {
        super(studentID, stdFirstName, stdLastName, stdMarks, stdAddress);
        this.subject = subject;
        this.yearOfEntry = yearOfEntry;
        this.thesisTopic = thesisTopic;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getYearOfEntry() {
        return yearOfEntry;
    }

    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public String getThesisTopic() {
        return thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this.thesisTopic = thesisTopic;
    }



    private String subject;
    private int yearOfEntry;
    private String thesisTopic;

    // graduate method
    @Override
    public boolean graduate() {
        return Average() > 70;
    }

    @Override
    public String toString() {
        return "Graduate " + super.toString() +
                ", Subject: " + subject +
                ", Year of Entry: " + yearOfEntry +
                ", Thesis Topic: " + thesisTopic +
                ", Eligible to Graduate: " + graduate();
    }

}
