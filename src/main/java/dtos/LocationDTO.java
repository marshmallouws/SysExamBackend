/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Victor
 */
public class LocationDTO {
    public String name, address, airport, airport_id;

    public LocationDTO(String name, String address, String airport, String airport_id) {
        this.name = name;
        this.address = address;
        this.airport = airport;
        this.airport_id = airport_id;
    }

    public void setAirport_id(String airport_id) {
        this.airport_id = airport_id;
    }

    public String getAirport_id() {
        return airport_id;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getAirport() {
        return airport;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
