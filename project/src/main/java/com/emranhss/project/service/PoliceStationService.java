package com.emranhss.project.service;

import com.emranhss.project.entity.PoliceStation;
import com.emranhss.project.repository.PoliceStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliceStationService {

    @Autowired
    private PoliceStationRepository policeStationRepository;


    public void saveOrUpdate(PoliceStation ps) {
        policeStationRepository.save(ps);
    }


    public List<PoliceStation> findAll() {

        return policeStationRepository.findAll();
    }

    public Optional<PoliceStation> findById(Integer id) {
        return policeStationRepository.findById(id);
    }

    public void deleteById(Integer id) {
        policeStationRepository.deleteById(id);
    }

}