/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.DAO.custom.impl;

import java.util.List;
import supermarketlayered.DAO.CrudUtil;
import supermarketlayered.DAO.custom.OrderDao;
import supermarketlayered.Entity.OrderEntity;
/**
 *
 * @author Thenuk De Silva
 */
public class OrderDaoImpl implements OrderDao{
     @Override
    public boolean add(OrderEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO orders VALUES(?,?,?)", t.getOrderId(),t.getDate(), t.getCustId());
    }

    @Override
    public boolean update(OrderEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public OrderEntity get(String id) throws Exception {
        return null;
    }

    @Override
    public List<OrderEntity> getAll() throws Exception {
        return null;
    }

}

