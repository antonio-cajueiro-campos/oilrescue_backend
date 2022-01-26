package com.greenprojects.oilrescue.model.dto;

import com.greenprojects.oilrescue.model.entity.DisposalSchedule;
import com.greenprojects.oilrescue.model.entity.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDisposal extends UserEntity {
    DisposalSchedule disposalSchedule;
}
