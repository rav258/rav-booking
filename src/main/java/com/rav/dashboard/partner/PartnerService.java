package com.rav.dashboard.partner;

import com.rav.dashboard.registration.token.ConfirmationToken;
import com.rav.dashboard.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PartnerService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final PartnerRepository partnerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return partnerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpPartner(Partner partner) {
        boolean partnerExist = partnerRepository.findByEmail(partner.getEmail())
                .isPresent();
        if (partnerExist) {
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(partner.getPassword());
        partner.setPassword(encodedPassword);
        partnerRepository.save(partner);
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                partner
        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);


        return token;
    }
    public void enablepartner(String email) {
        partnerRepository.enablePartner(email);
        partnerRepository.updateCategoryToId1(email);
    }



}
