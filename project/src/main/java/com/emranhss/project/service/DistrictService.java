package com.emranhss.project.service;

import com.emranhss.project.dto.DistrictResponseDTO;
import com.emranhss.project.entity.District;
import com.emranhss.project.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public void save(District district) {

        districtRepository.save(district);
    }


    public List<District> getAllDistrict() {
        return districtRepository.findAll();
    }


    public List<DistrictResponseDTO> getAllDistrictDTOs() {
        List<District> districts = getAllDistrict();

        return districts.stream().map(d -> {
            DistrictResponseDTO dto = new DistrictResponseDTO();
            dto.setId(d.getId());
            dto.setName(d.getName());

            // Map PoliceStations to their IDs only
            List<Integer> psIds = d.getPoliceStations().stream()
                    .map(ps -> ps.getId())
                    .toList();

            dto.setPoliceStations(psIds);
            return dto;
        }).toList();
    }

    public District getDistrictById(int id) {
        return districtRepository.findById(id).get();
    }

    public void deleteDistrictById(int id) {
        districtRepository.deleteById(id);
    }

    public District getDistrictByName(String name) {
        return   districtRepository.findByName(name);
    }

}