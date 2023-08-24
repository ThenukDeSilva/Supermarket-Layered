/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarketlayered.Service.custom;

import java.util.ArrayList;
import supermarketlayered.Service.SuperService;
import supermarketlayered.DTO.CustomerDto;

/**
 *
 * @author Thenuk De Silva
 */
public interface CustomerService extends SuperService {

    String addCustomer(CustomerDto customerDto)throws Exception;
    String updateCustomer(CustomerDto customerDto) throws Exception;
    String deleteCustomer(String id) throws Exception;
    
     ArrayList<CustomerDto> getAllCustomer() throws Exception;

    public CustomerDto getCustomer(String custId) throws Exception;

    public CustomerDto searchCustomer(String custId) throws Exception;

}
