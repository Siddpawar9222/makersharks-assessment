package com.makersharks.makersharks_assessment.service;

import com.makersharks.makersharks_assessment.exception.CaughtException;
import com.makersharks.makersharks_assessment.model.Manufacturer;
import com.makersharks.makersharks_assessment.model.Response;
import com.makersharks.makersharks_assessment.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

//    @Transactional
//    public List<Manufacturer> searchSupplier(String location) {
//        int pageNumber = 1;
//        int pageSize = 5;
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        Page<Manufacturer> manufacturerPage = manufacturerRepository.findByLocation(location, pageable);
//        List<Manufacturer> listOfManufacturer = manufacturerPage.getContent();
//
//        return listOfManufacturer;
//    }

//    @Transactional
//    public Map<Object,Object> searchSupplier(String location) {
//
//        int pageNumber = 0;
//        int pageSize = 5;
//
//
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        Page<Manufacturer> manufacturerPage = manufacturerRepository.findByLocation(location, pageable);
//
//        Map<Object,Object> mPagination = new HashMap<>();
//        mPagination.put("content",manufacturerPage.getContent());
//
//        mPagination.put("totalElements",manufacturerPage.getTotalElements());
//        mPagination.put("totalPages",manufacturerPage.getTotalPages());
//        mPagination.put("pageSize",manufacturerPage.getPageable().getPageSize());
//        mPagination.put("pageNumber",manufacturerPage.getPageable().getPageNumber());
//        mPagination.put("isFirstPage",manufacturerPage.isFirst());
//        mPagination.put("isLastPage",manufacturerPage.isLast());
//        return mPagination;
//    }

    @Transactional
    public Response searchSupplier(String location, String natureOfBusiness, String manufacturingProcesses, String pageNumber, String pageSize) {
        log.info("searchSupplier service called ::: {} ", new Date());
        log.info("location : {} , natureOfBusiness : {} , manufacturingProcesses : {}, pageNumber : {} , pageSize : {}", location, natureOfBusiness, manufacturingProcesses, pageNumber, pageSize);
        Response response = new Response();

        try {
            int pageNumberInInt = Integer.parseInt(pageNumber);
            int pageSizeInInt = Integer.parseInt(pageSize);

            Pageable pageable = PageRequest.of(pageNumberInInt, pageSizeInInt);
            Page<Manufacturer> manufacturerPage = manufacturerRepository.findByLocationAndNatureOfBusinessAndManufacturingProcesses(location, natureOfBusiness, manufacturingProcesses, pageable);

            Map<Object, Object> mPagination = new HashMap<>();


            mPagination.put("content", manufacturerPage.getContent());
            mPagination.put("totalElements", manufacturerPage.getTotalElements());
            mPagination.put("totalPages", manufacturerPage.getTotalPages());
            mPagination.put("pageSize", manufacturerPage.getPageable().getPageSize());
            mPagination.put("pageNumber", manufacturerPage.getPageable().getPageNumber());
            mPagination.put("isFirstPage", manufacturerPage.isFirst());
            mPagination.put("isLastPage", manufacturerPage.isLast());

            response.setData(mPagination);
            response.setMessage("Data fetched successfully");
            response.setResultCode(200);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            log.error("Exception : {}", e.getMessage());
            throw new NumberFormatException("Page Number or Page Size should be number");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception : {}", e.getMessage());
            throw new CaughtException(e.getMessage());
        }

        log.info("searchSupplier service ended ::: {} ", new Date());

        return response;
    }


}
