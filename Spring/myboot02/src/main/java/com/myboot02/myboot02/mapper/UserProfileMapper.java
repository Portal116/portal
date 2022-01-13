package com.myboot02.myboot02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.myboot02.myboot02.model.UserProfile;

@Mapper
public interface UserProfileMapper {

//	UserProfile에 있는 모든 자료 조회
	@Select("Select * from t_user")
	List<UserProfile> getUserAllProfile();

//	UserProfile에 있는 자료 조회
	@Select("Select * from t_user where id=#{id}")
	UserProfile getUserProfile(@Param("id") String id);

//	UserProfile에 새로운 내용 추가
	@Insert("insert into t_user values(#{id}, #{name}, #{phone}, #{address})")
	int postUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,
			@Param("address") String address);

//	UserProfile 내용 수정
	@Update("update t_user set name=#{name}, phone=#{phone}, address=#{address} where id =#{id}")
	int putUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,
			@Param("address") String address);

//	UserProfile 삭제
	@Delete("delete from t_user where id=#{id}")
	int deleteUserProfile(@Param("id") String id);
}
