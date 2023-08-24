/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.Service.custom.impl;

import supermarketlayered.DAO.DaoFactory;
import supermarketlayered.DAO.custom.ItemDao;
import supermarketlayered.DAO.custom.OrderDao;
import supermarketlayered.DAO.custom.OrderDetailDao;
import supermarketlayered.DTO.OrderDto;
import supermarketlayered.Service.custom.OrderService;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import supermarketlayered.db.DBConnection;
import supermarketlayered.DTO.OrderDetailDto;
import supermarketlayered.Entity.ItemEntity;
import supermarketlayered.Entity.OrderDetailEntity;
import supermarketlayered.Entity.OrderEntity;

/**
 *
 * @author Thenuk De Silva
 */
public class OrderServiceImpl implements OrderService {

    OrderDetailDao orderDetailDao = (OrderDetailDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDERDETAILS);
    ItemDao itemDao = (ItemDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ITEM);
    OrderDao orderDao = (OrderDao) DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.ORDER);

    @Override
    public String placeOrder(OrderDto dto) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (orderDao.add(new OrderEntity(dto.getId(), sdf.format(new Date()), dto.getCustId()))) {
                boolean isOrderDetailAdded = true;

                for (OrderDetailDto detailDto : dto.getDetailDtos()) {

                    if (!orderDetailDao.add(new OrderDetailEntity(dto.getId(), detailDto.getItemCode(), detailDto.getQty(), detailDto.getDisccount()))) {
                        isOrderDetailAdded = false;
                    }
                }

                if (isOrderDetailAdded) {
                    boolean isItemUpdated = true;
                    boolean isQtyExceeding = false;

                    for (OrderDetailDto detailDto : dto.getDetailDtos()) {
                        ItemEntity entity = itemDao.get(detailDto.getItemCode());
                        if (entity.getQty() >= detailDto.getQty()) {
                            entity.setQty(entity.getQty() - detailDto.getQty());
                            if (!itemDao.update(entity)) {
                                isItemUpdated = false;
                            }
                        } else {
                            isItemUpdated = false;
                            isQtyExceeding = true;
                        }
                    }

                    if (isItemUpdated) {
                        connection.commit();
                        return "Success";
                    } else if (isQtyExceeding) {
                        connection.rollback();
                        return "Quantity Exceeds";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }

                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            } else {
                connection.rollback();
                return "Order Save Error";
            }

        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }

}
