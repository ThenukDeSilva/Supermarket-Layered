/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.Controller;

import supermarketlayered.DTO.OrderDto;
import supermarketlayered.Service.ServiceFactory;
import supermarketlayered.Service.custom.OrderService;

/**
 *
 * @author Thenuk De Silva
 */
public class OrderController {
     private OrderService orderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    
    public String placeOrder(OrderDto orderDto) throws Exception{
        return orderService.placeOrder(orderDto);
    }
}
