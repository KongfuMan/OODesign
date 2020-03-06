package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Elevator {
    private List<Button> buttons;
    private PriorityQueue<Integer> upStops;
    private PriorityQueue<Integer> downStops;
    private int currLevel;
    private Status status;

    public Elevator(int total, int currLevel){
        buttons = new ArrayList<>();
        for (int i = 1;  i <= total; i++){
            buttons.add(new Button(i + 1, this));
        }
        upStops = new PriorityQueue<>();
        downStops = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        status = Status.IDLE;
        // 这里需要ElevatorSystem进行调用，它先指挥该Elevator到达指定楼层，然后设置currLevel;
        this.currLevel = currLevel;
    }

    // use case 2: take external request
    // add the request level to corresponding stop list
    public void handleExternalRequest(ExternalRequest request){
        int reqLevel = request.getLevel();
        if (request.getDir() == Direction.UP){
            upStops.add(reqLevel);
        }else{
            downStops.add(reqLevel);
        }
    }

    // use case 3: take internal request
    // add the requested level to stop list
    public void handleInternalRequest(InternalRequest request){

    }


    // use case 4: Open gate
    public void openGate(){

    }

    // use case 5: Close gate
    public void closeGate(){

    }

    private boolean isInternalRequestValid(InternalRequest req){
        if (status == Status.UP && req.getLevel() < currLevel){
            return false;
        }
        if (status == Status.DOWN && req.getLevel() > currLevel){
            return  false;
        }
        return true;
    }

}
