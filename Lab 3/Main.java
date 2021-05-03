public class Main {
    public static void main(String[] args) {
        ClockDisplay T1 = new ClockDisplay();
        T1.setTime(23,0,0);
        for(int i =0;i<10000;i++){
            T1.timeTick();
            System.out.println(T1.getTime());
        }
    }
}
