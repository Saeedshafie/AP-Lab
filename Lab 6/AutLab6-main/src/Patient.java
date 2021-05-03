import java.util.ArrayList;

public class Patient {
        private String name;
        private String id;
        private String birthDate;
        private String gender;
        private BaseInsurance baseInsurance;
        private Insurance insurance;
        private String degree;
        private String vocation;
        private String address;

        private ArrayList<Doctor> doctors;
        private MedicalRecord healthRecord;

        public void addDoctor(Doctor doctor){

        }

        public void printDetails(){

        }

        public void printHealthRecord(){

        }

        public void printDoctors(){

        }

        public MedicalRecord getHealthRecord(){
            return healthRecord;
        }
    }

    enum BaseInsurance{
        TYPE1,
        TYPE2,
        TYPE3,
        NONE
    }

    enum Insurance{
        TYPE1,
        TYPE2,
        TYPE3,
        NONE
    }

