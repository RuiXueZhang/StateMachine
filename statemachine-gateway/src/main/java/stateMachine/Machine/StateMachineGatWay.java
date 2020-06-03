package stateMachine.Machine;

import cn.ruix.stateMachine.StateAndEvent.StateEventBase;
import cn.ruix.stateMachine.VirtualToolsClass.Person;
import cn.ruix.stateMachine.VirtualToolsClass.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StateMachineGatWay {

  @Autowired
  private StateMachineJudge stateMachineJudge;

  @Autowired
  private StateMachineFactory stateMachineFactory;

  public StateMachine initMachine(Person person, PersonInfo personInfo){
      System.out.println("初始化一个状态机");

      Integer schoolId = personInfo.getSchoolId();
      final StateMachine[] machine = new StateMachine[1];
      UUID uuid = UUID.randomUUID();
      /*stateMachineJudge.sentence(
              person,
              StateType.Null,
              person.getStateType()
      );*/
      machine[0] = stateMachineFactory.createMachine(person, personInfo);
      return machine[0];
  }

  public void fireEvent(Integer userId, StateEventBase event){
     System.out.println("创建一个事件");
  }

  public void dispatcherEvent(Integer userId, StateEventBase event){
     System.out.println("分发一个事件");
  }

  public void handleEvent(Integer userId, StateEventBase event){
    System.out.println("处理一个事件");
  }

  public StateMachineContext context(Integer userId){

    StateMachine stateMachine = stateMachineFactory.recoverStateMachine(userId);


    return null;
  }
}
