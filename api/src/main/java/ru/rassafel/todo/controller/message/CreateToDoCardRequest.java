package ru.rassafel.todo.controller.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.rassafel.todo.model.IToDoCard;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class CreateToDoCardRequest implements IToDoCard {
    public static final String PROPERTY_SUMMARY = "summary";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PARENT_ID = "parentId";

    @JsonProperty(value = PROPERTY_SUMMARY, required = true)
    private String summary;
    @JsonProperty(value = PROPERTY_DESCRIPTION, required = true)
    private String description;
    @JsonProperty(value = PROPERTY_PARENT_ID)
    private Long parentId;
}
