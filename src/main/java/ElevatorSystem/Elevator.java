package ElevatorSystem;

import ElevatorSystem.Exceptions.ExceedsMaxWeightException;
import ElevatorSystem.Exceptions.IllegalLevelException;
import ElevatorSystem.Exceptions.InvalidInternalRequestException;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static ElevatorSystem.Status.*;

/**
 * This is actually the elevator controller that controls the elevator bus.
 * <p>
 * There should be a while loop that drives the move of elevator
 * Multi threads is not considered in this class
 */
public class Elevator {
    private final int MAX_WEIGHT = 1000;

    private List<Button> buttons;
    private PriorityQueue<Integer> upStops;
    private PriorityQueue<Integer> downStops;
    private int currLevel;
    private int MAX_LEVEL;
    private int MIN_LEVEL;
    private Status status;

    public Elevator(int total, int currLevel) {
        buttons = new ArrayList<>();
        for (int i = 1; i <= total; i++) {
            buttons.add(new Button(i + 1, this));
        }
        upStops = new PriorityQueue<>();
        downStops = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        status = Status.IDLE;
        // 这里需要ElevatorSystem进行调用，它先指挥该Elevator到达指定楼层，然后设置currLevel;
        this.currLevel = currLevel;
        MAX_LEVEL = total;
        MIN_LEVEL = 1;
    }

    /**
     * use case 2: take external request with a direction
     * add the request level to corresponding stop list
     */
    public void handleExternalRequest(ExternalRequest request) {
        int reqLevel = request.getCurrenLevel();
        if (request.getDir() == Direction.UP) {
            upStops.offer(reqLevel);
        } else {
            downStops.offer(reqLevel);
        }
    }

    /**
     * use case 3: take internal request
     * <p>
     * add the requested destination level to stop list
     */
    public void handleInternalRequest(InternalRequest request) throws InvalidInternalRequestException {
        if (!isInternalRequestValid(request)) {
            throw new InvalidInternalRequestException();
        }
        if (status == UP) {
            upStops.offer(request.getDestinationLevel());
        }
        if (status == DOWN) {
            downStops.offer(request.getDestinationLevel());
        }
    }


    /**
     * use case 4: Stop and Open gate
     * if status is down,
     */
    public void openGate() {
        if (status == DOWN) {
            downStops.poll();
        } else if (status == UP) {
            upStops.poll();
        }
    }

    private void move(int level) throws IllegalLevelException {
        if (level < MIN_LEVEL || level > MAX_LEVEL) {
            throw new IllegalLevelException();
        }
        currLevel = level;
    }

    /**
     * use case 5: Close gate
     */
    public void closeGate() throws ExceedsMaxWeightException, IllegalLevelException {
        if (!checkWeight()) {
            throw new ExceedsMaxWeightException();
        }
        if (status == UP) {
            if (upStops.size() != 0) {
                // move to the upStops.poll()
                move(upStops.peek());
            } else if (downStops.size() != 0) {
                status = DOWN;
                //move the the downStops.poll();
                move(downStops.peek());
            } else {
                status = IDLE;
            }
        } else if (status == DOWN) {
            if (downStops.size() != 0) {
                // move to the downStops.poll();
                move(downStops.peek());
            } else if (upStops.size() != 0) {
                status = UP;
                // move to the upStops.poll();
                move(upStops.peek());
            } else {
                status = IDLE;
            }
        } else {
            if (upStops.size() != 0) {
                status = UP;
                //move the upStops.poll();
                move(upStops.peek());
            } else if (downStops.size() != 0) {
                status = DOWN;
                // move to the downStops.poll();
                move(downStops.peek());
            }
        }
    }

    /**
     * user can not request lower level if elevator is going up
     * upper level if                   down
     */
    private boolean isInternalRequestValid(InternalRequest req) {
        if (status == Status.UP && req.getDestinationLevel() < currLevel) {
            return false;
        }
        if (status == DOWN && req.getDestinationLevel() > currLevel) {
            return false;
        }
        return true;
    }

    private boolean checkWeight() {
        return true;
    }

    public int getCurrLevel() {
        return currLevel;
    }
}
