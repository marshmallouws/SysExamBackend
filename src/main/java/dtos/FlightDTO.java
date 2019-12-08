
package dtos;

/**
 *
 * @author Martin
 */
public class FlightDTO {
    
    String id;
    String startDestination;
    String endDestination;
    String departure;
    String arrival;
    String duration;
    String price;
    String deeplinkUrl;
    String agentsName;
    String imageUrl;
    
    String outboundDate;
    String cabinClass;
    String originPlace;
    String destination;
    String adults; 

    public FlightDTO(String id, String startDestination, String endDestination, String depature, String arrival, String duration, String price, String deeplinkUrl, String agentsName, String imageUrl, String date, String cabinClass, String originPlace, String destination, String adults) {
        this.id = id;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.departure = depature;
        this.arrival = arrival;
        this.duration = duration;
        this.price = price;
        this.deeplinkUrl = deeplinkUrl;
        this.agentsName = agentsName;
        this.imageUrl = imageUrl;
        this.outboundDate = date;
        this.cabinClass = cabinClass;
        this.originPlace = originPlace;
        this.destination = destination;
        this.adults = adults;
    }

    public FlightDTO(String id, String startDestination, String endDestination, String depature, String arrival, String duration, String price, String deeplinkUrl, String agentsName, String imageUrl) {
        this.id = id;
        this.startDestination = startDestination;
        this.endDestination = endDestination;
        this.departure = depature;
        this.arrival = arrival;
        this.duration = duration;
        this.price = price;
        this.deeplinkUrl = deeplinkUrl;
        this.agentsName = agentsName;
        this.imageUrl = imageUrl;
    }

    public FlightDTO(String date, String cabinClass, String originPlace, String destination, String adults) {
        this.outboundDate = date;
        this.cabinClass = cabinClass;
        this.originPlace = originPlace;
        this.destination = destination;
        this.adults = adults;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return departure;
    }

    public void setDepature(String depature) {
        this.departure = depature;
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

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAdults() {
        return adults;
    }

    public void setAdults(String adults) {
        this.adults = adults;
    }

}
