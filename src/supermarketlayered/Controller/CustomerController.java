/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.Controller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import supermarketlayered.DTO.CustomerDto;
import supermarketlayered.Service.ServiceFactory;
import supermarketlayered.Service.custom.CustomerService;
/**
 *
 * @author Thenuk De Silva
 */
public class CustomerController {
     private CustomerService customerService = (CustomerService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.CUSTOMER);
     
     public String saveCustomer(CustomerDto customerDto) throws Exception{
        return customerService.addCustomer(customerDto);
    }

    public ArrayList<CustomerDto> getAllCustomers() throws Exception{
        return customerService.getAllCustomer();
    }

    public CustomerDto searchCustomer(String custId) throws Exception{
        return customerService.searchCustomer(custId);
    
}

    public String updateCustomer(CustomerDto customer) throws Exception {
             return customerService.updateCustomer(customer);
        
    }

    public String deleteCustomer(String id) throws Exception {
    return customerService.deleteCustomer(id);
    }
}
