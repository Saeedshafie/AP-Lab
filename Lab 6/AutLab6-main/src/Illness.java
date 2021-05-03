public class Illness {
    private Category category;
    private Level level;
    private String title;
    private String description;
    private String date;
    private Doctor doctor;
    private Prescription prescription;

    public Illness(Category category, Level level, String title, String description, String date, Doctor doctor){

    }

    public void addPrescription(Prescription prescription){

    }

    public void printDetails(){

    }

    public void printDoctorDetails(){

    }

    public void printPrescription(){

    }

}

enum Category{
    TYPE1,
    TYPE2,
    TYPE3,
    TYPE4
}

enum Level{
    LEVEL1,
    LEVEL2,
    LEVEL3
}

