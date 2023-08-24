/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarketlayered.DTO;
import java.util.List;
/**
 *
 * @author Thenuk De Silva
 */
public class OrderDto {
       private String id;
    private String custId;
    
    private List<OrderDetailDto> detailDtos;

    public OrderDto() {
    }

    public OrderDto(String id, String custId, List<OrderDetailDto> detailDtos) {
        this.id = id;
        this.custId = custId;
        this.detailDtos = detailDtos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public List<OrderDetailDto> getDetailDtos() {
        return detailDtos;
    }

    public void setDetailDtos(List<OrderDetailDto> detailDtos) {
        this.detailDtos = detailDtos;
    }

    @Override
    public String toString() {
        return "OrderDto{" + "id=" + id + ", custId=" + custId + ", detailDtos=" + detailDtos + '}';
    }
    
}
