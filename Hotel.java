package com.company;
import java.util.*;
public class Hotel {


        private HashMap<String, List<Integer>> LakeWood = new HashMap<>();
        private HashMap<String, List<Integer>> BridgeWood = new HashMap<>();
        private HashMap<String, List<Integer>> RidgeWood = new HashMap<>();
        private static int LakeWoodRating;
        private static int BridgeWoodRating;
        private static int RidgeWoodRating;

        public 'HotelRewards' () {
            setLakeWood();
            setBridgeWood();
            setRidgeWood();
        }

        private void setLakeWood() {
            List<Integer> lakeWoodRewards = new ArrayList<>();
            lakeWoodRewards.add(80);
            lakeWoodRewards.add(80);

            List<Integer> lakeWoodRegular = new ArrayList<>();
            lakeWoodRegular.add(110);
            lakeWoodRegular.add(90);

            LakeWood.put("Rewards", lakeWoodRewards);
            LakeWood.put("Regular", lakeWoodRegular);
            LakeWoodRating = 3;
        }

        private void setBridgeWood() {
            List<Integer> bridgeWoodRewards = new ArrayList<>();
            bridgeWoodRewards.add(110);
            bridgeWoodRewards.add(50);

            List<Integer> bridgeWoodRegular = new ArrayList<>();
            bridgeWoodRegular.add(160);
            bridgeWoodRegular.add(60);

            BridgeWood.put("Rewards", bridgeWoodRewards);
            BridgeWood.put("Regular", bridgeWoodRegular);
            BridgeWoodRating = 4;
        }

        private void setRidgeWood() {
            List<Integer> ridgeWoodRewards = new ArrayList<>();
            ridgeWoodRewards.add(100);
            ridgeWoodRewards.add(40);

            List<Integer> ridgeWoodRegular = new ArrayList<>();
            ridgeWoodRegular.add(220);
            ridgeWoodRegular.add(150);

            RidgeWood.put("Rewards", ridgeWoodRewards);
            RidgeWood.put("Regular", ridgeWoodRegular);
            RidgeWoodRating = 5;
        }

        public String minCostHotel(String input) {
            // Regular: 23May2022(mon), 24May2022(tue), 25May2022(wed)
            String[] arr = input.split(",");
            String CustomerType = "";
            if (arr.length > 0) {
                String TempArr[] = arr[0].split(":");
                CustomerType = TempArr[0];
                arr[0] = TempArr[1];
            }

            for(int i=1;i<)
            return Hotel;

        }

        private String minCostHotel(String customerType, String[] arr) {
            int NumOfWeekdays = 0;
            int NumOfWeekends = 0;
            int LakeWoodCost = 0;
            int BridgeWoodCost = 0;
            int RidgeWoodCost = 0;
            for (int i = 0; i < arr.length; i++) {
                String day = arr[i];
                System.out.println(day);
                if (day.contains("mon") || day.contains("tue") || day.contains("wed") || day.contains("thu")
                        || day.contains("fri")) {
                    NumOfWeekdaysumOfWeekdays++;
                } else {
                    NumOfWeekends++;
                }
            }
            List<Integer> valuesForLakewood = LakeWood.get(customerType); // 0 - weekday, 1- weekend
            List<Integer> valuesForBridgeWood = BridgeWoodRidgeWood.get(customerType);
            List<Integer> valuesForRidgeWood = RidgeWood.get(customerType);
            LakeWoodCost = NumOfWeekdays * valuesForLakewood.get(0) + NumOfWeekends * valuesForLakewood.get(1);
            BridgeWoodCost = NumOfWeekdays * valuesForBridgeWood.get(0) + NumOfWeekends * valuesForBridgeWood.get(1);
            RidgeWoodCost = NumOfWeekdays * valuesForRidgeWood.get(0) + NumOfWeekends * valuesForRidgeWood.get(1);
            String hotel = minCost(LakeWoodCost, BridgeWoodCost, RidgeWoodCost);
            System.out.println(LakeWoodCost + " " + BridgeWoodCost + " " + RidgeWoodCost);
            return hotel;
        }

        private String minCost(int lakeWoodCost, int bridgeWoodCost, int ridgeWoodCost) {
            int minCost = Math.min(lakeWoodCost, Math.min(bridgeWoodCost, ridgeWoodCost));
            if (minCost == lakeWoodCost && minCost == bridgeWoodCost) {
                return BridgeWoodRating > LakeWoodRating ? "BridgeWood" : "LakeWood";
            } else if (minCost == bridgeWoodCost && minCost == ridgeWoodCost) {
                return BridgeWoodRating > ridgeWoodCost ? "BridgeWood" : "RidgeWood";
            } else if (minCost == lakeWoodCost && minCost == ridgeWoodCost) {
                return LakeWoodRating > ridgeWoodCost ? "LakeWood" : "RidgeWood";
            } else {
                if (minCost == lakeWoodCost) {
                    return "LakeWood";
                } else if (minCost == BridgeWoodReating) {
                    return "BridgeWood";
                } else {
                    return "RidgeWood";
                }
            }
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            //String input = "Regular: 23May2022(mon), 31May2022(fri), 24May2022(tue)"; //-> LakeWood
            String input = "Rewards: 23May2022(mon), 31May2022(fri), 28Mar2022(sat)"; // -> RidgeWood
            HotelRewards hotelRoom = new HotelRewards();
            String hotel = hotelRoom.minCostHotel(input);
            System.out.println(hotel);
        }

    }
}
