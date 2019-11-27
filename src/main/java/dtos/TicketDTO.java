/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Ticket;

/**
 *
 * @author Annika
 */
public class TicketDTO {
    private int series_id;
    private String username;
    private int amount;
    
    public TicketDTO(int series_id, String username, int amount) {
        this.series_id = series_id;
        this.username = username;
        this.amount = amount;
    }
    
    public TicketDTO(Ticket t) {
        this.series_id = t.getSeriesId();
        this.username = t.getBuyer().getUserName();
        this.amount = t.getAmount();
    }

    public int getSeries_id() {
        return series_id;
    }

    public void setSeries_id(int series_id) {
        this.series_id = series_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getAmount() {
        return amount;
    }
}
