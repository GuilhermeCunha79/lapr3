package lapr.project.model;

import lapr.project.utils.CommonMethods;
import lapr.project.utils.Constants;
import lapr.project.utils.DTO.PositionDTO;

public class Position implements Comparable<Position> {

    private int mmsi;
    private String dateTime;
    private double latitude;
    private double longitude;
    private double sog;
    private double cog;
    private int heading;
    private int position=0;
    private String transcieverClass;


    public Position(PositionDTO dto) {
        setMmsi(dto.getMmsi());
        setDateTime(dto.getDateTime());
        setLatitude(dto.getLatitude());
        setLongitude(dto.getLongitude());
        setSog(dto.getSog());
        setCog(dto.getCog());
        setHeading(dto.getHeading());
        setPosition(dto.getPosition());
        setTranscieverClass(dto.getTranscieverClass());
    }

    /**
     * Method that returns the mmsi code
     *
     * @return mmsi
     */
    public int getMmsi() {
        return mmsi;
    }

    /**
     * Method that returns the date
     *
     * @return dateTime
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Method that returns the latitude
     *
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Method that returns the longitude
     *
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Method that returns the SOG
     *
     * @return sog
     */
    public double getSog() {
        return sog;
    }

    /**
     * Method that returns the COG
     *
     * @return cog
     */
    public double getCog() {
        return cog;
    }

    /**
     * Method that returns the heading
     *
     * @return heading
     */
    public int getHeading() {
        return heading;
    }

    /**
     * Method that returns the Transciever Class
     *
     * @return transcieverClass
     */
    public String getTranscieverClass() {
        return transcieverClass;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position=position;
    }
    /**
     * Method that sets the date time
     *
     * @param dateTime
     */
    public void setDateTime(String dateTime) {
        if (dateTime == null)
            throw new NullPointerException(Constants.NOT_AVAILABLE);
        this.dateTime = dateTime;
    }

    /**
     * Method that sets the latitude
     *
     * @param latitude
     */
    public void setLatitude(double latitude) {
        if (CommonMethods.isValidLatitude(latitude)) {
            this.latitude = latitude;
        } else {
            throw new IllegalArgumentException(Constants.NOT_AVAILABLE);
        }
    }

    /**
     * Method that sets the mmsi code
     *
     * @param mmsi
     */
    public void setMmsi(int mmsi) {
        if (String.valueOf(mmsi).length() == Constants.MMSI_DIGITS)
            this.mmsi = mmsi;
        if (String.valueOf(mmsi).length() != Constants.MMSI_DIGITS)
            throw new IllegalArgumentException("The MMSI code must have 9 number digits");
    }

    /**
     * Methos that sets the longitude
     *
     * @param longitude
     */
    public void setLongitude(double longitude) {
        if (CommonMethods.isValidLongitude(longitude)) {
            this.longitude = longitude;
        } else {
            throw new IllegalArgumentException(Constants.NOT_AVAILABLE);
        }
    }

    /**
     * Method that sets the COG
     *
     * @param cog
     */
    public void setCog(double cog) {
        if (Constants.COG_HEAD_MIN <= cog && cog <= Constants.COG_HEAD_MAX) {
            this.cog = cog;
        } else {
            throw new IllegalArgumentException("not available");// not available
        }
    }

    /**
     * Method that sets the SOG
     *
     * @param sog
     */
    public void setSog(double sog) {
        this.sog = sog;
    }


    /**
     * Method that sets the heading
     *
     * @param heading
     */
    public void setHeading(int heading) {
        if (Constants.COG_HEAD_MIN <= heading && heading <= Constants.COG_HEAD_MAX) {
            this.heading = heading;
        } else {
            throw new IllegalArgumentException("not available");
        }

    }


    /**
     * Method that sets the Transciever Class
     *
     * @param transcieverClass
     */
    public void setTranscieverClass(String transcieverClass) {
        if (transcieverClass == null)
            throw new NullPointerException(Constants.NOT_AVAILABLE);
        if (transcieverClass.length() == 1 && CommonMethods.checkIfStringJustHaveLetters(transcieverClass)) {
            this.transcieverClass = transcieverClass;
        }else{
            throw new IllegalArgumentException("not available");
        }
    }

    @Override
    public int compareTo(Position o) {
       return 0;
    }
}

