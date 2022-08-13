package com.example.demo.contorll;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.utils.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    UserMapper userMapper;

    @GetMapping(value = "/get", name = "hello world")
    public List<User> getAllUsers() {
        System.out.println("是否请求到这");
        return userMapper.getAllUser();
    }

    @PostMapping("/instert")
    public ApiResult addUser(@RequestBody User user) {
        System.out.println(user.getName() + "JJ");
        if (StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            return setResult(400, "没有带有参数", "随便传点啥");
        }
        int count = userMapper.insertUser(user);
        if (count > 0) {
            return setResult(200, "保存成功", String.valueOf(count));
        }
        return setResult(500, "保存失败", String.valueOf(count));
    }

    @PostMapping("/update")
    public ApiResult update(@RequestBody User users) {
        if (StringUtils.isEmpty(users.getId()) || StringUtils.isEmpty(users.getName()) || StringUtils.isEmpty(users.getPassword())) {
            return setResult(400, "没有带有参数", "随便传点啥");
        }
        User user = userMapper.getUserById(users.getId());
        if (user == null) {
            return setResult(400, "没有相应数据", "随便传点啥");
        }
        int resCount = userMapper.insertUser(users);
        if (resCount > 0) {
            return setResult(200, "更新成功", String.valueOf(resCount));
        }
        return setResult(400, "更新失败", null);
    }

    @RequestMapping(value = "/delete/{id}", name = "delete")
    public ApiResult delete(@PathVariable String id) {
        String rowId = id.split("=")[1];
        System.out.println(rowId);
        int idRow = Integer.parseInt(rowId);
        try {
            Integer row = userMapper.deleteUserById(idRow);
            System.out.println(row instanceof Integer);
            if (row > 0) {
                return setResult(200, "刪除成功", String.valueOf(row));
            }
            if (row == 0) {
                return setResult(200, "沒有數據可以刪除", String.valueOf(row));
            }
        } catch (Exception e) {
            return setResult(200, "刪除失敗", "");
        }
        return null;
    }

    public static ApiResult setResult(Integer code, String msg, String data) {
        ApiResult apiResult = new ApiResult();
        apiResult.setCode(code);
        apiResult.setMessage(msg);
        apiResult.setData(data);
        return apiResult;
    }
}
