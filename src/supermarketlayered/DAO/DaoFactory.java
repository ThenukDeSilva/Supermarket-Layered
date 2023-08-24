/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.DAO;

import supermarketlayered.DAO.custom.impl.CustomerDaoImpl;
import supermarketlayered.DAO.custom.impl.ItemDaoImpl;
import supermarketlayered.DAO.custom.impl.OrderDaoImpl;
import supermarketlayered.DAO.custom.impl.OrderDetailDaoImpl;

/**
 *
 * @author Thenuk De Silva
 */
public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory() {

    }

   public static DaoFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        
        return daoFactory;
    }
    
    public SuperDao getDao(DaoTypes type){
        switch (type) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return  new OrderDaoImpl();
            case ORDERDETAILS:
                return new OrderDetailDaoImpl();
            default:
                return null;
        }
    }
    
    public enum DaoTypes{
        CUSTOMER, ITEM, ORDER, ORDERDETAILS
    }
}
