package com.emranhss.project.service;

import com.emranhss.project.entity.User;
import com.emranhss.project.repository.IUserRepo;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepo  userRepo;

    @Autowired
    private EmailService emailService;

    public void saveOrUpdate(User user) {
        userRepo.save(user);
        sendActivationEmail(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(int id) {
        return userRepo.findById(id).get();
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    private void sendActivationEmail(User user) {
        String subject = "Welcome to Our Service - Confirm Your Registration";

        String mailText = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<style>"
                + "  body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f4f4; padding: 20px; }"
                + "  .container { max-width: 600px; margin: auto; background: white; padding: 30px; border-radius: 12px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); }"
                + "  .header { background: linear-gradient(to right, #00b09b, #96c93d); color: white; padding: 20px; border-radius: 12px 12px 0 0; text-align: center; }"
                + "  .header h2 { margin: 0; font-size: 24px; }"
                + "  .content { padding: 30px 20px; font-size: 16px; color: #333; }"
                + "  .button { display: inline-block; background-color: #00b09b; color: white; padding: 12px 24px; margin-top: 20px; text-decoration: none; border-radius: 6px; font-weight: bold; }"
                + "  .footer { margin-top: 30px; font-size: 0.85em; color: #999; text-align: center; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "  <div class='container'>"
                + "    <div class='header'>"
                + "      <h2>Welcome, " + user.getName() + "!</h2>"
                + "    </div>"
                + "    <div class='content'>"
                + "      <p>Thanks for signing up with <strong>YourCompany</strong>!</p>"
                + "      <p>If you didn’t request this email, please ignore it. This link will expire in 24 hours for your security.</p>"
                + "      <p>Need help? Just reply to this email—we’re always happy to assist!</p>"
                + "      <p>Cheers,<br>Black Spider Support Team</p>"
                + "    </div>"
                + "    <div class='footer'>"
                + "      &copy; " + java.time.Year.now() + " Black Spider. All rights reserved."
                + "    </div>"
                + "  </div>"
                + "</body>"
                + "</html>";

        try {
            emailService.sendSimpleMail(user.getEmail(), subject, mailText);
        }catch (MessagingException e){
            throw new RuntimeException(e);
        }

    }
}
