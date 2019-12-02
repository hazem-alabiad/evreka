package com.evreka;

import com.evreka.Entity.NavigationRecord;
import com.evreka.Entity.Vehicle;
import com.evreka.Service.NavigationRecordService;
import com.evreka.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.*;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}

@Component
class SeederCommandLineRunner implements CommandLineRunner{

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private NavigationRecordService navigationRecordService;

    @Override
    public void run(String... args) throws Exception {

        /////////////// Vehicle One ///////////////
        Vehicle v1 = new Vehicle("01 GUY 98", "Kia", "Ahmet Yurt");
        List<NavigationRecord> navigationRecordV1 = new ArrayList<NavigationRecord>();

        Date d1 = new GregorianCalendar(2019, Calendar.DECEMBER, 2, 15, 21).getTime();
        NavigationRecord nr1 = new NavigationRecord(v1, d1, 12.23f, 34.21f, "nav rec 1", "Dispatched", "12 / 70");
        navigationRecordV1.add(nr1);

        Date d2 = new GregorianCalendar(2019, Calendar.DECEMBER, 1, 2, 10).getTime();
        NavigationRecord nr2 = new NavigationRecord(v1, d2, 12.89f, 904.2981f, "nav rec 2", "Finished", "89 / 100");
        navigationRecordV1.add(nr2);

        v1.setNavigationRecords(navigationRecordV1);

        vehicleService.addVehicle(v1);


        /////////////// Vehicle Two ///////////////
        Vehicle v2 = new Vehicle("31 UYK 28", "Verna", "Mahmut Nissan");
        List<NavigationRecord> navigationRecordV2 = new ArrayList<NavigationRecord>();

        Date d3 = new GregorianCalendar(2019, Calendar.NOVEMBER, 20, 20, 0).getTime();
        NavigationRecord nr3 = new NavigationRecord(v2, d3, 98.23f, 73.21f, "nav rec 3", "Finished", "76 / 90");
        navigationRecordV2.add(nr3);

        Date d4 = new GregorianCalendar(2019, Calendar.DECEMBER, 2, 21, 10).getTime();
        NavigationRecord nr4 = new NavigationRecord(v2, d4, 12.89f, 904.2981f, "nav rec 4", "Finished", "24 / 45");
        navigationRecordV2.add(nr4);

        v2.setNavigationRecords(navigationRecordV2);

        vehicleService.addVehicle(v2);

        /////////////// Vehicle Three ///////////////
        Vehicle v3 = new Vehicle("06 HAZ 994", "Maybach", "Hazem Alabiad");
        List<NavigationRecord> navigationRecordV3 = new ArrayList<NavigationRecord>();

        Date d5 = new GregorianCalendar(2019, Calendar.NOVEMBER, 2, 20, 47).getTime();
        NavigationRecord nr5 = new NavigationRecord(v3, d5, 1.22f, 27.71f, "nav rec 5", "Finished", "98 / 128");
        navigationRecordV3.add(nr5);

        v3.setNavigationRecords(navigationRecordV3);

        vehicleService.addVehicle(v3);
    }
}
