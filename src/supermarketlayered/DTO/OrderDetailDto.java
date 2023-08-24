/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.DTO;

/**
 *
 * @author Thenuk De Silva
 */
public class OrderDetailDto {
    private String itemCode;
    private Integer qty;
    private Double disccount;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String itemCode, Integer qty, Double disccount) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.disccount = disccount;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getDisccount() {
        return disccount;
    }

    public void setDisccount(Double disccount) {
        this.disccount = disccount;
    }

    @Override
    public String toString() {
        return "OrderDetailDto{" + "itemCode=" + itemCode + ", qty=" + qty + ", disccount=" + disccount + '}';
    }
    
}
