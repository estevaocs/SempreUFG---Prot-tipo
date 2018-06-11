package br.ufg.sempreufg;

import br.ufg.sempreufg.api.repository.UserRepository;
import br.ufg.sempreufg.api.security.entity.User;
import br.ufg.sempreufg.api.security.enums.ProfileEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class SempreUFGApplication {

	public static void main(String[] args) {
		SpringApplication.run(SempreUFGApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            initUsers(userRepository, passwordEncoder);
        };

    }
    
	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        User admin = new User();
        admin.setEmail("admin@sempreufg.ufg.br");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setProfile(ProfileEnum.ROLE_ADMIN);

        User find = userRepository.findByEmail("admin@sempreufg.ufg.br");
        if (find == null) {
            userRepository.save(admin);
        }
    }
}
