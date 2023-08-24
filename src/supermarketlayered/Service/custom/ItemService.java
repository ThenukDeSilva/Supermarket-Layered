/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package supermarketlayered.Service.custom;

import java.util.ArrayList;
import java.util.List;
import supermarketlayered.DTO.ItemDto;
import supermarketlayered.Service.SuperService;

/**
 *
 * @author anjanathrishakya
 */
public interface ItemService extends SuperService{
    
    String addItem(ItemDto dto) throws Exception;
    String updateItem(ItemDto dto) throws Exception;
    String deleteItem(String id) throws Exception;
    ItemDto getItem(String id) throws Exception;
    ArrayList<ItemDto> getAllItem() throws Exception;
}