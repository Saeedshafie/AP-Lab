public class Lab {
    private Student[] students;
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;
    public Lab(int cap, String d) {
        this.capacity = cap;
        this.day = d;
    }
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std; currentSize++;
        }
        else { System.out.println("Lab is full!!!");
        }
    }
    public void print() {
        for (int i = 0;i<students.length;i++){
            System.out.println("Name :" + students[i].getFirstName() + students[i].getLastName() + " , Grade :" + students[i].getGrade());
        }
    }
    public Student[] getStudents() {
        return students;
    }
    public void setStudents(Student[] students) {
        this.students = students;
    }
    public int getAvg() {
        return avg;
    }
    public void calculateAvg() {
        int total = 0;
        for(int i = 0; i < students.length ;i++){
            total = students[i].getGrade();
        }
        avg = total / students.length;
    }
    public String getDay() {
        return day;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
