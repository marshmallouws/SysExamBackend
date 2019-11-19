/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Annika
 */
public class TournamentDTO {
    private String beginAt;
    private String endAt;
    private int id;
    private int leageId;
    private String modifiedAt;
    private String name;
    private String prizepool;
    private int seriesId;
    private String slug;
    private int winnerId;
    private String winnerType;

    public TournamentDTO(String beginAt, String endAt, int id, int leageId, String modifiedAt, String name, String prizepool, int seriesId, String slug, int winnerId, String winnerType) {
        this.beginAt = beginAt;
        this.endAt = endAt;
        this.id = id;
        this.leageId = leageId;
        this.modifiedAt = modifiedAt;
        this.name = name;
        this.prizepool = prizepool;
        this.seriesId = seriesId;
        this.slug = slug;
        this.winnerId = winnerId;
        this.winnerType = winnerType;
    }

    public String getBeginAt() {
        return beginAt;
    }

    public void setBeginAt(String beginAt) {
        this.beginAt = beginAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeageId() {
        return leageId;
    }

    public void setLeageId(int leageId) {
        this.leageId = leageId;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrizepool() {
        return prizepool;
    }

    public void setPrizepool(String prizepool) {
        this.prizepool = prizepool;
    }

    public int getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(int seriesId) {
        this.seriesId = seriesId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public String getWinnerType() {
        return winnerType;
    }

    public void setWinnerType(String winnerType) {
        this.winnerType = winnerType;
    }
}
