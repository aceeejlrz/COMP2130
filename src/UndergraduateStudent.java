import java.util.StringJoiner;

public class UndergraduateStudent extends Student{
    public UndergraduateStudent(int studentID, String stdFirstName, String stdLastName, double[] stdMarks, Address stdAddress, String subject, int yearOfEntry) {
        super(studentID, stdFirstName, stdLastName, stdMarks, stdAddress);
        this.subject = subject;
        this.yearOfEntry = yearOfEntry;
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


    // Graduate method
    @Override
    public boolean graduate() {
        return Average() > 50;
    }

    // toString method
    @Override
    public String toString() {
        return "Undergraduate " + super.toString() +
                ", Subject: " + subject +
                ", Year of Entry: " + yearOfEntry +
                ", Eligible to Graduate: " + graduate();
    }

    private String subject;
    private int yearOfEntry;
}
