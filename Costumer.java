/**
 * Costumer bilgilerini tutan Costemer sinifi
 * Her memberinin getter ve setterlari bulunuyor
 */
package com.mycompany.hw7_111044054;

/**
 *
 * @author osman
 */
public class Costumer {

  
    private int arrivalTimeHour;
    private int arrivalTimeMinute;
    private int serviceTime;
    private String costumerType;
    public Costumer(){
        arrivalTimeHour=arrivalTimeMinute=serviceTime=-1;
        costumerType=null;
    }
    
    public Costumer(int arrivalTimeHour, int arrivalTimeMinute, int serviceTime, String costumerType) {
        this.arrivalTimeHour = arrivalTimeHour;
        this.arrivalTimeMinute = arrivalTimeMinute;
        this.serviceTime = serviceTime;
        this.costumerType = costumerType;
    }

    /**
     * 
     * @param arrivalTimeHour 
     */
    public void setArrivalTimeHour(int arrivalTimeHour) {
        this.arrivalTimeHour = arrivalTimeHour;
    }

    public void setArrivalTimeMinute(int arrivalTimeMinute) {
        this.arrivalTimeMinute = arrivalTimeMinute;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setCostumerType(String costumerType) {
        this.costumerType = costumerType;
    }

    public int getArrivalTimeHour() {
        return arrivalTimeHour;
    }

    public int getArrivalTimeMinute() {
        return arrivalTimeMinute;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public String getCostumerType() {
        return costumerType;
    }
   
    
}
