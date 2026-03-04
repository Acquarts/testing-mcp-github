package CTTI;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class RolMapper {
    public TbRolResponse toDto(TbRol entity) {
        if (entity == null) {
            return null;
        }
        TbRolResponse dto = new TbRolResponse();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }

    public List<TbRolResponse> toDtoList(List<TbRol> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
