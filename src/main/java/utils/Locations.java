/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dtos.LocationDTO;

/**
 *
 * @author Victor
 */
public class Locations {
      private static final LocationDTO[] locations = {
          new LocationDTO("Esport Arena Santa Ana","120 W. 5TH ST, SANTA ANA, CA 92701", "John Wayne Airport", "SNA-sky"),
          new LocationDTO("Esport Arena Oakland","255 2ND ST OAKLAND, CA 94607", "Oakland International Airport", "OAK-sky"),
          new LocationDTO("Esport Arena Las Vegas","Luxor Hotel & Casino 3900 S. Las Vegas Blvd. Las Vegas, NV 89119", "McCarran International Airport", "LAS-sky"),
          new LocationDTO("Anaheim Convention Center","800 W Katella Ave, Anaheim, CA 92802, USA", "Los Angeles International Airport", "LAX-sky"),
          new LocationDTO("Dreamhack","Elmiavägen 15, 554 54 Jönköping, Sweden", "Jönköping Airport", "JKG-sky"),
        };
      
      public static LocationDTO getLocation(int eventId){
          return locations[eventId%5];
      }
}
