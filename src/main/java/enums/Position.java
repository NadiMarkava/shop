package enums;

public enum Position {

    HEADMASTER("Headmaster"),
    HEAD_OF_ACCOUNTANT("Head Accountant"),
    HEAD_SALESMAN("Head Salesman"),
    SALESMAN("Salesman");

    private final String positionName;

    Position(String positionName) {
        this.positionName = positionName;
    }
}
