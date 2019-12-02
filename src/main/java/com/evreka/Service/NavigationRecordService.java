package com.evreka.Service;

import com.evreka.Entity.NavigationRecord;
import com.evreka.Repository.NavigationRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavigationRecordService {

    @Autowired
    private NavigationRecordRepo navigationRecordRepo;

    public List<NavigationRecord> getAllNavigationRecords() {
        List<NavigationRecord> navigationRecords = new ArrayList<>();
        navigationRecordRepo.findAll().forEach(navigationRecords::add);
        return navigationRecords;
    }

    public NavigationRecord getNavigationRecord(long id) {
        return navigationRecordRepo.findById(id).orElseThrow(NullPointerException::new);
    }

    public void addNavigationRecord(NavigationRecord navigationRecord) {
        navigationRecordRepo.save(navigationRecord);
    }

    public void updateNavigationRecord(NavigationRecord newNavigationRecord, long id) {
        NavigationRecord navigationRecord = navigationRecordRepo.findById(id).orElseThrow(NullPointerException::new);
        // Assuming none of them Null "Demo"
        navigationRecord.setName(newNavigationRecord.getName());
        navigationRecord.setStatus(newNavigationRecord.getStatus());
        navigationRecord.setPerformance(newNavigationRecord.getPerformance());
        navigationRecord.setDateTime(newNavigationRecord.getDateTime());
        navigationRecord.setLatitude(navigationRecord.getLongitude());
        navigationRecord.setLongitude(newNavigationRecord.getLongitude());
        navigationRecord.setVehicle(newNavigationRecord.getVehicle());
    }

    public void deleteNavigationRecord(long id) {
        navigationRecordRepo.deleteById(id);
    }
}
