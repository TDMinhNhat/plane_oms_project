package dev.skyherobrine.services.model.qo;

import dev.skyherobrine.library.dto.PageRequestDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Map;

public record ServiceQO(

        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String serviceId,

        @Size(max = 200, message = "Maximum length of this property is 200 characters")
        String serviceName,

        Boolean deleteFlag,

        Map<String, Sort.Direction> sorts,

        @NotNull(message = "This property can not be null or empty")
        PageRequestDto pageRequest
) implements Serializable {
}
