/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarketlayered.Service.custom;
import supermarketlayered.DTO.OrderDto;
import supermarketlayered.Service.SuperService;
/**
 *
 * @author Thenuk De Silva
 */
public interface OrderService extends SuperService{
    String placeOrder(OrderDto dto) throws Exception;
}