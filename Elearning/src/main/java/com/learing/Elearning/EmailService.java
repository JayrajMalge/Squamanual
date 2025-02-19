package com.learing.Elearning;


import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    
    private final Map<String, OtpDetails> otpStore = new ConcurrentHashMap<>();
    private static final int OTP_VALID_DURATION = 5;


    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("jayrajmalge@gmail.com");

        mailSender.send(message);
    }
    
     public String generateOtp(String username,String otp) {
        OtpDetails otpDetails = new OtpDetails(otp, LocalDateTime.now());
        otpStore.put(username, otpDetails); 
        return otp;
    }

    public boolean verifyOtp(String username, String otp) {
        OtpDetails otpDetails = otpStore.get(username);
        if (otpDetails == null) {
            return false;
        }

        boolean isValid = otpDetails.getOtp().equals(otp) &&
                otpDetails.getGeneratedAt().plusMinutes(OTP_VALID_DURATION).isAfter(LocalDateTime.now());

        if (isValid) {
            otpStore.remove(username); 
        }
        return isValid;
    }

    private static class OtpDetails {
        private final String otp;
        private final LocalDateTime generatedAt;

        public OtpDetails(String otp, LocalDateTime generatedAt) {
            this.otp = otp;
            this.generatedAt = generatedAt;
        }

        public String getOtp() {
            return otp;
        }

        public LocalDateTime getGeneratedAt() {
            return generatedAt;
        }
    }
}