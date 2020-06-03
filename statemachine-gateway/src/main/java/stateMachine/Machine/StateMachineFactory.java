package stateMachine.Machine;

import cn.ruix.stateMachine.StateAndEvent.StateBase;
import cn.ruix.stateMachine.StateAndEvent.StateType;
import cn.ruix.stateMachine.VirtualToolsClass.Person;
import cn.ruix.stateMachine.VirtualToolsClass.PersonInfo;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StateMachineFactory {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private ApplicationContext applicationContext;

    public StateMachine createMachine(Person person, PersonInfo personInfo){
        StateMachineContext context = creatContext();
        context.getData().setPerson(person);
        context.getData().setPersonInfo(personInfo);
        if(context.creat(person)) {
            StateMachine stateMachine = new StateMachine();
            applicationContext.getAutowireCapableBeanFactory().autowireBean(StateMachine.class);
            stateMachine.setContext(context);
            stateMachine.changeState(person.getStateType(), null);
            return stateMachine;
        }
        return null;
    }

    private StateMachineContext creatContext(){
        StateMachineContext stateMachineContext = new StateMachineContext();
        applicationContext.getAutowireCapableBeanFactory().autowireBean(stateMachineContext);
        return stateMachineContext;
    }

    public StateBase creatState(StateMachine machine, StateType stateType){

       Class<? extends StateBase> clazz = StateBase.getClazz(stateType);
       if(clazz != null){
           StateBase stateBase = new StateBase(stateType);
           applicationContext.getAutowireCapableBeanFactory().autowireBean(stateBase);
           stateBase.setStateMachine(machine);
           return stateBase;
       }
        return null;
    }

    public StateMachine recoverStateMachine(Integer userId){

         StateMachineContext context = creatContext();
         context.revoer(userId);

          return null;
    }

}
