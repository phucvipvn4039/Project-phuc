/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author PHT
 */
public class Customer extends Account {
    private String category;
    private String shipToAddress;

    public Customer() {
        super();
    }

    public Customer(int id, String name, String address, String phone, String email, String password, boolean enabled, String role, String category, String shipToAddress) {
        super(id, name, address, phone, email, password, enabled, role);
        this.category = category;
        this.shipToAddress = shipToAddress;
    }

    public Customer(String name, String address, String phone, String email, String password, boolean enabled, String role, String category, String shipToAddress) {
        super(name, address, phone, email, password, enabled, role);
        this.category = category;
        this.shipToAddress = shipToAddress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(String shipToAddress) {
        this.shipToAddress = shipToAddress;
    }
        
}
