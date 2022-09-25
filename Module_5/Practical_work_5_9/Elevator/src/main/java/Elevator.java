public class Elevator {
    private int currentFloor = 1;
    private final int minFloor;
    private final int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        if (currentFloor <= maxFloor && currentFloor > minFloor) {
            currentFloor--;
        }
    }

    public void moveUp() {
        if (currentFloor >= minFloor && currentFloor < maxFloor) {
            currentFloor++;
        }
    }

    public void move(int floor) {
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Неверно введен номер этажа. Он должен быть в пределах от "
                    + minFloor + " до " + maxFloor + ".");
        } else if (floor == currentFloor) {
            System.out.println("Вы уже находитесь на выбранном этаже.");
        } else if (floor < currentFloor) {
            while (floor != currentFloor) {
                moveDown();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Текущий этаж: " + currentFloor);
            }
        } else {
            while (floor != currentFloor) {
                moveUp();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Текущий этаж: " + currentFloor);
            }
        }
    }
}

