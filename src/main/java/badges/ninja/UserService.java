package badges.ninja;

import org.pcollections.PVector;
import org.pcollections.TreePVector;

import javax.inject.Singleton;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public final class UserService {

    private final Map<String, UserEvents> data = new ConcurrentHashMap<>();

    public void addKid(String user, String kid) {
        data.compute(user, (u, events) -> {
            AddKidEvent event = new AddKidEvent(kid);
            if (events != null) {
                return events.plusEvent(event);
            } else {
                return new UserEvents(TreePVector.singleton(event));
            }
        });
    }

    private static final class UserEvents {
        private final PVector<? super Object> events;

        public UserEvents(PVector<? super Object> events) {
            this.events = events;
        }

        public <T> UserEvents plusEvent(T event) {
            return new UserEvents(events.plus(event));
        }
    }
}
