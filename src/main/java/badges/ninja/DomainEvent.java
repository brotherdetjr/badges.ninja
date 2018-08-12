package badges.ninja;

public abstract class DomainEvent {
    private final String type;

    public DomainEvent(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
