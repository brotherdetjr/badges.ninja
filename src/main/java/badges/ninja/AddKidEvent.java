package badges.ninja;

public final class AddKidEvent extends DomainEvent {

    private final String value;

    public AddKidEvent(String value) {
        super("addKid");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
