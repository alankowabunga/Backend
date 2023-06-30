package com.fullStack.registerCourse.Controller;

import com.fullStack.registerCourse.Model.User;
import com.fullStack.registerCourse.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    //    建立 UserRepository Interface 的 Instance 後使用  constructor injection
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    Create : id 會自動生成，使用者部會輸入此欄位，因此建立 record class 設定接收的對象類型
//    record alterUserRequest(
//            String firstName,
//            String lastName,
//            String email,
//            Integer age
//    ) {
//    }

    @CrossOrigin(origins = "*")
    @PostMapping("/adduser")
    public void addUser(@RequestBody User newUser) {
//        User user = new User();
//        user.setFirst_name(request.firstName());
//        user.setLast_name(request.lastName());
//        user.setEmail(request.email());
//        user.setAge(request.age());
        userRepository.save(newUser);
    }

    //    Read :使用 Generic type 宣告 List<User>，代表該方法返回的是一個使用者對象（User）的清單。
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<User> getUser() {
        return userRepository.findAll();
    }
}
