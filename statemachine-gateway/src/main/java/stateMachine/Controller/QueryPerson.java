package stateMachine.Controller;


import cn.ruix.stateMachine.VirtualToolsClass.PersonInfo;

import com.alibaba.fastjson.JSON;
import jodd.util.StringUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stateMachine.Machine.StateMachineGatWay;
import stateMachine.StateAndEvent.StateType;
import stateMachine.VirtualToolsClass.Person;
import stateMachine.utils.NotifyConfig;
import stateMachine.utils.ScreenConfig;

import java.util.*;

@RestController
public class QueryPerson {

    @Autowired
    private StateMachineGatWay stateMachineGatWay;

    @Autowired
    private NotifyConfig notifyConfig;

    @Autowired
     private CloseableHttpClient httpClient;

    @Autowired
    private ScreenConfig screenConfig;

    @Autowired
    public void start(){
        System.out.println("QueryPerson类被加载了");
    }

    @RequestMapping(value = "/health" ,method = RequestMethod.GET)
    public String info() {
        return "hello I am is computer-serviceB"; //测试代码直接返回一个字符串，不再调用service层等等。
    }

    @RequestMapping(value = "/information",method = RequestMethod.GET)
    public Person queryPerson(){
        Person person = new Person();
        person.setName("张瑞雪");
        person.setAge(22);
        person.setSex("女");
        person.setUserId(123);
        person.setStateType(StateType.Preparing);

        PersonInfo personInfo = new PersonInfo();
        personInfo.setSchool("大学");
        personInfo.setStatus("上学中");
        personInfo.setSchoolId(1111);
        stateMachineGatWay.initMachine(person, personInfo);
        return person;
    }

   // @RequestMapping(value = "/retainAll", method = RequestMethod.GET)
    public static List retainAll(){
        List<String> sdk = new ArrayList();
        sdk.add("rtmp");
        sdk.add("webRTC");
        Set<String> saas = null;
        sdk.retainAll(saas);
        for(String type: sdk){
            System.out.println(type);
        }
        return sdk;
    }

    @RequestMapping(value = "apply", method = RequestMethod.GET)
    public void applyInstance(Integer userId){
        InstanceInApplying instanceInApplying = new InstanceInApplying();
        StateMachineContext context = stateMachineGatWay.context(userId);
        stateMachineGatWay.fireEvent(context.getData().getPerson().getUserId(), instanceInApplying);
    }

    @RequestMapping(value = "config", method = RequestMethod.GET)
    public String getNotifyConfig(){
        String code = "300203064";
        String stopCode = "0000";
        List<Map<String, String>> notifyCode = notifyConfig.getNotifyMap();
        for(Map<String, String> notify: notifyCode){
           for(String arr:notify.keySet())
               if (StringUtil.equals(code, arr)) {
                   stopCode = notify.get(arr);
                   break;
               }
        }
        return "myname:"+ stopCode;
    }

    @RequestMapping(value = "screenConfig", method = RequestMethod.GET)
    public String getScreenConfig(){
        Map<String, ScreenConfig.DpiResolutionInfo> map = screenConfig.getIosInfo();
        ScreenConfig.DpiResolutionInfo result = map.get("iPad7,11");
        String dpi = result.getDpi();
        return dpi;
    }

    @RequestMapping("annotation")
    public String getAnnotation(){

        return null;
    }


    public static void main(String[] args)  {
        /*String key = "pooled-20-95eec4-web-webrtc";
        String[] item = key.split("-");
        System.out.println(item[0]);
        if(item.length == 5){
            System.out.println("不会报错");
        }*/

        /*
        Integer a =3;
        Integer b = 3;
        System.out.println(a.equals(b));
        */

        /*
     String url = "wss://wss-input.haimawan.com:9093/websocket?url=172.16.218.215:7682";
        try {
            System.out.println(hasProxy(url));

            String s = String.format("%s&st=%s,ts=%s,restart=%s,v=%s", "wss://wss-input.haimawan.com:9093/websocket?url=172.16.218.215:7682",
                    "cbfgwlgjsdcbku", "221222222", true, 2);

            System.out.println(s);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    private static boolean hasProxy(String url) throws URISyntaxException {
        boolean hasProxy = false;
        if (url != null) {
            URI uri = new URI(url);
            String path = uri.getRawPath();
            String query = uri.getRawQuery();
            if (path != null && path.contains("websocket") && query != null && query.contains("url")) {
                hasProxy = true;
            }
        }
        return hasProxy;
        */
       Person person = new Person();
       person.setAge(18);
       person.setName("RuiX");
       person.setPhone(14444L);
       person.setSex("女");
       person.setUserId(34);
       person.setSchool("12345");

       if(person instanceof  PersonInfo){
           PersonInfo personInfo = person;
           person.setSchool(null);
           String json = JSON.toJSONString(personInfo);
           System.out.println(json);
       }

    }
}
