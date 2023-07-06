package com.fullStack.registerCourse.Controller;

import com.fullStack.registerCourse.Model.User;
import com.fullStack.registerCourse.Repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import com.fullStack.registerCourse.Exception.UserNotFoundException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/users")
public class UserController {

    //    建立 UserRepository Interface 的 Instance 後使用  constructor injection
    UserRepository userRepository;
//   當 Class 只有一個 Construtor 構造函數時，可以省略 @Autowired 註釋，Spring將自動檢測到這個構造函數並自動注入相應的依賴項。

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


    @PostMapping("/post")
    public void addUser(@RequestBody User newUser) {
//        User user = new User();
//        user.setFirst_name(request.firstName());
//        user.setLast_name(request.lastName());
//        user.setEmail(request.email());
//        user.setAge(request.age());
        userRepository.save(newUser);
    }

    //    Read :使用 Generic type 宣告 List<User>，代表該方法返回的是一個使用者對象（User）的清單。
    @GetMapping
    public List<User> getUser() {
        return userRepository.findAll();
    }

//    根據 user id 搜尋(Read)
    @GetMapping("/{id}")
    User getUserById(@PathVariable Integer id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

//    根據 user id 更新(Update)
    @PutMapping("/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                            user.setFirst_name(newUser.getFirst_name());
                            user.setLast_name(newUser.getLast_name());
                            user.setEmail(newUser.getEmail());
                            user.setAge(newUser.getAge());
                            return userRepository.save(user);
                        }).orElseThrow(()->new UserNotFoundException(id));
    }

//    根據 user id 更新(Update) user
    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable Integer id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with ID :"+ id + "has been deleted.";
    }
}
