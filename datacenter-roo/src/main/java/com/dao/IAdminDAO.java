package com.dao;

import com.bean.AdminBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IAdminDAO {
	
	/*添加管理员对象*/
	@Insert("insert into roo_admin(ADMIN_ID,NAME,SEX,ACCESS_NUM,PASSWORD,START_DATE,DONE_DATE,TYPE,PICTURE,REMARKS,STATE,EXT_1,EXT_2,EXT_3)" +
			"values(#{adminId},#{name},#{sex},#{accessNum},#{password},#{startDate},#{doneDate},#{type},#{picture},#{remarks},#{state},#{ext_1},#{ext_2},#{ext_3})")
	public int addAdmin(AdminBean user);

	/*根据管理员手机号码，密码查询管理员对象*/
	@Select("select * from roo_admin where ACCESS_NUM = #{accessNum} and PASSWORD = #{password} and state='U'")
	public AdminBean[] qryAdminByAccessNumAndPswd(@Param("accessNum") String accessNum, @Param("password") String password);
}
