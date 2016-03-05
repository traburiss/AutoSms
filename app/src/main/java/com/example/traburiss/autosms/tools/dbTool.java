package com.example.traburiss.autosms.tools;

import android.content.Context;

import com.example.traburiss.autosms.constant.Constant;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.model.ConflictAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author traburiss
 * @date 2015年12月8日 下午5:13:59
 * @info dbTool
 * @desc  
 */
public class dbTool {

	public static LiteOrm liteOrm;
	
	public static void InitDB(Context context) {

	    liteOrm = LiteOrm.newCascadeInstance(context, Constant.dbName);
	    liteOrm.setDebugged(true);
    }
	
	public static LiteOrm getLiteOrm() {

	    return liteOrm;
    }
	
	/**
	 * 新增
	 **/
	public static <T> long insert(T t) {

	    return getLiteOrm().save(t);
    }
	/**
	 * 新增多条
	 **/
	public static <T> long insert(List<T> ts) {

		return getLiteOrm().save(ts);
    }

	/**
	 *  删除
	 **/
	public static <T> int Delete(T t) {

		return getLiteOrm().delete(t);
    }
	/**
	 * 删除多条
	 **/
	public static <T> int Delete(List<T> ts) {

		return getLiteOrm().delete(ts);
    }
	
	/**
	 *  修改，其实insert一个作用~~
	 **/    
	public static <T> int update(T t){

		return getLiteOrm().update(t, ConflictAlgorithm.Replace);
	}
	/**
	 * 修改多条，估计用不上。
	 **/
	public static <T> int update(List<T> list){

		return getLiteOrm().update(list);
	}
	
	/**
	 *  查询所有
	 **/
    public static <T> ArrayList<T> search(Class<T> cla) {

    	return getLiteOrm().query(cla);
    }
    public static <T> T search(long id ,Class<T> cla) {

	    return getLiteOrm().queryById(id, cla);
    }
	/**
	 *  搜索
	 **/
    public static <T> ArrayList<T> search(Class<T> cla ,String selection ,String[] values) {

	    return getLiteOrm().query(new QueryBuilder<T>(cla).where(selection, values));
    }
}
