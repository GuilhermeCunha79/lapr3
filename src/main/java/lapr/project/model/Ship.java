package lapr.project.model;

import lapr.project.utils.CommonMethods;

public class Ship implements Comparable<Ship> {

    private static final double POWER_OUTPUT = 20;
    private static final double LAT_MAX = 90;
    private static final double LAT_MIN = -90;
    private static final double LON_MAX = 180;
    private static final double LON_MIN = -180;
    private static final int MMSI_DIGITS = 9;
    private static final double COG_HEAD_MIN = 0;
    private static final double COG_HEAD_MAX = 359;

    private int mmsi;
    private String dateTime;
    private double latitude;
    private double longitude;
    private float sog;
    private float cog;
    private int heading;
    private String vesselName;
    private String imo;
    private String callSign;
    private int vesselType;
    private int length;
    private int width;
    private double draft;
    private String cargo;
    private String transcieverClass;
    private double powerOutput;

    /**
     * @param mmsi
     * @param dateTime
     * @param latitude
     * @param longitude
     * @param sog
     * @param cog
     * @param heading
     * @param vesselName
     * @param imo
     * @param callSign
     * @param vesselType
     * @param length
     * @param width
     * @param draft
     * @param cargo
     * @param transcieverClass
     */
    public Ship(int mmsi, String dateTime, double latitude, double longitude, float sog, float cog, int heading, String vesselName, String imo, String callSign, int vesselType, int length, int width, double draft, String cargo, String transcieverClass) {
        this.mmsi = mmsi;
        this.dateTime = dateTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sog = sog;
        this.cog = cog;
        this.heading = heading;
        this.vesselName = vesselName;
        this.imo = imo;
        this.callSign = callSign;
        this.vesselType = vesselType;
        this.length = length;
        this.width = width;
        this.draft = draft;
        this.cargo = cargo;
        this.transcieverClass = transcieverClass;
        this.powerOutput = POWER_OUTPUT;
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
    public float getSog() {
        return sog;
    }

    /**
     * Method that returns the COG
     *
     * @return cog
     */
    public float getCog() {
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
     * Method that returns the Vessel Name
     *
     * @return vesselName
     */
    public String getVesselName() {
        return vesselName;
    }

    /**
     * Method that returns the IMO code
     *
     * @return imo
     */
    public String getImo() {
        return imo;
    }

    /**
     * Method that returns the Vessel type
     *
     * @return vesselType
     */
    public int getVesselType() {
        return vesselType;
    }

    /**
     * Method that returns the Length
     *
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Method that returns the Width
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method that sets the mmsi code
     *
     * @param mmsi
     */
    public void setMmsi(int mmsi) {
        if (mmsi == MMSI_DIGITS) {
            this.mmsi = mmsi;
        } else {
            throw new NullPointerException("The MMSI code must have 9 number digits");
        }
    }

    /**
     * Method that sets the date time
     *
     * @param dateTime
     */
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Method that sets the latitude
     *
     * @param latitude
     */
    public void setLatitude(double latitude) {
        if (LAT_MIN <= latitude && latitude <= LAT_MAX) {
            this.latitude = latitude;
        } else {
            throw new NullPointerException("not available");
        }
    }

    /**
     * Methos that sets the longitude
     *
     * @param longitude
     */
    public void setLongitude(double longitude) {
        if (LON_MIN <= longitude && longitude <= LON_MAX) {
            this.longitude = longitude;
        } else {
            throw new NullPointerException("not available");
        }
    }

    /**
     * method that sets the SOG
     *
     * @param sog
     */
    public void setSog(float sog) {
        this.sog = sog;
    }

    /**
     * Method that sets the COG
     *
     * @param cog
     */
    public void setCog(float cog) {
        if (COG_HEAD_MIN <= cog && cog <= COG_HEAD_MAX) {
            this.cog = cog;
        } else {
            throw new NullPointerException("not available");
        }
    }

    /**
     * Method that sets the heading
     *
     * @param heading
     */
    public void setHeading(int heading) {
        if (COG_HEAD_MIN <= heading && heading <= COG_HEAD_MAX) {
            this.heading = heading;
        } else {
            throw new NullPointerException("not available");
        }

    }

    /**
     * Method that sets the Vessel Name
     *
     * @param vesselName
     */
    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    /**
     * Method that sets the IMO code
     *
     * @param imo
     */
    public void setImo(String imo) {
        if (imoVerification(imo)) {
            this.imo = imo;
        } else {
            throw new NullPointerException("not available");
        }
    }

    /**
     * Method that returns the Call Sign
     *
     * @return callSign
     */
    public String getCallSign() {
        return callSign;
    }

    /**
     * Method that returns the Draft
     *
     * @return draft
     */
    public double getDraft() {
        return draft;
    }

    /**
     * Method that return the Cargo
     *
     * @return cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Method that returns the Transciever Class
     *
     * @return transcieverClass
     */
    public String getTranscieverClass() {
        return transcieverClass;
    }

    /**
     * Method that returns the Power Output
     * @return powerOutput
     */
    public double getPowerOutput() {
        return powerOutput;
    }

    /**
     * Method that sets the Call Sign
     *
     * @param callSign
     */
    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    /**
     * Method that sets the Vessel Type
     *
     * @param vesselType
     */
    public void setVesselType(int vesselType) {
        if (vesselType > 0) {
            this.vesselType = vesselType;
        } else {
            throw new NullPointerException("not available");
        }
    }


    /**
     * Method that sets the Length
     *
     * @param length
     */
    public void setLength(int length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new NullPointerException("not available");
        }
    }

    /**
     * Method that sets the Width
     *
     * @param width
     */
    public void setWidth(int width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new NullPointerException("Must be bigger than 0");
        }
    }

    /**
     * Method that sets the Draft
     *
     * @param draft
     */
    public void setDraft(double draft) {
        this.draft = draft;
    }

    /**
     * Method that sets the Cargo
     *
     * @param cargo
     */
    public void setCargo(String cargo) {
        if (cargo.length() == 2 && CommonMethods.checkIfStringJustHaveLetters(cargo)) {
            this.cargo = cargo;
        } else {
            throw new NullPointerException("not available");
        }
    }

    /**
     * Method that sets the Transciever Class
     *
     * @param transcieverClass
     */
    public void setTranscieverClass(String transcieverClass) {
        if (transcieverClass.length() > 1 && CommonMethods.checkIfStringJustHaveLetters(transcieverClass)) {
            throw new NullPointerException("not available");
        } else {
            this.transcieverClass = transcieverClass;
        }
    }

    /**
     * Method that sets the power output
     * @param powerOutput
     */
    public void setPowerOutput(double powerOutput) {
        this.powerOutput = powerOutput;
    }

    /**
     * Method that verify if IMO code respect the rules
     * @param imo
     * @return true or false
     */
    public boolean imoVerification(String imo) {
        return imo.charAt(0) == 'I' && imo.charAt(1) == 'M' && imo.charAt(2) == 'O' && imo.length() == 7;
    }

    /**
     * Method that compares two Ships
     * @param o
     * @return 0 or 1
     */
    @Override
    public int compareTo(Ship o) {
        if (this.mmsi < o.getMmsi())
            return 0;
        return 1;
    }
}