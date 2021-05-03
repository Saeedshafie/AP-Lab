public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Saeed","Shafie","9831036");
        Student st2 = new Student("Ali","Ahmadi","9831034");
        Student st3 = new Student("Reza","Rezapour","9831035");
        st1.print();
        st1.setFirstName("Nima");
        st1.print();

        st2.print();
        st2.setGrade(20);
        st2.print();

        st3.print();
        st3.setFirstName("HamidReza");
        st3.print();
    }
}
