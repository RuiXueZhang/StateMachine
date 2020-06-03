package cn.ruix.Stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class verifyStreamType {

    public static void main(String[] args){

        List<String> streamTypesBySDK = new ArrayList<>();
        streamTypesBySDK.add("RTMP");
        streamTypesBySDK.add("H5");
        streamTypesBySDK.add("WEBRTC");

        Map streamTypes = new HashMap<String,Integer>();
        streamTypes.put("RTMP",0);
        streamTypes.put("H5",0);
        streamTypes.put("WEBRTC",0);

        if (streamTypesBySDK.size() > 0) {
            Integer temp = -1;
            String type = null;
            Integer rank = -1;
            for (Object streamtype : streamTypesBySDK) {
                rank = (Integer) (streamTypes.get(streamtype));
                if (rank > temp) {
                    temp = rank;
                    type = (String) streamtype;
                }
            }
            System.out.println(type);

        }

        for(String streamType : streamTypesBySDK){
            if((streamType.equals("RTMP"))){
                continue;
            }
            System.out.println(streamType);
        }
    }

}
