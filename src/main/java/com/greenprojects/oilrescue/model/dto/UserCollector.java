package com.greenprojects.oilrescue.model.dto;

import com.greenprojects.oilrescue.model.entity.CollectionSchedule;
import com.greenprojects.oilrescue.model.entity.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCollector extends UserEntity {
    CollectionSchedule collectionSchedule;
}
