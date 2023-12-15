package a1.test.task.task3.mapper;

import a1.test.task.task3.dto.PostingDto;
import a1.test.task.task3.entity.Posting;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = SPRING)
public interface PostingMapper {
    PostingDto fromEntityToDto(Posting posting);
}
