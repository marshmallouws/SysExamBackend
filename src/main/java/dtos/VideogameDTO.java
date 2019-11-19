package dtos;

import java.util.HashMap;
import java.util.Map;

public class VideogameDTO {

    public Integer id;
    public String name;
    public String slug;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public VideogameDTO(Integer id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    
}