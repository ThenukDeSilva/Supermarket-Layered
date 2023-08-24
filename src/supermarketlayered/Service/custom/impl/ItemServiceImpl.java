/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.Service.custom.impl;
import java.util.ArrayList;
import java.util.List;
import supermarketlayered.DAO.DaoFactory;
import supermarketlayered.DAO.custom.ItemDao;
import supermarketlayered.DTO.ItemDto;
import supermarketlayered.Entity.ItemEntity;
import supermarketlayered.Service.custom.ItemService;

/**
 *
 * @author Thenuk De Silva
 */
public class ItemServiceImpl implements ItemService {

    ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);

    @Override
    public String addItem(ItemDto dto) throws Exception {
        Boolean resp = itemDao.add(new ItemEntity(dto.getId(), dto.getDescription(), dto.getPackSize(), dto.getUnitPrice(), dto.getQty()));
        return resp ? "Success" : "Fail";
    }

    @Override
    public String updateItem(ItemDto dto) throws Exception {
        Boolean resp = itemDao.update(new ItemEntity(dto.getId(), dto.getDescription(), dto.getPackSize(), dto.getUnitPrice(), dto.getQty()));
        return resp ? "Success" : "Fail";
    }

    @Override
    public String deleteItem(String id) throws Exception {
        Boolean resp = itemDao.delete(id);
        return resp ? "Success" : "Fail";
    }

    @Override
    public ItemDto getItem(String id) throws Exception {
        ItemEntity entity = itemDao.get(id);
        return new ItemDto(entity.getId(),
                entity.getDescription(), entity.getPackSize(),
                entity.getUnitPrice(), entity.getQty());
    }

    @Override
    public ArrayList<ItemDto> getAllItem() throws Exception {
        ArrayList<ItemDto> dtos = new ArrayList<>();
        List<ItemEntity> itemEntitys = itemDao.getAll();
        
        for(ItemEntity entity : itemEntitys){
            ItemDto itemDto = new ItemDto(entity.getId(),entity.getDescription(),entity.getPackSize(),entity.getUnitPrice(),entity.getQty());
         dtos.add(itemDto);
        }   
        return dtos;
    }
    

}
