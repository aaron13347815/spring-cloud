package com.yuecheng.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuecheng.base.service.UserService;
import com.yuecheng.base.vo.ResultVo;
import com.yuecheng.base.vo.UserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api("用户资源接口")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**查询用户列表*/
	@ApiOperation(value="获取用户列表", notes="根据query参数条件来查询")
    @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "UserVO", paramType = "query")
	@GetMapping("/user")
	public ResultVo<Object> queryUserPage(UserVO userVO) {
		ResultVo<Object> result = new ResultVo<Object>();
		return result.success(userService.queryUserPage(userVO));
	}
	
	/**查询单个用户*/
	@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String", paramType = "path")
	@GetMapping("/user/{userId}")
	public ResultVo<Object> queryById(@PathVariable String userId) {
		ResultVo<Object> result = new ResultVo<Object>();
		return result.success(userService.queryById(userId));
	}
	/**新增用户*/
	@ApiOperation(value="新增用户信息", notes="根据request中的对象列表批量存储")
	@ApiImplicitParam(name = "users", value = "用户实体集合users", required = true, dataType = "List", paramType = "body")
	@PostMapping("/user")
	public ResultVo<Object> insertRecords(@RequestBody List<UserVO> users) {
		ResultVo<Object> result = new ResultVo<Object>();
		userService.insertRecords(users);
		return result.success("新增成功");
	}
	/**修改用户*/
	@ApiOperation(value="修改用户信息", notes="根据request的对象修改")
	@ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "UserVO", paramType = "body")
	@PatchMapping("/user")
	public ResultVo<Object> updateUserById(@RequestBody UserVO userVO) {
		ResultVo<Object> result = new ResultVo<Object>();
		userService.updateUserById(userVO);
		return result.success("修改成功");
	}
	/**删除用户*/
	@ApiOperation(value="删除用户信息", notes="根据url的id来删除用户信息")
	@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String",paramType = "path")
	@DeleteMapping("/user/{userId}")
	public ResultVo<Object> deleteUserById(@PathVariable String userId) {
		ResultVo<Object> result = new ResultVo<Object>();
		userService.deleteUserById(userId);
		return result.success("删除成功");
	}
}
