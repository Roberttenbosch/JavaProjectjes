package com.flutter.app;

import com.flutter.app.Image.model.Image;
import com.flutter.app.Image.model.ImageType;
import com.flutter.app.User.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class InitDatabaseMock
{
    @Bean
    CommandLineRunner init_image(MongoOperations operations)
    {
        return args -> {
            operations.dropCollection(Image.class);
            operations.insert(new Image("2f0b3e77-d6e3-491b-8be4-8656d9b028f3",
                    "achtergrond.jpg","url","1", ImageType.BACKGROND));
            operations.insert(new Image("a9d66c83-b081-4f5f-be49-c1cff3c2c2fe",
                    "kat.jpg", "url", "1", ImageType.AVATAR));
            operations.insert(new Image("e59a0c51-a4d3-423a-bdc4-836db5ab8fa1",
                    "3.png", "url", "1", ImageType.NORMAL));
            operations.findAll(Image.class).forEach(image -> {
                System.out.println(image.toString());
            });
        };
    }

    @Bean
    CommandLineRunner init_user(MongoOperations operations)
    {
        return args -> {
            operations.dropCollection(User.class);
            operations.insert(new User("1",
                    "voornaam",
                    "achternaam",
                    "http://localhost:8080/image/1/avatar",
                    "http://localhost:8080/image/1/background",
                        "een korte biografie!!!",
                    "Stad"
                    ));
            operations.findAll(User.class).forEach(user -> {
                System.out.println(user.toString());
            });
        };
    }
}
