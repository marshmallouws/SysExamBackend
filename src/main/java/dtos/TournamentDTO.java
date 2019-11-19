package dtos;

import java.util.HashMap;
import java.util.Map;


public class TournamentDTO {

    public String begin_at;
    public String end_at;
    public Integer id;
    public Integer league_id;
    public String modified_at;
    public String name;
    public Object prizepool;
    public Integer serie_id;
    public String slug;
    public Object winner_id;
    public Object winner_type;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public TournamentDTO(String begin_at, String end_at, Integer id, Integer league_id, String modified_at, String name, Object prizepool, Integer serie_id, String slug, Object winner_id, Object winner_type) {
        this.begin_at = begin_at;
        this.end_at = end_at;
        this.id = id;
        this.league_id = league_id;
        this.modified_at = modified_at;
        this.name = name;
        this.prizepool = prizepool;
        this.serie_id = serie_id;
        this.slug = slug;
        this.winner_id = winner_id;
        this.winner_type = winner_type;
    }

    
    
    public String getBegin_at() {
        return begin_at;
    }

    public void setBegin_at(String begin_at) {
        this.begin_at = begin_at;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSerie_id() {
        return serie_id;
    }

    public void setSerie_id(Integer serie_id) {
        this.serie_id = serie_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    
}