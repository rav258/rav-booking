package com.rav.dashboard.registration;




import com.rav.dashboard.partner.Partner;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "registration")
@AllArgsConstructor
public class PartnerRegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register( Partner request) {
        registrationService.register(request);
        return "redirect:/";
    }


    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


}
