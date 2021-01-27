package com.mz.partners.resources;

import com.mz.partners.api.PreferencesApi;
import com.mz.partners.models.PartnerPreferences;
import org.springframework.stereotype.Controller;

@Controller
public class PreferencesController implements PreferencesApi {

    public PartnerPreferences getPreferences(String orgId, String partnerId) {
        return PartnerPreferences.builder().build();
    }
}
