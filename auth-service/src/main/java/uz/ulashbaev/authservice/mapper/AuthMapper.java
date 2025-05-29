package uz.ulashbaev.authservice.mapper;


import org.mapstruct.Mapper;
import uz.ulashbaev.authservice.dto.RegisterRequest;
import uz.ulashbaev.authservice.model.User;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    User toEntity(RegisterRequest dto);
}
