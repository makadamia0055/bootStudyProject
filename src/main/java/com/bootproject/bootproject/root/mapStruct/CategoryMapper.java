package com.bootproject.bootproject.root.mapStruct;

import com.bootproject.bootproject.root.entity.Category;
import com.bootproject.bootproject.root.vo.CategoryVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryVO toVO(Category category);

    Category toEntity(CategoryVO category);
}
