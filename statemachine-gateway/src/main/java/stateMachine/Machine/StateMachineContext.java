package stateMachine.Machine;

import cn.ruix.stateMachine.Dao.PersonRepository;
import cn.ruix.stateMachine.VirtualToolsClass.Person;
import com.alibaba.fastjson.JSON;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateMachineContext {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RedissonClient redissonClient;

    private StateMachineContextData  data = new StateMachineContextData();

    public StateMachineContextData getData() {
        return data;
    }

    public boolean creat(Person person){
        data.setPerson(person);
        redissonClient.getBucket("userId-context-"+person.getUserId()).set(JSON.toJSONString(data));
        System.out.println(redissonClient.getBucket("userId-context-"+person.getUserId()));
        return true;
    }

    public void revoer(Integer userId){
        RBucket<StateMachine> value = redissonClient.getBucket("channel-context-"+userId);


    }

}
