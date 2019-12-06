
package dtos;

/**
 *
 * @author Martin
 */
public class FlightDTO {
    
    int id;
    String startDestination;
    String endDestination;
    String depature;
    String arrival;
    String duration;
    String price;
    String deeplinkUrl;
    String agentsName;
    String imageUrl;
    String date;

    public FlightDTO(int id, String startDestination, String endDestination, String depature, String arrival, String duration, String price, String deeplinkUrl, String agentsName, String imageUrl, String date) {
        this.id = id;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.depature = depature;
        this.arrival = arrival;
        this.duration = duration;
        this.price = price;
        this.deeplinkUrl = deeplinkUrl;
        this.agentsName = agentsName;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDestination() {
        return startDestination;
    }

    public void setStartDestination(String startDestination) {
        this.startDestination = startDestination;
    }

    public String getEndDestination() {
        return endDestination;
    }

    public void setEndDestination(String endDestination) {
        this.endDestination = endDestination;
    }

    public String getDepature() {
        return depature;
    }

    public void setDepature(String depature) {
        this.depature = depature;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeeplinkUrl() {
        return deeplinkUrl;
    }

    public void setDeeplinkUrl(String deeplinkUrl) {
        this.deeplinkUrl = deeplinkUrl;
    }

    public String getAgentsName() {
        return agentsName;
    }

    public void setAgentsName(String agentsName) {
        this.agentsName = agentsName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
