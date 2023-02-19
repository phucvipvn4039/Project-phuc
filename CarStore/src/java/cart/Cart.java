/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import db.OrderDetail;
import db.OrderHeader;
import db.OrderHeaderFacade;
import db.Product;
import db.ProductFacade;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PHT
 */
public class Cart {
    //Chua danh sach nhung item trong cart
    private Map<Integer,Item> map = null;

    public Cart() {
        this.map = new HashMap<>();
    }

    public Map<Integer, Item> getMap() {
        return map;
    }
    
    public Collection<Item> getItems() {//items
        return map.values();
    }
    
    public int getCount(){
        int count = 0;
        for(Item item: map.values()){
            count += item.getQuantity();
        }
        return count;
    }
    
    public double getTotal() {
        double total = 0;
        for(Item item: map.values()){
            total += item.getCost();
        }
        return total;
    }
    
    public void add(int id, int quantity) throws ClassNotFoundException, SQLException{
        //Lấy item tương ứng với id trong map ra
        Item item = map.get(id);
        //Nếu trong map không có item thì tạo item mới
        if(item == null){
            ProductFacade pf = new ProductFacade();
            Product product = pf.select(id);
            item = new Item(product, quantity);
            map.put(id, item);
        }else{
            //Nếu trong map đã có item thì chỉ cập nhật quantity
            item.setQuantity(item.getQuantity() + quantity);
        }
    }
    
    public void remove(int id){
        this.map.remove(id);
    }
    
    public void update(int id, int quantity){
        Item item = this.map.get(id);
        item.setQuantity(quantity);
    }
    
    public void empty(){
        this.map.clear();
    }
    
    public void checkout(int customerId) throws ClassNotFoundException, SQLException {
        Date date = new Date();
        int employeeId = 2;
        String status = "NEW";//NEW->SHIPPING->CANCEL,CLOSE
        OrderHeader oh = new OrderHeader(date, status, customerId, employeeId);

        for (Item item : this.getItems()) {
            OrderDetail od = new OrderDetail(item.getProduct().getId(), item.getQuantity(), item.getProduct().getPrice(), item.getProduct().getDiscount());
            oh.add(od);
        }

        OrderHeaderFacade ohf = new OrderHeaderFacade();
        ohf.insert(oh);
    }
}
