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
public class SeriesDTO {
    private String beginDate;
    private String description;
    private String endDate;
    private String fullName;
    private int id;
    private LeagueDTO leauge;
    private int leageId;
    private String modifiedAt;
    private String name;
    private String prizePool;
    private String season;
    private String slug;
    private TournamentDTO tournaments;
    private VideogameDTO videogame;
    private String winnerId;
    private String winnerType;
    private int year;

    public SeriesDTO(String beginDate, String description, String endDate, String fullName, int id, LeagueDTO leauge, int leageId, String modifiedAt, String name, String prizePool, String season, String slug, TournamentDTO tournaments, VideogameDTO videogame, String winnerId, String winnerType, int year) {
        this.beginDate = beginDate;
        this.description = description;
        this.endDate = endDate;
        this.fullName = fullName;
        this.id = id;
        this.leauge = leauge;
        this.leageId = leageId;
        this.modifiedAt = modifiedAt;
        this.name = name;
        this.prizePool = prizePool;
        this.season = season;
        this.slug = slug;
        this.tournaments = tournaments;
        this.videogame = videogame;
        this.winnerId = winnerId;
        this.winnerType = winnerType;
        this.year = year;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LeagueDTO getLeauge() {
        return leauge;
    }

    public void setLeauge(LeagueDTO leauge) {
        this.leauge = leauge;
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

    public String getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(String prizePool) {
        this.prizePool = prizePool;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public TournamentDTO getTournaments() {
        return tournaments;
    }

    public void setTournaments(TournamentDTO tournaments) {
        this.tournaments = tournaments;
    }

    public VideogameDTO getVideogame() {
        return videogame;
    }

    public void setVideogame(VideogameDTO videogame) {
        this.videogame = videogame;
    }

    public String getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(String winnerId) {
        this.winnerId = winnerId;
    }

    public String getWinnerType() {
        return winnerType;
    }

    public void setWinnerType(String winnerType) {
        this.winnerType = winnerType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}



