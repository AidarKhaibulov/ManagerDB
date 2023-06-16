package com.mdb.managerdb.services;

import com.mdb.managerdb.entities.Product;
import com.mdb.managerdb.entities.UserEntity;
import com.mdb.managerdb.repositories.ProductRepository;
import com.mdb.managerdb.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class AutoDataGenerator {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final String[] descriptions = {"Лыжи", "Коньки", "Рюкзак", "Ботинки"};
    private final String[] photosUrl = {"https://sun9-39.userapi.com/impg/58sH0FSO9aodaJWCIk9pq8FSN3DHAEDwegddqA/Im9cqWvVVF8.jpg?size=807x807&quality=95&sign=9e697329cd68e05101e44eed0541319c&c_uniq_tag=J3-r9MO9mhyuaMGL3rtaOa5YOTISSQQICtb55sX4d4A&type=album",
            "https://10.img.avito.st/image/1/1.TYdjqLa44W5VASNrdZVGtV0K42jdCWNmFQzjbNMB6WTV.osFN64gjsSBL6ugfA5TDGwcXVzHIGHRPvfc7BPtX0KE",
            "https://90.img.avito.st/image/1/1.gsRGUra4Li1w--woTkydkHPwLCv486wlMPYsL_b7Jifw.Uv_Ji4t5L55h3yF1y_gZ6sah_rUxCgVqyNQ4jUDLGcM",
            "https://80.img.avito.st/image/1/1.JDvX0bawiNL3c-Qixt5Ar2Fwgtj3c-TQYQ.P6i8wkoPJuyq8C0Lh_y6OPIp1yXaCe_Wzc6X3RSt2dk"};
    private final String[] platforms = {"https://vk.com/place_for_tourist?w=wall-110005990_520639",
            "https://www.avito.ru/kazan/sport_i_otdyh/lyzhi_begovye_2816330602",
            "https://vk.com/place_for_tourist?w=wall-110005990_520639",
            "https://www.avito.ru/kazan/sport_i_otdyh/begovye_lyzhi_2897302452"};
    private final String[] usernames = {"Iogann", "Timofei", "Parfen"};
    private final String[] emails = {"ex@example.com", "examp1@example.com", "example@example.com"};
    private final String[] passwords = {"examplepassword1", "examplepassword3", "examplepassword3"};

    private final SecureRandom random = new SecureRandom();



    public <T> T generateData(Class<T> dataType) {
        return switch (dataType.getSimpleName()) {
            case "UserEntity" -> dataType.cast(generateUser());
            case "Product" -> dataType.cast(generateProduct());
            default -> throw new RuntimeException("Invalid class");
        };
    }


    public <T> List<T> generateMultipleData(Class<T> dataType, int numberOfRows) {
        List<T> dataList = new ArrayList<>();

        switch (dataType.getSimpleName()) {
            case "UserEntity" -> {
                for (int i = 0; i < numberOfRows; i++) {
                    dataList.add(dataType.cast(generateUser()));
                }
            }
            case "Product" -> {
                for (int i = 0; i < numberOfRows; i++) {
                    dataList.add(dataType.cast(generateProduct()));
                }
            }
            default -> {
                throw new RuntimeException("Invalid class");
            }
        }

        return dataList;
    }



    private Product generateProduct() {
        int randomIndex = random.nextInt(descriptions.length);
        Product product = Product.builder()
                .description(descriptions[randomIndex])
                .photoUrl(photosUrl[randomIndex])
                .platform(platforms[randomIndex])
                .price(random.nextDouble())
                .title(descriptions[randomIndex]).build();
        productRepository.save(product);
        log.info("Product added {}", product);
        return product;
    }

    private UserEntity generateUser() {
        int randomIndex = random.nextInt(usernames.length);
        UserEntity user = UserEntity.builder()
                .username(usernames[randomIndex])
                .email(emails[randomIndex])
                .password(passwords[randomIndex])
                .build();
        userRepository.save(user);
        log.info("User added {}", user);
        return user;
    }
}
