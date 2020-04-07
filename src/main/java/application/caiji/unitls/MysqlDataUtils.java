package application.caiji.unitls;

import org.junit.Test;

import com.alibaba.druid.util.StringUtils;

public class MysqlDataUtils {
	
	@Test
	public void test(){
		String column[]={"A","B"};
		System.out.println(MysqlDataUtils.getInsertSqlTheFull(column, "tablenameL", 4, false));
		System.out.println(MysqlDataUtils.getInsertSqlIsCovering(column));
	}
	/**
	 * 传入字段列表拼装insert sql语句
	 * column 字段列表数组
	 * tablename 表名
	 * valueslength 插入的所有值的长度
	 * isCovering是否生成重复更新语句
	 * 
	 * 拼装失败返回null
	 */
	public static String getInsertSqlTheFull(String[] column,String tablename,int valueslength,boolean isCovering){
		String sql=null;
		if(column.length>0&&!StringUtils.isEmpty(tablename)){
			if(valueslength%column.length!=0){
				System.out.println("sql错误:字段数量与值数量不匹配");
				return null;
			}
			String strcolumn="",placeholder="",updateColumn="";
			for (int i = 0; i < column.length; i++) {
				strcolumn+="`"+column[i]+"`,";
				updateColumn+="`"+column[i]+"`=values(`"+column[i]+"`),";
			}
			// 0,1,2,3
			for (int i = 0; i < valueslength; i++) {
				if(i%column.length==0){
					if(i>0){
						placeholder=placeholder.substring(0,placeholder.length()-1);
						placeholder+="),";
						placeholder+="(?,";
					}else{
						placeholder="(?,";
					}
				}else{
					placeholder+="?,";
				}
			}
			placeholder=placeholder.substring(0, placeholder.length()-1);
			placeholder+=")";
			strcolumn=strcolumn.substring(0,strcolumn.length()-1);
			sql="insert into "+tablename+"("+strcolumn+") values"+placeholder;
			if(isCovering){
				updateColumn=updateColumn.substring(0,updateColumn.length()-1);
				sql+=" ON DUPLICATE KEY UPDATE "+updateColumn;
			}
		}
		return sql;
	}
	
	/**
	 * 传入字段列表拼装sql DUPLICATE
	 * column字段列表数组
	 */
	public static String getInsertSqlIsCovering(String[] column){
		String sql=null;
		if(column.length>0){
			String updateColumn="";
			for (int i = 0; i < column.length; i++) {
				updateColumn+="`"+column[i]+"`=values(`"+column[i]+"`),";
			}
			updateColumn=updateColumn.substring(0,updateColumn.length()-1);
			sql=" ON DUPLICATE KEY UPDATE "+updateColumn;
		}
		return sql;
	}

}
