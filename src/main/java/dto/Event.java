package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Event {
    String title;
    String type;
    int breaks;
    int amount;

}
