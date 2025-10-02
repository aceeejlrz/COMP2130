import java.util.Arrays;
import java.util.StringJoiner;

public abstract class Student {
    public Student(int studentID, String stdFirstName, String stdLastName, double[] stdMarks, Address stdAddress) {
        this.studentID = studentID;
        this.stdFirstName = stdFirstName;
        this.stdLastName = stdLastName;
        this.stdMarks = stdMarks;
        this.stdAddress = stdAddress;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStdFirstName() {
        return stdFirstName;
    }

    public void setStdFirstName(String stdFirstName) {
        this.stdFirstName = stdFirstName;
    }

    public String getStdLastName() {
        return stdLastName;
    }

    public void setStdLastName(String stdLastName) {
        this.stdLastName = stdLastName;
    }

    public double[] getStdMarks() {
        return stdMarks;
    }

    public void setStdMarks(double[] stdMarks) {
        this.stdMarks = stdMarks;
    }

    public Address getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(Address stdAddress) {
        this.stdAddress = stdAddress;
    }

    private int studentID;
    private String stdFirstName;
    private String stdLastName;
    private double[] stdMarks;
    private Address stdAddress;

    // Calculate average of marks
    public double Average() {
        if (stdMarks == null || stdMarks.length == 0) return 0.0;
        double sum = 0;
        for (double mark : stdMarks) {
            sum += mark;
        }
        return sum / stdMarks.length;
    }

    // Abstract method for graduation eligibility
    public abstract boolean graduate();

    // toString method
    @Override
    public String toString() {
        StringBuilder marksStr = new StringBuilder("[");
        for (int i = 0; i < stdMarks.length; i++) {
            marksStr.append(stdMarks[i]);
            if (i < stdMarks.length - 1) marksStr.append(", ");
        }
        marksStr.append("]");
        return "ID: " + studentID + ", Name: " + stdFirstName + " " + stdLastName +
                ", Marks: " + marksStr + ", Average: " + String.format("%.2f", Average()) +
                ", Address: " + stdAddress.toString();
    }
}
