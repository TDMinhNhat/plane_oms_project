package dev.skyherobrine.services.model.qo;

import dev.skyherobrine.library.dto.PageRequestDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public record CountryQO(

        @Size(max = 30, message = "Maximum length of this property is 30 characters")
        String countryId,

        @Size(max = 200, message = "Maximum length of this property is 200 characters")
        String countryName,

        Boolean deleteFlag,

        Date startCreatedDate,

        Date endCreatedDate,

        Date startUpdatedDate,

        Date endUpdatedDate,

        Map<String, Sort.Order> sorts,

        @NotNull(message = "This property can not be null or empty")
        PageRequestDto page

) implements Serializable {

}
