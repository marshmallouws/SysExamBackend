package dtos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeriesDTO {

    public String begin_at;
    public Object description;
    public String end_at;
    public String full_name;
    public Integer id;
    public LeagueDTO league;
    public Integer league_id;
    public String modified_at;
    public String name;
    public Object prizepool;
    public Object season;
    public String slug;
    public List<TournamentDTO> tournaments = null;
    public VideogameDTO videogame;

    public SeriesDTO(String begin_at, Object description, String end_at, String full_name, Integer id, LeagueDTO league, Integer league_id, String modified_at, String name, Object prizepool, Object season, String slug, VideogameDTO videogame, Object winner_id, Object winner_type, Integer year) {
        this.begin_at = begin_at;
        this.description = description;
        this.end_at = end_at;
        this.full_name = full_name;
        this.id = id;
        this.league = league;
        this.league_id = league_id;
        this.modified_at = modified_at;
        this.name = name;
        this.prizepool = prizepool;
        this.season = season;
        this.slug = slug;
        this.videogame = videogame;
        this.winner_id = winner_id;
        this.winner_type = winner_type;
        this.year = year;
    }

    
    public String getBegin_at() {
        return begin_at;
    }

    public void setBegin_at(String begin_at) {
        this.begin_at = begin_at;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LeagueDTO getLeague() {
        return league;
    }

    public void setLeague(LeagueDTO league) {
        this.league = league;
    }

    public Integer getLeague_id() {
        return league_id;
    }

    public void setLeague_id(Integer league_id) {
        this.league_id = league_id;
    }

    public String getModified_at() {
        return modified_at;
    }

    public void setModified_at(String modified_at) {
        this.modified_at = modified_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPrizepool() {
        return prizepool;
    }

    public void setPrizepool(Object prizepool) {
        this.prizepool = prizepool;
    }

    public Object getSeason() {
        return season;
    }

    public void setSeason(Object season) {
        this.season = season;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<TournamentDTO> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<TournamentDTO> tournaments) {
        this.tournaments = tournaments;
    }

    public VideogameDTO getVideogame() {
        return videogame;
    }

    public void setVideogame(VideogameDTO videogame) {
        this.videogame = videogame;
    }

    public Object getWinner_id() {
        return winner_id;
    }

    public void setWinner_id(Object winner_id) {
        this.winner_id = winner_id;
    }

    public Object getWinner_type() {
        return winner_type;
    }

    public void setWinner_type(Object winner_type) {
        this.winner_type = winner_type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
public Object winner_id;
public Object winner_type;
public Integer year;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}