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
    
    public TicketDTO(int series_id, String username) {
        this.series_id = series_id;
        this.username = username;
    }
    
    public TicketDTO(Ticket t) {
        this.series_id = t.getSeriesId();
        this.username = t.getBuyer().getUserName();
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
}
