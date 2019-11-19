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
public class LeagueDTO {
    private int id;
    private String image_url;
    private boolean isLiveSupported;
    private String modifiedAt;
    private String name;
    private String slug;
    private String url;

    public LeagueDTO(int id, String image_url, boolean isLiveSupported, String modifiedAt, String name, String slug, String url) {
        this.id = id;
        this.image_url = image_url;
        this.isLiveSupported = isLiveSupported;
        this.modifiedAt = modifiedAt;
        this.name = name;
        this.slug = slug;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isIsLiveSupported() {
        return isLiveSupported;
    }

    public void setIsLiveSupported(boolean isLiveSupported) {
        this.isLiveSupported = isLiveSupported;
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

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
