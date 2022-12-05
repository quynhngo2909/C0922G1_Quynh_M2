package utils;

import java.util.regex.Pattern;

public class RegularExpression {

    /*
   -	Ngày sinh phải nhỏ hơn ngày hiện tại 18 năm, người dùng không được quá 100 tuổi và phải đúng định dạng dd/mm/YYYY (sử dụng User Exception)
   */
    private static final String FACILITY_VILLA_ID = "^(SVVL)-\\d{4}$";
    private static final String FACILITY_ROOM_ID = "^(SVRO)-\\d{4}$";
    private static final String FACILITY_NAME = "^[A-Z][a-z]*$";
    private static final String USABLE_AREA = "^\\d*(\\.\\d+)?$";
    private static final String SWIMMING_POOL_AREA = "^\\d*(\\.\\d+)?$";
    private static final String RENTAL_FEE = "^\\d+$";
    private static final String MAX_CAP = "^\\d+$";
    private static final String FLOOR_NUMBER = "^\\d+$";
    private static final String RENTAL_TYPE = "^[A-Z][a-z]*$";
    private static final String ROOM_STANDARD = "^[A-Z][a-z]*$";

    public static boolean validVillaID(String villaID) {
        if (Pattern.matches(FACILITY_VILLA_ID, villaID)) {
            return true;
        } else {
            System.out.println("Villa ID must be in format \"SVVL-YYYY\", with YYYY is numbers from 0-9");
            return false;
        }
    }

    public static boolean validRoomID(String roomID) {
        if (Pattern.matches(FACILITY_ROOM_ID, roomID)) {
            return true;
        } else {
            System.out.println("Room ID must be in format \"SVRO-YYYY\", with YYYY is numbers from 0-9");
            return false;
        }
    }

    public static boolean validFacilityName(String facilityName) {
        if (!Pattern.matches(FACILITY_NAME, facilityName)) {
            System.out.println("Facility name must begin with a capital character, and normal character onwards.");
            return false;
        } else {
            return true;
        }
    }

    public static boolean validUsableArea(String usableAre) {
        if (!Pattern.matches(USABLE_AREA, usableAre)) {
            System.out.println("Usable area must be a real number and bigger than 30");
            return false;
        } else {
            double uArea = Double.parseDouble(usableAre);
            if (uArea <= 30) {
                System.out.println("Usable area must be a real number and bigger than 30");
                return false;
            } else {
                return true;
            }
        }
    }

        public static boolean validSwimmingPoolArea (String swimmingPoolArea){
            if (!Pattern.matches(SWIMMING_POOL_AREA, swimmingPoolArea)) {
                System.out.println("Swimming pool area must be a real number and bigger than 30");
                return false;
            } else {
                double spArea = Double.parseDouble(swimmingPoolArea);
                if (spArea <= 30) {
                    System.out.println("Swimming pool area must be a real number and bigger than 30");
                    return false;
                } else {
                    return true;
                }
            }
        }

        public static boolean validRentalFee (String rentalFee) {
            if (!Pattern.matches(RENTAL_FEE, rentalFee)) {
                System.out.println("Rental fee must be a positive real number.");
                return false;
            } else {
                double rFee = Double.parseDouble(rentalFee);
                if (rFee <= 0) {
                    System.out.println("Rental fee must be a positive real number.");
                    return false;
                } else {
                    return true;
                }
            }
        }

        public static boolean validMaxCap (String maxCap) {
            if (!Pattern.matches(MAX_CAP, maxCap)) {
                System.out.println("Maximum capacity must be bigger than 0 and smaller than 20.");
                return false;
            } else {
                int maximumCap = Integer.parseInt(maxCap);
                if (maximumCap <=0 || maximumCap >= 20) {
                    System.out.println("Maximum capacity must be bigger than 0 and smaller than 20.");
                    return false;
                } else {
                    return true;
                }
            }
        }

        public static boolean validFloorNumber (String floorNumber){
            if (!Pattern.matches(FLOOR_NUMBER, floorNumber)) {
                System.out.println("Floor number must be a positive integer.");
                return false;
            } else {
                int fNumber = Integer.parseInt(floorNumber);
                if (fNumber <=0) {
                    System.out.println("Floor number must be a positive integer.");
                    return false;
                } else {
                    return true;
                }
            }
        }

        public static boolean validRentalType (String rentalType){
            if (Pattern.matches(RENTAL_TYPE, rentalType)) {
                return true;
            } else {
                System.out.println("Rental type must begin with a capital character, and normal character onwards.");
                return false;
            }
        }

        public static boolean validRoomStandard (String roomStandard){
            if (Pattern.matches(ROOM_STANDARD, roomStandard)) {
                return true;
            } else {
                System.out.println("Room standard must begin with a capital character, and normal character onwards.");
                return false;
            }
        }

    }
