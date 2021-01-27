package com.mz.partners.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PartnerPreferences {
    List<String> pickupLocations;
    List<String> dropOffLocations;
    String pickupContactName;
    String dropOffContactName;
    LocalTime pickupSla;
    LocalTime dropOffSla;
}
