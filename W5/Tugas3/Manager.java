package Tugas3;

import java.util.Calendar;
import java.util.GregorianCalendar;

class Manager extends Employee {
    private String secretaryName;

    public Manager(String n, double s, int d, int m, int y) {
        super(n, s, d, m, y);
        secretaryName = "";
    }

    public String getSecretaryName() {
        return secretaryName;
    }

    @Override
    public void raiseSalary(double byPercent) {
        // Ambil tahun saat ini
        GregorianCalendar todaysDate = new GregorianCalendar();
        int currentYear = todaysDate.get(Calendar.YEAR);
        
        // Hitung bonus 0.5% per tahun masa kerja
        double bonus = 0.5 * (currentYear - super.hireYear());

        // Tambahkan bonus ke persentase kenaikan gaji
        super.raiseSalary(byPercent + bonus);
    }
}