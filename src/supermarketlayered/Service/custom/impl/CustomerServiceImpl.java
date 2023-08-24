/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.Service.custom.impl;

import java.util.ArrayList;
import java.util.List;
import supermarketlayered.DAO.DaoFactory;
import supermarketlayered.DAO.custom.CustomerDao;
import supermarketlayered.DTO.CustomerDto;
import supermarketlayered.Entity.CustomerEntity;
import supermarketlayered.Service.custom.CustomerService;

/**
 *
 * @author Thenuk De Silva
 */
public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.CUSTOMER);

    @Override
    public String addCustomer(CustomerDto dto) throws Exception {
        CustomerEntity entity = new CustomerEntity(dto.getId(),
                dto.getTitle(), dto.getName(), dto.getDob(),
                dto.getSalary(), dto.getAddress(), dto.getCity(),
                dto.getProvince(), dto.getZip());

        return customerDao.add(entity) ? "Success" : "Fail";
    }

    public ArrayList<CustomerDto> getAllCustomer() throws Exception {
        List<CustomerEntity> customerEntitys = customerDao.getAll();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        for (CustomerEntity entity : customerEntitys) {
            customerDtos.add(new CustomerDto(entity.getId(),
                    entity.getTitle(), entity.getName(),
                    entity.getDob(),
                    entity.getSalary(), entity.getAddress(),
                    entity.getCity(), entity.getProvince(), entity.getZip()));
        }

        return customerDtos;
    }

    public CustomerDto searchCustomer(String custId) throws Exception {
        CustomerEntity entity = customerDao.get(custId);

        CustomerDto dto = new CustomerDto(entity.getId(),
                entity.getTitle(), entity.getName(),
                entity.getDob(),
                entity.getSalary(), entity.getAddress(),
                entity.getCity(), entity.getProvince(), entity.getZip());

        return dto;
    }

    @Override
    public String updateCustomer(CustomerDto dto) throws Exception {
        CustomerEntity ce = new CustomerEntity(dto.getId(), dto.getTitle(), dto.getName(), dto.getDob(), dto.getSalary(), dto.getAddress(), dto.getCity(), dto.getProvince(), dto.getZip());
        if (customerDao.update(ce)) {
            return "Successfully Updated";
        } else {
            return "Fail";
        }
    }

    @Override
    public String deleteCustomer(String id) throws Exception {
        if (customerDao.delete(id)) {
            return "Successfully Deleted";
        } else {
            return "Fail";
        }
    }

    @Override
    public CustomerDto getCustomer(String custId) throws Exception {
        CustomerEntity entity = customerDao.get(custId);
        return new CustomerDto(entity.getId(), entity.getTitle(), entity.getName(), entity.getDob(), entity.getSalary(), entity.getAddress(), entity.getCity(), entity.getProvince(), entity.getZip());

    }

}
