package dtos;

import java.util.HashMap;
import java.util.Map;

public class LeagueDTO {

    public Integer id;
    public String image_url;
    public Boolean live_supported;
    public String modified_at;
    public String name;
    public String slug;
    public Object url;
    public Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public LeagueDTO(Integer id, String image_url, Boolean live_supported, String modified_at, String name, String slug, Object url) {
        this.id = id;
        this.image_url = image_url;
        this.live_supported = live_supported;
        this.modified_at = modified_at;
        this.name = name;
        this.slug = slug;
        this.url = url;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Boolean getLive_supported() {
        return live_supported;
    }

    public void setLive_supported(Boolean live_supported) {
        this.live_supported = live_supported;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
    
    
}
